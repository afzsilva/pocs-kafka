package com.example.demoappproducer.controller;

import com.example.demoappproducer.model.Cidade;
import com.example.demoappproducer.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Value("${topico.fake.teste}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @GetMapping
    public ResponseEntity<String> enviarMensagem(){
        String message = "Ola mundo kafka";
        kafkaTemplate.send(topicName, message);
        return ResponseEntity.ok("Mensagem enviada para o topico");
    }

    @GetMapping("obj")
    public ResponseEntity<String> enviarMensagemObjeto(){
        Pessoa pessoa = new Pessoa("Maria", 26);
        jsonKafkaTemplate.send(topicName, pessoa);
        return ResponseEntity.ok("Mensagem enviada para o topico "+pessoa.toString());
    }

    @GetMapping("objd")
    public ResponseEntity<String> enviarMensagemObjetoDinamico(){
        Cidade cidade = new Cidade("Maceio","AL");
        jsonKafkaTemplate.send(topicName, cidade);
        return ResponseEntity.ok("Mensagem enviada para o topico "+cidade.toString());
    }

}
