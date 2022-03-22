package com.company.management_system.controller;

import com.company.management_system.api.ClientApi;
import com.company.management_system.model.vo.client.ClientCreateVo;
import com.company.management_system.model.vo.client.ClientUpdateVo;
import com.company.management_system.model.vo.client.ClientVo;
import com.company.management_system.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api("客户api")
@RestController
@RequestMapping("/v1")
public class ClientController implements ClientApi {

    @Resource
    private ClientService clientService;

    @ApiOperation("导出所有客户")
    @RequestMapping(value = "/export_client", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        clientService.export(response);
    }


    @ApiOperation("创建客户")
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ClientVo create(@ApiParam("客户创建实体") @Valid @RequestBody ClientCreateVo clientVo) {
        return clientService.create(clientVo);
    }

    @ApiOperation("根据客户名获取客户")
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ClientVo getClientByName(@ApiParam(value = "客户名称", required = true) @RequestParam("clientName") String clientName) {
        return clientService.getClientByName(clientName);
    }

    @ApiOperation("根据客户id获取客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.GET)
    public ClientVo getClientById(@ApiParam(value = "客户id", required = true) @PathVariable("client_id") Long clientId) {
        return clientService.getClientById(clientId);
    }

    @ApiOperation("获取所有客户")
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ClientVo> getAll() {
        return clientService.getAll();
    }

    @ApiOperation("根据客户名删除客户")
    @RequestMapping(value = "/client", method = RequestMethod.DELETE)
    public void deleteByName(@ApiParam(value = "客户名称", required = true) @RequestParam("clientName") String clientName) {
        clientService.deleteByName(clientName);
    }

    @ApiOperation("根据客户ID删除客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.DELETE)
    public void deleteById(@ApiParam(value = "客户名称", required = true) @PathVariable("client_id") Long clientId) {
        clientService.deleteById(clientId);
    }

    @ApiOperation("更新一个客户")
    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.PUT)
    public ClientVo update(@ApiParam(value = "更新课程实体", required = true) @RequestBody ClientUpdateVo clientUpdateVo,
                    @ApiParam(value = "客户id", required = true) @PathVariable("client_id") Long clientId) {
        return clientService.update(clientUpdateVo, clientId);
    }

}
