package com.px.plan.controller;

import com.px.common.annotation.Log;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.core.page.TableDataInfo;
import com.px.common.enums.BusinessType;
import com.px.common.utils.poi.ExcelUtil;
import com.px.framework.aes.AesSecurityParameter;
import com.px.plan.domain.PlanActionMark;
import com.px.plan.service.IPlanActionMarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 飞行行动标记Controller
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Api("飞行行动标记管理")
@RestController
@RequestMapping("/action/mark")
public class PlanActionMarkController extends BaseController
{
    @Autowired
    private IPlanActionMarkService planActionMarkService;

    /**
     * 查询飞行行动标记列表
     */
    @ApiOperation("查询飞行行动标记列表")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @GetMapping("/list")
    @AesSecurityParameter(outEncode = true)
    public TableDataInfo list(PlanActionMark planActionMark)
    {
        List<PlanActionMark> list = planActionMarkService.selectPlanActionMarkList(planActionMark);
        return getDataTable(list);
    }

    /**
     * 导出飞行行动标记列表
     */
    @ApiOperation("导出飞行行动标记列表")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "飞行行动标记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @AesSecurityParameter
    public void export(HttpServletResponse response, PlanActionMark planActionMark)
    {
        List<PlanActionMark> list = planActionMarkService.selectPlanActionMarkList(planActionMark);
        ExcelUtil<PlanActionMark> util = new ExcelUtil<PlanActionMark>(PlanActionMark.class);
        util.exportExcel(response, list, "飞行行动标记数据");
    }

    /**
     * 获取飞行行动标记详细信息
     */
    @ApiOperation("获取飞行行动标记详细信息")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @GetMapping(value = "/{id}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(planActionMarkService.selectPlanActionMarkById(id));
    }

    /**
     * 新增飞行行动标记
     */
    @ApiOperation("新增飞行行动标记")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "飞行行动标记", businessType = BusinessType.INSERT)
    @PostMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult add(@RequestBody PlanActionMark planActionMark)
    {
        return toAjax(planActionMarkService.insertPlanActionMark(planActionMark));
    }

    /**
     * 修改飞行行动标记
     */
    @ApiOperation("修改飞行行动标记")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "飞行行动标记", businessType = BusinessType.UPDATE)
    @PutMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult edit(@RequestBody PlanActionMark planActionMark)
    {
        return toAjax(planActionMarkService.updatePlanActionMark(planActionMark));
    }

    /**
     * 删除飞行行动标记
     */
    @ApiOperation("删除飞行行动标记")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "飞行行动标记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(planActionMarkService.deletePlanActionMarkByIds(ids));
    }
}
