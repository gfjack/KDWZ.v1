package com.company.management_system.api;


import com.company.management_system.model.vo.client.ClientCreateVo;
import com.company.management_system.model.vo.client.ClientUpdateVo;
import com.company.management_system.model.vo.client.ClientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("客户api")
public interface ClientApi {

    @ApiOperation("导出所有客户")
    @RequestMapping(value = "/export_clients", method = RequestMethod.GET)
    void export(HttpServletResponse response);

    @ApiOperation("创建客户")
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    ClientVo create(@ApiParam("客户创建实体") @RequestBody ClientCreateVo clientVo);

    @ApiOperation("根据客户名获取客户")
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    ClientVo getClientByName(@ApiParam("客户名称") @RequestParam("client_name") String clientName);

    @ApiOperation("根据客户id获取客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.GET)
    ClientVo getClientById(@ApiParam("客户id") @PathVariable("client_id") Long clientId);

    @ApiOperation("获取所有客户")
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    List<ClientVo> getAll();

    @ApiOperation("根据客户名删除客户")
    @RequestMapping(value = "/client", method = RequestMethod.DELETE)
    void deleteByName(@ApiParam("客户名称") @RequestParam("clientName") String clientName);

    @ApiOperation("根据客户ID删除客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.DELETE)
    void deleteById(@ApiParam("客户名称") @PathVariable("client_id") Long clientId);

    @ApiOperation("更新一个客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.PUT)
    ClientVo update(@ApiParam("更新课程实体") @RequestBody ClientUpdateVo clientUpdateVo,
                    @ApiParam("客户id") @PathVariable("client_id") Long clientId);

}
