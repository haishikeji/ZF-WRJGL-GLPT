package com.px.web.controller.geo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CoordinateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.px.common.core.domain.AjaxResult;
import com.px.framework.aes.AesSecurityParameter;
import com.px.web.controller.domain.Area;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@Api("设备审核记录")
@RestController
@RequestMapping("geo")
public class GeoAreaController {

    @ApiOperation("查询禁飞区(大疆)")
    @GetMapping("areas")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult safeArea(@RequestParam("lng") String lng,@RequestParam("lat") String lat,@RequestParam("country") String country,
                               @RequestParam("search_radius") String search_radius,@RequestParam("drone") String drone,@RequestParam("level") String level,
                               @RequestParam("zones_mode") String zones_mode) {
        String geoAreaApiUrl = "https://www-api.dji.com/cn/api/geo/areas";

        Map<String, Object> queryStr = new HashMap<>();
        queryStr.put("lng", lng);
        queryStr.put("lat", lat);
        queryStr.put("country", country);
        queryStr.put("search_radius", search_radius);
        queryStr.put("drone", drone);
        queryStr.put("level", level);
        queryStr.put("zones_mode", zones_mode);

        String getUrl = HttpUtil.urlWithForm(geoAreaApiUrl, queryStr, Charset.defaultCharset(), false);
        HttpRequest get = HttpUtil.createGet(getUrl, true);

        String geoStr = get.execute().body();
        return AjaxResult.success(geoStr);

    }

    @GetMapping("inputtips")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult inputtips(@RequestParam("keywords") String keywords) {
        String inputtipsApiUrl = "https://digital-elevation.djigate.com/amap-proxy/64d9d5/v3/assistant/inputtips";

        Map<String, Object> queryStr = new HashMap<>();
        queryStr.put("keywords", keywords);
        queryStr.put("language", "zh-CN");

        String getUrl = HttpUtil.urlWithForm(inputtipsApiUrl, queryStr, Charset.defaultCharset(), false);
        HttpRequest get = HttpUtil.createGet(getUrl, true);

        String resultStr = get.execute().body();
        return AjaxResult.success(JSONUtil.parseObj(resultStr));

    }

    @ApiOperation("对角点查询禁飞区(自持)")
    @GetMapping("areas/pointSearch")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult areasSearch(@ApiParam(value = "右上坐标,如115.8,41", required = true) @RequestParam("eastNorth") String eastNorth,
                                  @ApiParam(value = "左下坐标,如113,30.2", required = true) @RequestParam("westSouth") String westSouth,
                                  @ApiParam("是否启用生效时间过滤.0:否,1:是") @RequestParam(value = "expired", defaultValue = "1", required = false) int expired,
                                  @ApiParam("显示的区域级别,逗号分隔") @RequestParam(value = "level", required = false, defaultValue = "1,2,3") String level) {
        // 将高德左边转成GPS
        List<String> points = new ArrayList<>();
        points.add(eastNorth);
        points.add(westSouth);

        return areasSearch(points, expired, level);
    }

    @ApiOperation("查询禁飞区(自持)")
    @GetMapping("areas/search")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult areasSearch(@RequestParam("point") List<String> points,
                                  @ApiParam("是否启用生效时间过滤.0:否,1:是") @RequestParam(value = "expired", required = false, defaultValue = "1") int expired,
                                  @ApiParam("显示的区域级别,逗号分隔") @RequestParam(value = "level", required = false, defaultValue = "1,2,3") String level) {
        String geoAreaApiUrl = "http://localhost:7777/area/search";
        // 将高德左边转成GPS
        List<CoordinateUtil.Coordinate> collect = points.stream()
                .map(p -> {
                    String lng = p.split(",")[0];
                    String lat = p.split(",")[1];
                    return CoordinateUtil.gcj02ToWgs84(NumberUtil.parseDouble(lng), NumberUtil.parseDouble(lat));
                }).collect(Collectors.toList());

        String query = collect.stream().map(c -> String.format("point=%s,%s", c.getLng(), c.getLat())).collect(Collectors.joining("&"));

        String getUrl = HttpUtil.urlWithForm(geoAreaApiUrl, query, Charset.defaultCharset(), false);

        HttpRequest get = HttpUtil.createGet(getUrl, true);

        String geoStr = get.execute().body();
        JSONObject resultJson = JSONUtil.parseObj(geoStr);
        if (200 == resultJson.getInt("code")) {
            if (!resultJson.isNull("data")) {
                List<Area> data = JSONUtil.toList(resultJson.getStr("data"), Area.class);
                data.forEach(a -> setPatentInfo(a, a.getSubAreas()));
                // 删除临时限飞区中过期区域
                if (expired == 1) {
                    data.removeIf(a -> {
                        Long min = null == a.getBeginAt() || 0 == a.getBeginAt() ? Long.MIN_VALUE : a.getBeginAt();
                        Long max = null == a.getEndAt() || 0 == a.getEndAt() ? Long.MAX_VALUE : a.getEndAt();
                        Long current = System.currentTimeMillis() / 1000;
                        return !(min <= current && current <= max);
                    });
                }
                // 按区域级别过滤
                String[] split = level.split(",");
                data.removeIf(a -> !ArrayUtil.contains(split, a.getLevel() + ""));

                return AjaxResult.success(data);
            } else {
                return AjaxResult.success(new ArrayList<>());
            }
        } else {
            return AjaxResult.success(JSONUtil.parseObj(geoStr).get("message"));
        }
    }

    @ApiOperation("删除禁飞区")
    @DeleteMapping("areas/{idPath}")
    @AesSecurityParameter(outEncode = true)
    @PreAuthorize("@ss.hasPermi('geo:area:edit')")
    public AjaxResult delAreas(@PathVariable("idPath") String idPath) {
        String geoAreaApiUrl = "http://localhost:7777/area";

        HttpRequest request = HttpUtil.createRequest(Method.DELETE, geoAreaApiUrl + "/" + idPath);
        String body = request.execute().body();

        JSONObject resultJson = JSONUtil.parseObj(body);
        if (200 == resultJson.getInt("code")) {
            return AjaxResult.success();
        } else {
            return AjaxResult.success(resultJson.get("message"));
        }
    }


    @ApiOperation("新增禁飞区")
    @PostMapping("areas")
    @AesSecurityParameter(outEncode = true)
    @PreAuthorize("@ss.hasPermi('geo:area:edit')")
    public AjaxResult addAreas(@RequestBody Area entity) {
        entity.setExternal("false");

        String geoAreaApiUrl = "http://localhost:7777/area";
        // 将传入的高度坐标系转成GPS坐标系
        Double[] convert = convert(entity.getLng(), entity.getLat());
        entity.setLng(BigDecimal.valueOf(convert[0]));
        entity.setLat(BigDecimal.valueOf(convert[1]));
        if (null != entity.getPolygonPoints()) {
            entity.setPolygonPoints(convert(entity.getPolygonPoints()));
        }
        if (CollUtil.isNotEmpty(entity.getSubAreas())) {
            entity.getSubAreas().forEach(p -> p.setPolygonPoints(convert(p.getPolygonPoints())));
        }

        String body = HttpUtil.post(geoAreaApiUrl, JSONUtil.toJsonStr(entity));
        JSONObject resultJson = JSONUtil.parseObj(body);
        if (200 == resultJson.getInt("code")) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(resultJson.getStr("message"));
        }
    }

    /**
     * 将高德坐标转成GPS坐标
     * @param points 高德坐标点集合
     * @return
     */
    private JSONArray convert(JSONArray points) {
        JSONArray result = new JSONArray();

        List<List<Double>> pointList = (List<List<Double>>) points.get(0);
        List<List<Double>> collect = pointList.stream().map(p -> {
            List<Double> gps = new ArrayList<>();
            CoordinateUtil.Coordinate coordinate = CoordinateUtil.gcj02ToWgs84(p.get(0), p.get(1));
            gps.add(coordinate.getLng());
            gps.add(coordinate.getLat());
            return gps;
        }).collect(Collectors.toList());

        result.put(collect);
        return result;
    }

    private Double[] convert(BigDecimal lng,BigDecimal lat) {
        Double[] lngLat = new Double[2];
        CoordinateUtil.Coordinate coordinate = CoordinateUtil.gcj02ToWgs84(lng.doubleValue(), lat.doubleValue());
        lngLat[0] = coordinate.getLng();
        lngLat[1] = coordinate.getLat();
        return lngLat;
    }

    private void setPatentInfo(Area parent, List<Area> sub) {
        if (CollUtil.isEmpty(sub)) {
            return;
        }
        sub.forEach(s->{
            s.setName(parent.getName());
            s.setCity(parent.getCity());
            s.setBeginAt(parent.getBeginAt());
            s.setEndAt(parent.getEndAt());
            setPatentInfo(s, s.getSubAreas());
        });
    }

}
