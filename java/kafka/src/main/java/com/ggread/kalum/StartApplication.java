package com.ggread.kalum;

import com.ggread.kalum.service.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(Source.class)
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @StreamListener(Source.INPUT_DEMO)
    public void receive(String msg) {
        log.info("msg={}", msg);
        System.out.println("msg = " + msg);
    }
}
