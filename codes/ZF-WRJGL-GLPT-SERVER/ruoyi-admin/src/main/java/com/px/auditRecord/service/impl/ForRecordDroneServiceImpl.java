package com.px.auditRecord.service.impl;

import java.util.List;

import com.px.auditRecord.domain.ForRecordUser;
import com.px.auditRecord.mapper.ForRecordUserMapper;
import com.px.common.constant.HttpStatus;
import com.px.common.exception.ServiceException;
import com.px.common.utils.SecurityUtils;
import com.px.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.px.auditRecord.mapper.ForRecordDroneMapper;
import com.px.auditRecord.domain.ForRecordDrone;
import com.px.auditRecord.service.IForRecordDroneService;

/**
 * 我的设备Service业务层处理
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Service
public class ForRecordDroneServiceImpl implements IForRecordDroneService 
{
    @Autowired
    private ForRecordDroneMapper forRecordDroneMapper;

    @Autowired
    private ForRecordUserMapper forRecordUserMapper;

    /**
     * 查询我的设备
     * 
     * @param id 我的设备主键
     * @return 我的设备
     */
    @Override
    public ForRecordDrone selectForRecordDroneById(Integer id)
    {
        return forRecordDroneMapper.selectForRecordDroneById(id);
    }

    /**
     * 查询我的设备列表
     * 
     * @param forRecordDrone 我的设备
     * @return 我的设备
     */
    @Override
    public List<ForRecordDrone> selectForRecordDroneList(ForRecordDrone forRecordDrone)
    {
        return forRecordDroneMapper.selectForRecordDroneList(forRecordDrone);
    }

    /**
     * 新增我的设备
     * 
     * @param forRecordDrone 我的设备
     * @return 结果
     */
    @Override
    public int insertForRecordDrone(ForRecordDrone forRecordDrone)
    {
        return forRecordDroneMapper.insertForRecordDrone(forRecordDrone);
    }

    /**
     * 修改我的设备
     * 
     * @param forRecordDrone 我的设备
     * @return 结果
     */
    @Override
    public int updateForRecordDrone(ForRecordDrone forRecordDrone)
    {
        return forRecordDroneMapper.updateForRecordDrone(forRecordDrone);
    }

    /**
     * 批量删除我的设备
     * 
     * @param ids 需要删除的我的设备主键
     * @return 结果
     */
    @Override
    public int deleteForRecordDroneByIds(Integer[] ids)
    {
        return forRecordDroneMapper.deleteForRecordDroneByIds(ids);
    }

    /**
     * 删除我的设备信息
     * 
     * @param id 我的设备主键
     * @return 结果
     */
    @Override
    public int deleteForRecordDroneById(Integer id)
    {
        return forRecordDroneMapper.deleteForRecordDroneById(id);
    }

    @Override
    public List<ForRecordDrone> selectForRecordDroneListByUserId(ForRecordDrone forRecordDrone) {
        ForRecordUser fru = forRecordUserMapper.selectForRecordUserByUserId(SecurityUtils.getUserId().intValue());
        if(StringUtils.isNull(fru)){
            throw new ServiceException("该账号暂未备案人员信息", HttpStatus.CREATED);
        }
        forRecordDrone.setIdcard(fru.getIdcard());
        return forRecordDroneMapper.selectForRecordDroneList(forRecordDrone);
    }

    @Override
    public List<ForRecordDrone> getDroneListByRoutesId(Integer id) {
        return forRecordDroneMapper.getDroneListByRoutesId(id);
    }

}
