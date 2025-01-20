package com.px.auditRecord.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.px.framework.aes.AesSecurityParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.px.common.annotation.Log;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.enums.BusinessType;
import com.px.auditRecord.domain.AuditRecordDrone;
import com.px.auditRecord.service.IAuditRecordDroneService;
import com.px.common.utils.poi.ExcelUtil;
import com.px.common.core.page.TableDataInfo;

/**
 * 设备审核记录Controller
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Api("设备审核记录")
@RestController
@RequestMapping("/auditRecord/drone")
public class AuditRecordDroneController extends BaseController
{
    @Autowired
    private IAuditRecordDroneService auditRecordDroneService;

    /**
     * 查询设备审核记录列表
     */
    @ApiOperation("查询设备审核记录列表")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:query')")
    @GetMapping("/list")
    @AesSecurityParameter(outEncode = true)
    public TableDataInfo list(AuditRecordDrone auditRecordDrone)
    {
        startPage();
        List<AuditRecordDrone> list = auditRecordDroneService.selectAuditRecordDroneList(auditRecordDrone);
        return getDataTable(list);
    }

    /**
     * 导出设备审核记录列表
     */
    @ApiOperation("导出设备审核记录列表")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:query')")
    @Log(title = "设备审核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @AesSecurityParameter(outEncode = false)
    public void export(HttpServletResponse response, AuditRecordDrone auditRecordDrone)
    {
        List<AuditRecordDrone> list = auditRecordDroneService.selectAuditRecordDroneList(auditRecordDrone);
        ExcelUtil<AuditRecordDrone> util = new ExcelUtil<AuditRecordDrone>(AuditRecordDrone.class);
        util.exportExcel(response, list, "设备审核记录数据");
    }

    /**
     * 获取设备审核记录详细信息
     */
    @ApiOperation("获取设备审核记录详细信息")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:query')")
    @GetMapping(value = "/{id}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(auditRecordDroneService.selectAuditRecordDroneById(id));
    }

    /**
     * 新增设备审核记录
     */
    @ApiOperation("新增设备审核记录")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:edit')")
    @Log(title = "设备审核记录", businessType = BusinessType.INSERT)
    @PostMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult add(@RequestBody AuditRecordDrone auditRecordDrone)
    {
        return toAjax(auditRecordDroneService.insertAuditRecordDrone(auditRecordDrone));
    }

    /**
     * 修改设备审核记录
     */
    @ApiOperation("修改设备审核记录")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:edit')")
    @Log(title = "设备审核记录", businessType = BusinessType.UPDATE)
    @PutMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult edit(@RequestBody AuditRecordDrone auditRecordDrone)
    {
        return toAjax(auditRecordDroneService.updateAuditRecordDrone(auditRecordDrone));
    }

    /**
     * 删除设备审核记录
     */
    @ApiOperation("删除设备审核记录")
    @PreAuthorize("@ss.hasPermi('auditRecord:drone:remove')")
    @Log(title = "设备审核记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(auditRecordDroneService.deleteAuditRecordDroneByIds(ids));
    }


    /**
     * 新增设备审核记录
     */
    @ApiOperation("个人新增设备审核记录")
    @PostMapping("/flightDroneAdd")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult flightDroneAdd(@RequestBody AuditRecordDrone auditRecordDrone)
    {
        auditRecordDrone.setCreateBy(getUserId().toString());
        return toAjax(auditRecordDroneService.flightDroneAdd(auditRecordDrone));
    }

    @ApiOperation("个人查询设备审核记录列表")
    @GetMapping("/flightList")
    @AesSecurityParameter(outEncode = true)
    public TableDataInfo flightList(AuditRecordDrone auditRecordDrone)
    {
        startPage();
        List<AuditRecordDrone> list = auditRecordDroneService.selectFlightList(auditRecordDrone);

        return getDataTable(list);
    }

}
