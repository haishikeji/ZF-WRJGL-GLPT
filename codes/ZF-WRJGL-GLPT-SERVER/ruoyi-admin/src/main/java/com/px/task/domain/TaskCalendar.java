package com.px.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 任务管理对象 task_calendar
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Data
public class TaskCalendar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 任务名称 */
    @ApiModelProperty(value = "任务名称")
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务描述 */
    @ApiModelProperty(value = "任务描述")
    @Excel(name = "任务描述")
    private String taskDesc;

    /** 关联航线ID */
    @ApiModelProperty(value = "关联航线ID")
    @Excel(name = "关联航线ID")
    private Long wayPointId;

    /** 任务执行模式.1=立即执行,2=定时执行,3=循环模式 */
    @ApiModelProperty(value = "任务执行模式.1=立即执行,2=定时执行,3=循环模式")
    @Excel(name = "任务执行模式.1=立即执行,2=定时执行,3=循环模式")
    private Integer taskType;

    /** 执行计划 */
    @ApiModelProperty(value = "执行计划")
    @Excel(name = "执行计划")
    private String taskCron;

    /** 任务生效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "任务生效时间,yyyy-MM-dd")
    @Excel(name = "任务生效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskValidTime;

    /** 任务失效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "任务失效时间,yyyy-MM-dd")
    @Excel(name = "任务失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskInvalidTime;

    /** 执行时间.HHmmss */
    @ApiModelProperty(value = "执行时间.HHmmss")
    @Excel(name = "执行时间.HHmmss")
    private String taskTime;

    /** 循环模式.DAY=按天循环,WEEK=按周循环 */
    @ApiModelProperty(value = "循环模式.DAY=按天循环,WEEK=按周循环")
    @Excel(name = "循环模式.DAY=按天循环,WEEK=按周循环")
    private String taskCycleMode;

    /** 执行间隔.按天循环表示每隔几天,数字类型.周循环时表示每周几(1=周日,2=周一类推),逗号间隔 */
    @ApiModelProperty(value = "执行间隔.按天循环表示每隔几天,数字类型.周循环时表示每周几(1=周日,2=周一类推),逗号间隔")
    @Excel(name = "执行间隔.按天循环表示每隔几天,数字类型.周循环时表示每周几(1=周日,2=周一类推),逗号间隔")
    private String taskInterval;

    /** 定时执行模式下的定时时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "定时执行模式下的定时时间,yyyy-MM-dd")
    @Excel(name = "定时执行模式下的定时时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskEstimatedTime;

    /** 系统定时任务ID */
    @ApiModelProperty(value = "系统定时任务ID")
    @Excel(name = "系统定时任务ID")
    private String sysJobId;

    /** 创建人所属部门 */
    private Long deptId;

}
