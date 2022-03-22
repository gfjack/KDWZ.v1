package com.company.management_system.controller;

import com.company.management_system.api.OrderApi;
import com.company.management_system.exception.OrderException;
import com.company.management_system.model.vo.order.*;
import com.company.management_system.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static com.company.management_system.utils.CommonUtils.isValidCompanyType;

@Api("订单api")
@RestController
@RequestMapping("/v1")
public class OrderController implements OrderApi {

    @Resource
    private OrderService orderService;

    @Override
    @ApiOperation("创建一个订单")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderVo create(@ApiParam(value = "订单实体", required = true) @Valid @RequestBody OrderCreateVo orderCreateVo) {
        return orderService.create(orderCreateVo);
    }

    @Override
    @ApiOperation("获取一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.GET)
    public OrderVo get(@ApiParam(value = "订单编号", required = true) @PathVariable("order_num") String orderNum) {
        return orderService.get(orderNum);
    }

    @Override
    @ApiOperation("删除一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "订单编号", required = true) @PathVariable("order_num") String orderNum) {
        orderService.delete(orderNum);
    }

    @Override
    @ApiOperation("获取所有订单")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<OrderVo> getAll() {
        return orderService.getAll();
    }

    @Override
    @ApiOperation("更新一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.PUT)
    public OrderVo update(@ApiParam(value = "订单编号", required = true) @RequestBody OrderUpdateVo orderUpdateVo,
                          @ApiParam(value = "订单编号", required = true) @PathVariable("order_num") String orderNum) {
        return orderService.update(orderUpdateVo, orderNum);
    }


    @Override
    @ApiOperation("根据名称筛选订单, 1 - 客户, 2 - 供应商, 3 - 运输公司")
    @RequestMapping(value = "/order/actions/search", method = RequestMethod.GET)
    public List<OrderVo> search(@ApiParam(value = "公司名称", required = true) @RequestParam("companyName") String companyName,
                         @ApiParam(value = "公司类型, 1 - 客户, 2 - 供应商, 3 - 运输公司", required = true) @RequestParam("companyType") Integer companyType) {
        if (!isValidCompanyType(companyType)) {
            throw new OrderException("请输入正确的公司类型");
        }

        return orderService.search(companyName, companyType);
    }


    @Override
    @ApiOperation("根据条件筛选订单")
    @RequestMapping(value = "/orders/actions/filter", method = RequestMethod.POST)
    public List<OrderVo> filter(@ApiParam("过滤搜索实体") @RequestBody OrderFilterSearchVo orderFilterSearchVo) {
        return orderService.filter(orderFilterSearchVo);
    }

    @ApiOperation("分页查询订单")
    @RequestMapping(value = "/orders/actions/query", method = RequestMethod.GET)
    public List<OrderVo> query(@ApiParam(value = "当前页", required = true) @RequestParam("current") Integer current,
                        @ApiParam(value = "每页量", required = true) @RequestParam("limit") Integer limit) {
        return orderService.query(current, limit);
    }

    @Override
    @ApiOperation("创建订单细节")
    @RequestMapping(value = "/orders/{order_num}/order_details", method = RequestMethod.POST)
    public List<OrderDetailVo> create(@ApiParam("订单细节列表") @RequestBody List<OrderDetailCreateVo> details,
                                      @ApiParam("订单编号") @PathVariable("order_num") String orderNum) {
        return orderService.create(details, orderNum);
    }

    @Override
    @ApiOperation("获取一个订单所有细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details", method = RequestMethod.GET)
    public List<OrderDetailVo> getOrderAllDetails(@ApiParam("订单编号") @PathVariable("orderNum") String orderNum) {
        return orderService.getOrderAllDetails(orderNum);
    }

    @Override
    @ApiOperation("更新一个订单某一个订单细节")
    @RequestMapping(value = "/orders/{order_num}/order_details/{orderDetailNum}", method = RequestMethod.PUT)
    public OrderDetailVo updateOneDetails(@ApiParam("订单编号") @RequestBody OrderDetailUpdateVo orderDetail,
                                   @ApiParam("订单编号") @PathVariable("order_num") String orderNum,
                                   @ApiParam("编号序号") @PathVariable("orderDetailNum") Long orderDetailNum) {
        return orderService.updateOneDetails(orderDetail, orderNum, orderDetailNum);
    }

    @Override
    @ApiOperation("更新所有订单细节总价")
    @RequestMapping(value = "/orders/{order_num}/order_details/action/update_total_price", method = RequestMethod.PUT)
    public void updateDetailTotalPrice(@ApiParam("订单编号") @PathVariable("order_num") String orderNum) {

    }

    @Override
    @ApiOperation("删除一个订单某一个订单细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details/{orderDetailNum}", method = RequestMethod.DELETE)
    public void deleteOneDetail(@ApiParam("订单编号") @PathVariable("orderNum") String orderNum,
                         @ApiParam("编号序号") @PathVariable("orderDetailNum") Long orderDetailNum) {
        orderService.deleteOneDetail(orderNum, orderDetailNum);
    }

    @Override
    @ApiOperation("删除一个订单所有订单细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details", method = RequestMethod.DELETE)
    public void deleteAllDetail(@ApiParam("订单编号") @PathVariable("orderNum") String orderNum) {
        orderService.deleteAllDetail(orderNum);
    }
}
