package com.px.plan.mapper;

import java.util.List;
import com.px.plan.domain.PlanActionRecord;

/**
 * 飞行行动记录Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface PlanActionRecordMapper 
{
    /**
     * 查询飞行行动记录
     * 
     * @param id 飞行行动记录主键
     * @return 飞行行动记录
     */
    public PlanActionRecord selectPlanActionRecordById(Long id);

    /**
     * 查询飞行行动记录列表
     * 
     * @param planActionRecord 飞行行动记录
     * @return 飞行行动记录集合
     */
    public List<PlanActionRecord> selectPlanActionRecordList(PlanActionRecord planActionRecord);

    /**
     * 新增飞行行动记录
     * 
     * @param planActionRecord 飞行行动记录
     * @return 结果
     */
    public int insertPlanActionRecord(PlanActionRecord planActionRecord);

    /**
     * 修改飞行行动记录
     * 
     * @param planActionRecord 飞行行动记录
     * @return 结果
     */
    public int updatePlanActionRecord(PlanActionRecord planActionRecord);

    /**
     * 删除飞行行动记录
     * 
     * @param id 飞行行动记录主键
     * @return 结果
     */
    public int deletePlanActionRecordById(Long id);

    /**
     * 批量删除飞行行动记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlanActionRecordByIds(Long[] ids);
}
