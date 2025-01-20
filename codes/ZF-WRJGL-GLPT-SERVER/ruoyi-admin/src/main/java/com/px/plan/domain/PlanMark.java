package com.px.plan.domain;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;

/**
 * 预案区域对象 plan_mark
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public class PlanMark extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 区域ID */
    private Long id;

    /** 预案ID */
    @Excel(name = "预案ID")
    @ApiModelProperty(value = "预案ID")
    private Long planId;

    /** 区域名称 */
    @Excel(name = "区域名称")
    @ApiModelProperty(value = "区域名称")
    private String name;

    /** 类型.1=点?,2=区域? */
    @Excel(name = "类型.1=点?,2=区域?")
    @ApiModelProperty(value = "类型.1=点?,2=区域?")
    private Long type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long view;

    /** 注释 */
    @Excel(name = "注释")
    @ApiModelProperty(value = "注释")
    private String note;

    /** 颜色.如#FF6060 */
    @Excel(name = "颜色.如#FF6060")
    @ApiModelProperty(value = "颜色.如#FF6060")
    private String color;

    /** 预览图地址 */
    @Excel(name = "预览图地址")
    @ApiModelProperty(value = "预览图地址")
    private String iconUrl;

    /** 距离 */
    @Excel(name = "距离")
    @ApiModelProperty(value = "距离")
    private BigDecimal distance;

    /** 区域面积 */
    @Excel(name = "区域面积")
    @ApiModelProperty(value = "区域面积")
    private String area;

    /** 经度 */
    @Excel(name = "经度")
    @ApiModelProperty(value = "经度")
    private String nameLon;

    /** 纬度 */
    @Excel(name = "纬度")
    @ApiModelProperty(value = "纬度")
    private String nameLat;

    /** 方向 */
    @Excel(name = "方向")
    @ApiModelProperty(value = "方向")
    private String direction;

    private List<PlanMarkCoordinate> planMarkCoordinateList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setView(Long view) 
    {
        this.view = view;
    }

    public Long getView() 
    {
        return view;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setIconUrl(String iconUrl) 
    {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl() 
    {
        return iconUrl;
    }
    public void setDistance(BigDecimal distance) 
    {
        this.distance = distance;
    }

    public BigDecimal getDistance() 
    {
        return distance;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setNameLon(String nameLon) 
    {
        this.nameLon = nameLon;
    }

    public String getNameLon() 
    {
        return nameLon;
    }
    public void setNameLat(String nameLat) 
    {
        this.nameLat = nameLat;
    }

    public String getNameLat() 
    {
        return nameLat;
    }
    public void setDirection(String direction) 
    {
        this.direction = direction;
    }

    public String getDirection() 
    {
        return direction;
    }

    public List<PlanMarkCoordinate> getPlanMarkCoordinateList() {
        return planMarkCoordinateList;
    }

    public void setPlanMarkCoordinateList(List<PlanMarkCoordinate> planMarkCoordinateList) {
        this.planMarkCoordinateList = planMarkCoordinateList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planId", getPlanId())
            .append("name", getName())
            .append("type", getType())
            .append("view", getView())
            .append("note", getNote())
            .append("color", getColor())
            .append("iconUrl", getIconUrl())
            .append("distance", getDistance())
            .append("area", getArea())
            .append("nameLon", getNameLon())
            .append("nameLat", getNameLat())
            .append("direction", getDirection())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
