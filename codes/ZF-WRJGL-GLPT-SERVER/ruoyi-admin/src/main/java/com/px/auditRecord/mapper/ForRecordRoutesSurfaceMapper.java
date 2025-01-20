package com.px.auditRecord.mapper;

import java.util.List;
import com.px.auditRecord.domain.ForRecordRoutesSurface;

/**
 * 备案航线面Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface ForRecordRoutesSurfaceMapper 
{
    /**
     * 查询备案航线面
     * 
     * @param id 备案航线面主键
     * @return 备案航线面
     */
    public ForRecordRoutesSurface selectForRecordRoutesSurfaceById(Integer id);

    /**
     * 查询备案航线面列表
     * 
     * @param forRecordRoutesSurface 备案航线面
     * @return 备案航线面集合
     */
    public List<ForRecordRoutesSurface> selectForRecordRoutesSurfaceList(ForRecordRoutesSurface forRecordRoutesSurface);

    /**
     * 新增备案航线面
     * 
     * @param forRecordRoutesSurface 备案航线面
     * @return 结果
     */
    public int insertForRecordRoutesSurface(ForRecordRoutesSurface forRecordRoutesSurface);

    /**
     * 修改备案航线面
     * 
     * @param forRecordRoutesSurface 备案航线面
     * @return 结果
     */
    public int updateForRecordRoutesSurface(ForRecordRoutesSurface forRecordRoutesSurface);

    /**
     * 删除备案航线面
     * 
     * @param id 备案航线面主键
     * @return 结果
     */
    public int deleteForRecordRoutesSurfaceById(Integer id);

    /**
     * 批量删除备案航线面
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteForRecordRoutesSurfaceByIds(Integer[] ids);
}
