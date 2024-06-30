package br.com.afzdev.strprducer.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", msg);
        future.whenComplete((stringStringSendResult, throwable) -> {
           if (throwable != null ){
               log.error("Não foi possivel entrega a mensagem");
           }else{
               log.info("Mensagem entregue com sucesso "+stringStringSendResult);
           }

        });
    }
}
