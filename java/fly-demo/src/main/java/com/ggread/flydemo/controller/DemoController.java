package com.ggread.flydemo.controller;

import io.github.kalumcode.fly.core.starter.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.kalumcode.fly.core.starter.response.BaseResponse.returnSuccess;

@RestController
@Validated
@Api(tags = "系统用户相关接口")
@RequestMapping(value = "/demo")
public class DemoController {
    /**
     * 查询系统用户表
     *
     * @param id 系统用户表ID
     * @return 系统用户表
     */
    @ApiOperation(value = "查询系统用户详情", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "Long")
    })
    @GetMapping(value = "/{id}")
    public BaseResponse<String> getById(@PathVariable("id") Long id) {
        return returnSuccess("id="+id);
    }
}
