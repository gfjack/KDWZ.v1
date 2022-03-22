package com.company.management_system.controller;


import com.company.management_system.api.TransportApi;
import com.company.management_system.model.entity.ClientPo;
import com.company.management_system.model.vo.transport.TransportCreateVo;
import com.company.management_system.model.vo.transport.TransportUpdateVo;
import com.company.management_system.model.vo.transport.TransportVo;
import com.company.management_system.service.TransportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.company.management_system.utils.ExcelUtils.export2File;

@Api("运输api")
@RestController
@RequestMapping("/v1")
public class TransportController implements TransportApi {

    @Resource
    private TransportService transportService;

    @ApiOperation("创建运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.POST)
    public TransportVo create(@ApiParam("运输公司创建实体") @RequestBody TransportCreateVo transportCreateVo) {
        return transportService.create(transportCreateVo);
    }

    @ApiOperation("根据名称获取一个运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.GET)
    public TransportVo getByName(@ApiParam("运输公司名称") @RequestParam("transportName") String transportName) {
        return transportService.getByName(transportName);
    }

    @ApiOperation("根据ID获取一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.GET)
    public TransportVo getById(@ApiParam("运输公司ID") @PathVariable("transport_id") Long transportId) {
        return transportService.getById(transportId);
    }

    @ApiOperation("获取所有运输公司")
    @RequestMapping(value = "/transports", method = RequestMethod.GET)
    public List<TransportVo> getAll() {
        return transportService.getAll();
    }

    @ApiOperation("更新一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.PUT)
    public TransportVo update(@ApiParam("运输公司实体") @RequestBody TransportUpdateVo transportUpdateVo,
                       @ApiParam("运输公司ID") @PathVariable("transport_id") Long transportId) {
        return transportService.update(transportUpdateVo, transportId);
    }

    @ApiOperation("根据名称删除一个运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.DELETE)
    public void deleteByName(@ApiParam("运输公司名称") @RequestParam("transportName") String transportName) {
        transportService.deleteByName(transportName);
    }

    @ApiOperation("根据ID删除一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.DELETE)
    public void deleteByName(@ApiParam("运输公司id") @PathVariable("transport_id") Long transportId) {
        transportService.deleteById(transportId);
    }

    @ApiOperation("导出所有运输商")
    @RequestMapping(value = "/export_transport", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        export2File(response, "运输商表", "运输商信息", TransportVo.class, transportService.getAll());
    }

}
