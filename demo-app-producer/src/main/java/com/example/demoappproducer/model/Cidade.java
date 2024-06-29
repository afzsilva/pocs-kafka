package com.example.demoappproducer.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cidade implements Serializable {
    private String name;
    private String uf;
}
