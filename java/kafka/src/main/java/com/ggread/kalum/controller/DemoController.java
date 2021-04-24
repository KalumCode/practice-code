package com.ggread.kalum.controller;

import com.ggread.kalum.service.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Validated
@Slf4j
@RequestMapping(value = "/demo")
public class DemoController {

    @Resource
    private Source source;

    @GetMapping("/sendMq")
    public Boolean sendMq(String param) {
        Boolean flag = source.output().send(MessageBuilder.withPayload(param).build());
        return flag;
    }
}

