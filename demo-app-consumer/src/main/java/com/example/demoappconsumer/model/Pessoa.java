package com.example.demoappconsumer.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa implements Serializable {
    private String nome;
    private int idade;
}
