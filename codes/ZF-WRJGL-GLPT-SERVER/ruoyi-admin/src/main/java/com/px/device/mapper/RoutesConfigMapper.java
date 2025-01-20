package com.px.device.mapper;

import java.util.List;
import com.px.device.domain.RoutesConfig;

/**
 * 航线配置Mapper接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface RoutesConfigMapper 
{
    /**
     * 查询航线配置
     * 
     * @param routesConfigId 航线配置主键
     * @return 航线配置
     */
    public RoutesConfig selectRoutesConfigByRoutesConfigId(Long routesConfigId);

    public RoutesConfig selectRoutesConfigByRoutesRoutesId(Long routesId);
    /**
     * 查询航线配置列表
     * 
     * @param routesConfig 航线配置
     * @return 航线配置集合
     */
    public List<RoutesConfig> selectRoutesConfigList(RoutesConfig routesConfig);

    /**
     * 新增航线配置
     * 
     * @param routesConfig 航线配置
     * @return 结果
     */
    public int insertRoutesConfig(RoutesConfig routesConfig);

    /**
     * 修改航线配置
     * 
     * @param routesConfig 航线配置
     * @return 结果
     */
    public int updateRoutesConfig(RoutesConfig routesConfig);

    /**
     * 删除航线配置
     * 
     * @param routesConfigId 航线配置主键
     * @return 结果
     */
    public int deleteRoutesConfigByRoutesConfigId(Long routesConfigId);

    /**
     * 批量删除航线配置
     * 
     * @param routesConfigIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoutesConfigByRoutesConfigIds(Long[] routesConfigIds);


}
