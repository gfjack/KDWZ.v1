package com.company.management_system.controller;

import com.company.management_system.api.ProfitApi;
import com.company.management_system.model.vo.profit.ProfitFilterVo;
import com.company.management_system.model.vo.profit.ProfitVo;
import com.company.management_system.service.ProfitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("利润api")
@RestController
@RequestMapping("/v1")
public class ProfitController implements ProfitApi {

    @Resource
    private ProfitService profitService;

    @ApiOperation("分页获取利润表")
    @RequestMapping(value = "/admin/profits/action/query", method = RequestMethod.POST)
    public ProfitVo query(@ApiParam("分页搜索实体") @RequestBody ProfitFilterVo profitFilterVo) {
        return profitService.query(profitFilterVo);
    }

    @ApiOperation("创建利润")
    @RequestMapping(value = "/admin/profit", method = RequestMethod.PUT)
    public ProfitVo create(@ApiParam("订单编号") @RequestParam("orderNum") String orderNum) {
        return profitService.create(orderNum);
    }

}
