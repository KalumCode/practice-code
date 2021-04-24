package com.ggread.kalum.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Source {

    String INPUT_DEMO = "demo-input";

    String OUTPUT_DEMO = "demo-output";

    @Input(Source.INPUT_DEMO)
    SubscribableChannel input();

    @Output(Source.OUTPUT_DEMO)
    MessageChannel output();

}
