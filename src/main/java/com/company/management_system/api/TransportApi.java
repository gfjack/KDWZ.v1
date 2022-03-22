package com.company.management_system.api;

import com.company.management_system.model.vo.transport.TransportCreateVo;
import com.company.management_system.model.vo.transport.TransportUpdateVo;
import com.company.management_system.model.vo.transport.TransportVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("运输api")
public interface TransportApi {

    @ApiOperation("创建运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.POST)
    TransportVo create(@ApiParam("运输公司创建实体") @RequestBody TransportCreateVo transportCreateVo);

    @ApiOperation("根据名称获取一个运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.GET)
    TransportVo getByName(@ApiParam("运输公司名称") @RequestParam("transportName") String transportName);

    @ApiOperation("根据ID获取一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.GET)
    TransportVo getById(@ApiParam("运输公司ID") @PathVariable("transport_id") Long transportId);

    @ApiOperation("获取所有运输公司")
    @RequestMapping(value = "/transports", method = RequestMethod.GET)
    List<TransportVo> getAll();

    @ApiOperation("更新一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.PUT)
    TransportVo update(@ApiParam("运输公司实体") @RequestBody TransportUpdateVo transportUpdateVo,
                       @ApiParam("运输公司ID") @PathVariable("transport_id") Long transportId);

    @ApiOperation("根据名称删除一个运输公司")
    @RequestMapping(value = "/transport", method = RequestMethod.DELETE)
    void deleteByName(@ApiParam("运输公司名称") @RequestParam("transportName") String transportName);

    @ApiOperation("根据ID删除一个运输公司")
    @RequestMapping(value = "/transport/{transport_id}", method = RequestMethod.DELETE)
    void deleteByName(@ApiParam("运输公司id") @PathVariable("transport_id") Long transportId);

    @ApiOperation("导出所有运输商")
    @RequestMapping(value = "/export_transport", method = RequestMethod.GET)
    void export(HttpServletResponse response);
}
