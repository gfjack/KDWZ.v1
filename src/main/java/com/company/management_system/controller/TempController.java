package com.company.management_system.controller;


import com.company.management_system.service.TempService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api("删除所有数据")
@RestController
@RequestMapping("")
public class TempController {

    @Resource
    private TempService tempService;

    @ApiOperation("删除数据库所有东西")
    @RequestMapping(value = "/delete_all", method = RequestMethod.DELETE)
    public void deleteAll() {
        tempService.deleteAll();
    }


//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
//        return "hello world";
//    }


}
