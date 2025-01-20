package com.example.demostr.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;



@Component
public class DemoStrListener {

    Logger logger = LoggerFactory.getLogger(DemoStrListener.class);
    int contador = 1;

    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 1000, multiplier = 2),autoCreateTopics = "true", dltTopicSuffix = "-dlt")
    @KafkaListener(topics = "str-topic")
    public void mensagemStr(String message){
        System.out.println("Tentando..."+contador++);
        if (message.contains("X")){
            throw new RuntimeException("Deu problema aqui ....");
        }
        System.out.println("Mensagem recebida >>> "+message.toUpperCase());
    }

    @DltHandler
    public void mensagemStrDLT(String message){
        logger.info("Deu problema ao tentar receber mensagem {} ",message);
    }



}
