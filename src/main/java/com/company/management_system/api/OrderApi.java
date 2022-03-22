package com.company.management_system.api;

import com.company.management_system.model.vo.order.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("订单api")
public interface OrderApi {

    @ApiOperation("创建一个订单")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    OrderVo create(@ApiParam("订单实体") @RequestBody OrderCreateVo orderVo);

    @ApiOperation("获取一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.GET)
    OrderVo get(@ApiParam("订单编号") @PathVariable("order_num") String orderNum);

    @ApiOperation("删除一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.DELETE)
    void delete(@ApiParam("订单编号") @PathVariable("order_num") String orderNum);

    @ApiOperation("获取所有订单")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    List<OrderVo> getAll();

    @ApiOperation("更新一个订单")
    @RequestMapping(value = "/order/{order_num}", method = RequestMethod.PUT)
    OrderVo update(@ApiParam("订单更新实体") @RequestBody OrderUpdateVo orderUpdateVo,
                   @ApiParam("订单编号") @PathVariable("order_num") String orderNum);

     @ApiOperation("根据名称筛选订单, 1 - 客户, 2 - 供应商, 3 - 运输公司")
     @RequestMapping(value = "/order/actions/search")
     List<OrderVo> search(@ApiParam("公司名称") @RequestParam("companyName") String companyName,
                          @ApiParam("公司类型, 1 - 客户, 2 - 供应商, 3 - 运输公司") @RequestParam("companyType") Integer companyType);

    @ApiOperation("根据条件筛选订单")
    @RequestMapping(value = "/orders/actions/filter", method = RequestMethod.POST)
    List<OrderVo> filter(@ApiParam("过滤搜索实体") @RequestBody OrderFilterSearchVo orderFilterSearchVo);

    @ApiOperation("分页查询订单")
    @RequestMapping(value = "/orders/actions/query", method = RequestMethod.GET)
    List<OrderVo> query(@ApiParam("当前页") @RequestParam("current") Integer current,
                        @ApiParam("每页量") @RequestParam("limit") Integer limit);

    @ApiOperation("创建订单细节")
    @RequestMapping(value = "/orders/{order_num}/order_details", method = RequestMethod.POST)
    List<OrderDetailVo> create(@ApiParam("订单细节列表") @RequestBody List<OrderDetailCreateVo> details,
                               @ApiParam("订单编号") @PathVariable("order_num") String orderNum);

    @ApiOperation("获取一个订单所有细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details", method = RequestMethod.GET)
    List<OrderDetailVo> getOrderAllDetails(@ApiParam("订单编号") @PathVariable("orderNum") String number);

    @ApiOperation("更新一个订单某一个订单细节")
    @RequestMapping(value = "/orders/{order_num}/order_details/{order_detail_num}", method = RequestMethod.PUT)
    OrderDetailVo updateOneDetails(@ApiParam("订单详细信息更新实体") @RequestBody OrderDetailUpdateVo orderDetail,
                                   @ApiParam("订单编号") @PathVariable("order_num") String orderNum,
                                   @ApiParam("编号序号") @PathVariable("order_detail_num") Long orderDetailNum);

    @ApiOperation("更新所有订单细节总价")
    @RequestMapping(value = "/orders/{order_num}/order_details/action/update_total_price")
    void updateDetailTotalPrice(@ApiParam("订单编号") @PathVariable("order_num") String orderNum);

    @ApiOperation("删除一个订单某一个订单细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details/{orderDetailNum}", method = RequestMethod.DELETE)
    void deleteOneDetail(@ApiParam("订单编号") @PathVariable("orderNum") String orderNum,
                         @ApiParam("编号序号") @PathVariable("orderDetailNum") Long orderDetailNum);

    @ApiOperation("删除一个订单所有订单细节")
    @RequestMapping(value = "/orders/{orderNum}/order_details", method = RequestMethod.DELETE)
    void deleteAllDetail(@ApiParam("订单编号") @PathVariable("orderNum") String orderNum);

}
