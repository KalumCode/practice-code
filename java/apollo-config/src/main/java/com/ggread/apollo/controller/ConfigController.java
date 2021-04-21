package com.ggread.apollo.controller;

import com.ggread.apollo.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping(value = "/config")
public class ConfigController {

    @Resource
    private ConfigProperties configProperties;

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/mysql")
    public Map<Object, Object> getMySQLProperties() {
        Map resultMap = new HashMap<>();
        resultMap.put("host", configProperties.getMysqlHost());
        resultMap.put("port", configProperties.getMysqlPort());
        resultMap.put("username", configProperties.getMysqlUsername());
        resultMap.put("password", configProperties.getMysqlPassword());
        return resultMap;
    }
}

