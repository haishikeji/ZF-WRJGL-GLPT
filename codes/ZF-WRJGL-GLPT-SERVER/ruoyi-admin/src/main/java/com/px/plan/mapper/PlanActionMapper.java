package com.px.plan.mapper;

import com.px.plan.domain.PlanAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 飞行行动Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface PlanActionMapper 
{
    /**
     * 查询飞行行动
     * 
     * @param id 飞行行动主键
     * @return 飞行行动
     */
    public PlanAction selectPlanActionById(Long id);

    /**
     * 查询飞行行动列表
     * 
     * @param planAction 飞行行动
     * @return 飞行行动集合
     */
    public List<PlanAction> selectPlanActionList(PlanAction planAction);

    /**
     * 新增飞行行动
     * 
     * @param planAction 飞行行动
     * @return 结果
     */
    public int insertPlanAction(PlanAction planAction);

    /**
     * 修改飞行行动
     * 
     * @param planAction 飞行行动
     * @return 结果
     */
    public int updatePlanAction(PlanAction planAction);

    /**
     * 删除飞行行动
     * 
     * @param id 飞行行动主键
     * @return 结果
     */
    public int deletePlanActionById(Long id);

    /**
     * 批量删除飞行行动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlanActionByIds(Long[] ids);

    /**
     * 绑定/解绑飞行行动
     * @param id 行动ID
     * @param userId 指挥人ID
     * @param username 指挥人姓名
     * @return
     */
    int bindCommand(@Param("id") Long id,@Param("userId") Long userId,@Param("username") String username);

    public PlanAction selectPlanActionBySchemeId(Long id);
}
