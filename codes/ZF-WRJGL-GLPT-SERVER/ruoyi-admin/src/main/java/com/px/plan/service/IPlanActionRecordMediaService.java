package com.px.plan.service;

import com.px.plan.domain.PlanActionRecordMedia;

import java.util.List;

/**
 * 行动记录媒体信息Service接口
 *
 * @author 品讯科技
 * @date 2024-08
 */
public interface IPlanActionRecordMediaService
{
    /**
     * 查询行动记录媒体信息
     *
     * @param id 行动记录媒体信息主键
     * @return 行动记录媒体信息
     */
    public PlanActionRecordMedia selectPlanActionRecordMediaById(Long id);

    /**
     * 查询行动记录媒体信息列表
     *
     * @param planActionRecordMedia 行动记录媒体信息
     * @return 行动记录媒体信息集合
     */
    public List<PlanActionRecordMedia> selectPlanActionRecordMediaList(PlanActionRecordMedia planActionRecordMedia);

    /**
     * 新增行动记录媒体信息
     *
     * @param planActionRecordMedia 行动记录媒体信息
     * @return 结果
     */
    public int insertPlanActionRecordMedia(PlanActionRecordMedia planActionRecordMedia);

    /**
     * 修改行动记录媒体信息
     *
     * @param planActionRecordMedia 行动记录媒体信息
     * @return 结果
     */
    public int updatePlanActionRecordMedia(PlanActionRecordMedia planActionRecordMedia);

    /**
     * 批量删除行动记录媒体信息
     *
     * @param ids 需要删除的行动记录媒体信息主键集合
     * @return 结果
     */
    public int deletePlanActionRecordMediaByIds(Long[] ids);

    /**
     * 删除行动记录媒体信息信息
     *
     * @param id 行动记录媒体信息主键
     * @return 结果
     */
    public int deletePlanActionRecordMediaById(Long id);
}
