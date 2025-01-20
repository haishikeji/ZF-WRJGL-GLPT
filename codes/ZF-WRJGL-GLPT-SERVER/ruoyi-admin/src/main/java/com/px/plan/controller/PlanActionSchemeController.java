package com.px.plan.controller;

import com.px.common.annotation.Log;
import com.px.common.core.controller.BaseController;
import com.px.common.core.domain.AjaxResult;
import com.px.common.core.page.TableDataInfo;
import com.px.common.enums.BusinessType;
import com.px.common.utils.poi.ExcelUtil;
import com.px.framework.aes.AesSecurityParameter;
import com.px.plan.domain.PlanActionScheme;
import com.px.plan.service.IPlanActionSchemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 行动方案Controller
 * 
 * @author 品讯科技
 * @date 2024-08
 */
@Api("行动方案")
@RestController
@RequestMapping("/plan/scheme")
public class PlanActionSchemeController extends BaseController
{
    @Autowired
    private IPlanActionSchemeService planActionSchemeService;

    /**
     * 查询行动方案列表
     */
    @ApiOperation("查询行动方案列表")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @GetMapping("/list")
    @AesSecurityParameter(outEncode = true)
    public TableDataInfo list(PlanActionScheme planActionScheme)
    {
        startPage();
        List<PlanActionScheme> list = planActionSchemeService.selectPlanActionSchemeList(planActionScheme);
        return getDataTable(list);
    }

    /**
     * 导出行动方案列表
     */
    @ApiOperation("导出行动方案列表")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "行动方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @AesSecurityParameter
    public void export(HttpServletResponse response, PlanActionScheme planActionScheme)
    {
        List<PlanActionScheme> list = planActionSchemeService.selectPlanActionSchemeList(planActionScheme);
        ExcelUtil<PlanActionScheme> util = new ExcelUtil<PlanActionScheme>(PlanActionScheme.class);
        util.exportExcel(response, list, "行动方案数据");
    }

    /**
     * 获取行动方案详细信息
     */
    @ApiOperation("获取行动方案详细信息")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @GetMapping(value = "/{id}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(planActionSchemeService.selectPlanActionSchemeById(id));
    }

    /**
     * 新增行动方案
     */
    @ApiOperation("新增行动方案")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "行动方案", businessType = BusinessType.INSERT)
    @PostMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult add(@RequestBody PlanActionScheme planActionScheme)
    {
        return toAjax(planActionSchemeService.insertPlanActionScheme(planActionScheme));
    }

    /**
     * 修改行动方案
     */
    @ApiOperation("修改行动方案")
    @PreAuthorize("@ss.hasPermi('plan:scheme:edit')")
    @Log(title = "行动方案", businessType = BusinessType.UPDATE)
    @PutMapping
    @AesSecurityParameter(outEncode = true)
    public AjaxResult edit(@RequestBody PlanActionScheme planActionScheme)
    {
        return toAjax(planActionSchemeService.updatePlanActionScheme(planActionScheme));
    }

    /**
     * 删除行动方案
     */
    @ApiOperation("删除行动方案")
    @PreAuthorize("@ss.hasPermi('plan:scheme:list')")
    @Log(title = "行动方案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @AesSecurityParameter(outEncode = true)
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(planActionSchemeService.deletePlanActionSchemeByIds(ids));
    }
}
