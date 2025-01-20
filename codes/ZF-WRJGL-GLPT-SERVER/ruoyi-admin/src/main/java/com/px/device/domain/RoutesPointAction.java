package com.px.device.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModelProperty;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;

/**
 * 航线点位动作对象 routes_point_action
 *
 * @author 品讯科技
 * @date 2024-08
 */
public class RoutesPointAction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 点位动作id */
    @ApiModelProperty(value = "点位动作id")
    private Long routesPointActionId;

    /** 航线点位id */
    @ApiModelProperty(value = "航线点位id")
    @Excel(name = "航线点位id")
    private Long routesPointId;

    /** $column.columnComment */
    @ApiModelProperty(value = "$column.columnComment")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long index;

    /**  */
    @ApiModelProperty(value = "")
    @Excel(name = "")
    private String actionActuatorFunc;

    /**  */
    @ApiModelProperty(value = "")
    @Excel(name = "")
    private Long value;

    public void setRoutesPointActionId(Long routesPointActionId)
    {
        this.routesPointActionId = routesPointActionId;
    }

    public Long getRoutesPointActionId()
    {
        return routesPointActionId;
    }
    public void setRoutesPointId(Long routesPointId)
    {
        this.routesPointId = routesPointId;
    }

    public Long getRoutesPointId()
    {
        return routesPointId;
    }
    public void setIndex(Long indx)
    {
        this.index = indx;
    }

    public Long getIndex()
    {
        return index;
    }
    public void setActionActuatorFunc(String actionActuatorFunc)
    {
        this.actionActuatorFunc = actionActuatorFunc;
    }

    public String getActionActuatorFunc()
    {
        return actionActuatorFunc;
    }

    public void setValue(Long value)
    {
        this.value = value;
    }

    public Long getValue()
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("routesPointActionId", getRoutesPointActionId())
                .append("routesPointId", getRoutesPointId())
                .append("index", getIndex())
                .append("actionActuatorFunc", getActionActuatorFunc())
                .append("value", getValue())
                .toString();
    }
}
