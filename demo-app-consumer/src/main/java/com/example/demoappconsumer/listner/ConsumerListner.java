package com.example.demoappconsumer.listner;


import com.example.demoappconsumer.model.Cidade;
import com.example.demoappconsumer.model.Pessoa;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsumerListner {

    final String TOPICO_TESTE = "meu_topico_teste";

    @KafkaListener(topics = TOPICO_TESTE , groupId = "grupo-1")
    public void listen(String message){
        System.out.println("RECEBIDO ---> "+message+" : "+ LocalDateTime.now());
    }

    @KafkaListener(topics ="meu_topico_objeto" , groupId = "grupo-1")
    public void listen(Pessoa pessoa){
        System.out.println("RECEBIDO ---> "+pessoa+" : "+ LocalDateTime.now());
    }

    @KafkaListener(topics ="meu_topico_objeto" , groupId = "grupo-1")
    public void listenDinamico(Cidade cidade){
        System.out.println("RECEBIDO ---> "+cidade+" : "+ LocalDateTime.now());
    }
}
