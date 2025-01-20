package com.px.auditRecord.service;

import java.util.List;

import com.px.auditRecord.domain.AuditRecordUser;
import com.px.auditRecord.domain.ForRecordUser;

/**
 * 备案详情Service接口
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public interface IForRecordUserService 
{
    /**
     * 查询备案详情
     * 
     * @param id 备案详情主键
     * @return 备案详情
     */
    public ForRecordUser selectForRecordUserById(Integer id);

    public ForRecordUser selectForRecordUserByUserId(Integer userId);

    /**
     * 查询备案详情列表
     * 
     * @param forRecordUser 备案详情
     * @return 备案详情集合
     */
    public List<ForRecordUser> selectForRecordUserList(ForRecordUser forRecordUser);

    /**
     * 新增备案详情
     * 
     * @param forRecordUser 备案详情
     * @return 结果
     */
    public int insertForRecordUser(ForRecordUser forRecordUser);

    /**
     * 修改备案详情
     * 
     * @param forRecordUser 备案详情
     * @return 结果
     */
    public int updateForRecordUser(ForRecordUser forRecordUser);

    /**
     * 批量删除备案详情
     * 
     * @param ids 需要删除的备案详情主键集合
     * @return 结果
     */
    public int deleteForRecordUserByIds(Integer[] ids);

    /**
     * 删除备案详情信息
     * 
     * @param id 备案详情主键
     * @return 结果
     */
    public int deleteForRecordUserById(Integer id);

    public ForRecordUser selectForRecordUserByIdcard(String idCard);

    public int forBinding(AuditRecordUser auditRecordUser);
}
