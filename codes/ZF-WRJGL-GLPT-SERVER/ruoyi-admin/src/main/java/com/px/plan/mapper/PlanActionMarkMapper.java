package com.px.plan.mapper;

import java.util.List;
import com.px.plan.domain.PlanActionMark;

/**
 * 飞行行动标记Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface PlanActionMarkMapper 
{
    /**
     * 查询飞行行动标记
     * 
     * @param id 飞行行动标记主键
     * @return 飞行行动标记
     */
    public PlanActionMark selectPlanActionMarkById(Long id);

    /**
     * 查询飞行行动标记列表
     * 
     * @param planActionMark 飞行行动标记
     * @return 飞行行动标记集合
     */
    public List<PlanActionMark> selectPlanActionMarkList(PlanActionMark planActionMark);

    /**
     * 新增飞行行动标记
     * 
     * @param planActionMark 飞行行动标记
     * @return 结果
     */
    public int insertPlanActionMark(PlanActionMark planActionMark);

    /**
     * 修改飞行行动标记
     * 
     * @param planActionMark 飞行行动标记
     * @return 结果
     */
    public int updatePlanActionMark(PlanActionMark planActionMark);

    /**
     * 删除飞行行动标记
     * 
     * @param id 飞行行动标记主键
     * @return 结果
     */
    public int deletePlanActionMarkById(Long id);

    /**
     * 批量删除飞行行动标记
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlanActionMarkByIds(Long[] ids);
}
