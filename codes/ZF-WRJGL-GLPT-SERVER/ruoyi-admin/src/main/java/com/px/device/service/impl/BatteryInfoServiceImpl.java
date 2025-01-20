package com.px.device.service.impl;

import com.px.device.domain.BatteryInfo;
import com.px.device.mapper.BatteryInfoMapper;
import com.px.device.service.IBatteryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电池管理Service业务层处理
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class BatteryInfoServiceImpl implements IBatteryInfoService 
{
    @Autowired
    private BatteryInfoMapper batteryInfoMapper;

    /**
     * 查询电池管理
     * 
     * @param id 电池管理主键
     * @return 电池管理
     */
    @Override
    public BatteryInfo selectBatteryInfoById(Long id)
    {
        return batteryInfoMapper.selectBatteryInfoById(id);
    }

    /**
     * 查询电池管理列表
     * 
     * @param batteryInfo 电池管理
     * @return 电池管理
     */
    @Override
    public List<BatteryInfo> selectBatteryInfoList(BatteryInfo batteryInfo)
    {
        batteryInfo.setDelFlag("0");
        return batteryInfoMapper.selectBatteryInfoList(batteryInfo);
    }

    /**
     * 新增电池管理
     * 
     * @param batteryInfo 电池管理
     * @return 结果
     */
    @Override
    public int insertBatteryInfo(BatteryInfo batteryInfo)
    {
        return batteryInfoMapper.insertBatteryInfo(batteryInfo);
    }

    /**
     * 修改电池管理
     * 
     * @param batteryInfo 电池管理
     * @return 结果
     */
    @Override
    public int updateBatteryInfo(BatteryInfo batteryInfo)
    {
        return batteryInfoMapper.updateBatteryInfo(batteryInfo);
    }

    /**
     * 批量删除电池管理
     * 
     * @param ids 需要删除的电池管理主键
     * @return 结果
     */
    @Override
    public int deleteBatteryInfoByIds(Long[] ids)
    {
        return batteryInfoMapper.deleteBatteryInfoByIds(ids);
    }

    /**
     * 删除电池管理信息
     * 
     * @param id 电池管理主键
     * @return 结果
     */
    @Override
    public int deleteBatteryInfoById(Long id)
    {
        return batteryInfoMapper.deleteBatteryInfoById(id);
    }
}
