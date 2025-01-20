package com.example.demo_str_producer.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoStrProducer {

    @Value("${spring.kafka.topic.producer}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DemoStrProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String msg){
        kafkaTemplate.send(topic,msg);
    }

}
