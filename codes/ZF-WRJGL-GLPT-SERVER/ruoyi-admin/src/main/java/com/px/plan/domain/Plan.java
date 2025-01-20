package com.px.plan.domain;

import com.px.common.annotation.Excel;
import com.px.common.core.domain.BaseEntity;
import com.px.common.config.MinIoClientConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 预案对象 plan
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Data
public class Plan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 预案名称 */
    @Excel(name = "预案名称")
    @ApiModelProperty(value = "预案名称")
    private String name;

    /** 经度 */
    @Excel(name = "经度")
    @ApiModelProperty(value = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    @ApiModelProperty(value = "纬度")
    private String latitude;

    /** 高度 */
    @Excel(name = "高度")
    @ApiModelProperty(value = "高度")
    private String altitude;

    /** 预案预览图地址 */
    @Excel(name = "预案预览图地址")
    @ApiModelProperty(value = "预案预览图地址")
    private String preview;

    /** 预案预览图地址 */
    @Excel(name = "预案预览图地址")
    @ApiModelProperty(value = "预案预览图地址")
    private String previewUrl;

    /** $column.columnComment */
    @Excel(name = "状态.0:草稿,1:预案")
    @ApiModelProperty(value = "状态.0:草稿,1:预案")
    private Long type;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    @ApiModelProperty(value = "创建人姓名")
    private String userName;

    /** 预案地址 */
    @Excel(name = "预案地址")
    @ApiModelProperty(value = "预案地址")
    private String address;

    /** 创建人所在公司名称 */
    @Excel(name = "创建人所在公司名称")
    @ApiModelProperty(value = "创建人所在公司名称")
    private Long companyId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String objectName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal size;

    /** 预案区域 */
    private String planMarkList;

    /** 页面备注信息 */
    private String planModelList;

    /** 创建人部门ID */
    @ApiModelProperty(value = "创建人部门ID")
    @Excel(name = "创建人部门ID")
    private Long deptId;

    public String getPreviewUrl() {
        if (null != preview && preview.startsWith("http")) {
            return preview;
        } else {
            return MinIoClientConfig.PREVIEW_END_POINT_URL + "/" + preview;
        }
    }
}
