package com.px.plan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 飞行行动对象 plan_action
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Data
public class PlanAction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 行动名称 */
    @Excel(name = "行动名称")
    @ApiModelProperty(value = "行动名称")
    private String name;

    /** 简介 */
    @Excel(name = "简介")
    @ApiModelProperty(value = "简介")
    private String introduction;

    /** 纬度 */
    @Excel(name = "纬度")
    @ApiModelProperty(value = "纬度")
    private String lat;

    /** 经度 */
    @Excel(name = "经度")
    @ApiModelProperty(value = "经度")
    private String lon;

    /** 行动方案ID */
    @Excel(name = "方案ID")
    @ApiModelProperty(value = "方案ID")
    private Long schemeId;

    /** 预案ID */
    @Excel(name = "预案ID")
    @ApiModelProperty(value = "预案ID")
    private Long planId;

    /** 预案名称 */
    @Excel(name = "预案名称")
    @ApiModelProperty(value = "预案名称")
    private String planName;

    /** 行动状态.1:进行中,2:已结束 */
    @Excel(name = "行动状态.1:进行中,2:已结束")
    @ApiModelProperty(value = "行动状态.1:进行中,2:已结束")
    private Integer status;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 参与飞手ID */
    @Excel(name = "参与飞手ID")
    @ApiModelProperty(value = "参与飞手ID,用逗号分隔")
    private String pilotId;

    /** 参与飞手姓名 */
    @Excel(name = "参与飞手姓名")
    @ApiModelProperty(value = "参与飞手姓名,用逗号分隔")
    private String pilotName;

    /** 行动位置 */
    @Excel(name = "行动位置")
    @ApiModelProperty(value = "行动位置")
    private String address;

    /** 行动位置 */
    @Excel(name = "创建人姓名")
    @ApiModelProperty(value = "创建人姓名")
    private String createByName;

    /** 地图信息(弹窗备注) */
    @Excel(name = "地图信息(弹窗备注)")
    @ApiModelProperty(value = "地图信息(弹窗备注)")
    private String planModelList;

    /** 地图信息(点线图) */
    @Excel(name = "地图信息(点线图)")
    @ApiModelProperty(value = "地图信息(点线图)")
    private String planMarkList;

    /** 行动指挥人ID */
    @Excel(name = "行动指挥人ID")
    @ApiModelProperty(value = "行动指挥人ID")
    private Long commandId;

    /** 参与飞手姓名 */
    @Excel(name = "行动指挥人姓名")
    @ApiModelProperty(value = "行动指挥人姓名")
    private String commandName;

    /** 创建人所属部门 */
    private Long deptId;

    private Long mediaSize;

    @ApiModelProperty(value = "行动人员")
    private List<PlanActionUser> actionUsers = new ArrayList<>();
}
