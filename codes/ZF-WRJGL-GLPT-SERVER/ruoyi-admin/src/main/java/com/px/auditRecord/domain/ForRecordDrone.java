package com.px.auditRecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModelProperty;
import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;

/**
 * 我的设备对象 for_record_drone
 * 
 * @author 品讯科技
 * @date 2024-08
 */
public class ForRecordDrone extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty(value = "$column.columnComment")
    private Integer id;

    /** 名称 */
    @ApiModelProperty(value = "名称")
    @Excel(name = "名称")
    private String name;

    /** sn码 */
    @ApiModelProperty(value = "sn码")
    @Excel(name = "sn码")
    private String sn;

    /** 型号 */
    @ApiModelProperty(value = "型号")
    @Excel(name = "型号")
    private String models;

    /** 身份证号 */
    @ApiModelProperty(value = "身份证号")
    @Excel(name = "身份证号")
    private String idcard;

    /** $column.columnComment */
    @ApiModelProperty(value = "$column.columnComment")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String flightUserId;

    /** $column.columnComment */
    @ApiModelProperty(value = "$column.columnComment")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer auditRecordDroneId;

    private String model;

    private String indicators;

    private String brand;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIndicators() {
        return indicators;
    }

    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setModels(String models) 
    {
        this.models = models;
    }

    public String getModels() 
    {
        return models;
    }
    public void setIdcard(String idcard) 
    {
        this.idcard = idcard;
    }

    public String getIdcard() 
    {
        return idcard;
    }
    public void setFlightUserId(String flightUserId) 
    {
        this.flightUserId = flightUserId;
    }

    public String getFlightUserId() 
    {
        return flightUserId;
    }
    public void setAuditRecordDroneId(Integer auditRecordDroneId) 
    {
        this.auditRecordDroneId = auditRecordDroneId;
    }

    public Integer getAuditRecordDroneId() 
    {
        return auditRecordDroneId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sn", getSn())
            .append("models", getModels())
            .append("idcard", getIdcard())
            .append("flightUserId", getFlightUserId())
            .append("auditRecordDroneId", getAuditRecordDroneId())
            .toString();
    }
}
