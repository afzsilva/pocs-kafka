package com.example.demo_str_producer.controller;

import com.example.demo_str_producer.producer.DemoStrProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/str")
public class StrController {

    @Autowired
    private DemoStrProducer producer;

    @GetMapping
    public ResponseEntity<String> enviarMensagem(){
        String msg = "Mensagem "+getClass().getName()+" - "+LocalDate.now().toString();
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                String s = msg + "X";
                producer.sendMessage(s);
            }
        }
        return ResponseEntity.ok("Ennnnnnviandoooo");
    }
}
