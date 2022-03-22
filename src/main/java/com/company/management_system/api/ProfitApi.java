package com.company.management_system.api;

import com.company.management_system.model.vo.profit.ProfitFilterVo;
import com.company.management_system.model.vo.profit.ProfitVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api("利润接口")
@RequestMapping("/v1")
public interface ProfitApi {

    @ApiOperation("分页获取利润表")
    @RequestMapping(value = "/admin/profits/action/query", method = RequestMethod.POST)
    ProfitVo query(@ApiParam("分页搜索实体") @RequestBody ProfitFilterVo profitFilterVo);

    @ApiOperation("创建利润")
    @RequestMapping(value = "/admin/profit", method = RequestMethod.PUT)
    ProfitVo create(@ApiParam("订单编号") @RequestParam("orderNum") String orderNum);


}
