package com.px.device.service;

import java.util.List;
import com.px.device.domain.RoutesPointAction;

/**
 * 航线点位动作Service接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface IRoutesPointActionService 
{
    /**
     * 查询航线点位动作
     * 
     * @param routesPointActionId 航线点位动作主键
     * @return 航线点位动作
     */
    public RoutesPointAction selectRoutesPointActionByRoutesPointActionId(Long routesPointActionId);

    /**
     * 查询航线点位动作列表
     * 
     * @param routesPointAction 航线点位动作
     * @return 航线点位动作集合
     */
    public List<RoutesPointAction> selectRoutesPointActionList(RoutesPointAction routesPointAction);

    /**
     * 新增航线点位动作
     * 
     * @param routesPointAction 航线点位动作
     * @return 结果
     */
    public int insertRoutesPointAction(RoutesPointAction routesPointAction);

    /**
     * 修改航线点位动作
     * 
     * @param routesPointAction 航线点位动作
     * @return 结果
     */
    public int updateRoutesPointAction(RoutesPointAction routesPointAction);

    /**
     * 批量删除航线点位动作
     * 
     * @param routesPointActionIds 需要删除的航线点位动作主键集合
     * @return 结果
     */
    public int deleteRoutesPointActionByRoutesPointActionIds(Long[] routesPointActionIds);

    /**
     * 删除航线点位动作信息
     * 
     * @param routesPointActionId 航线点位动作主键
     * @return 结果
     */
    public int deleteRoutesPointActionByRoutesPointActionId(Long routesPointActionId);
}
