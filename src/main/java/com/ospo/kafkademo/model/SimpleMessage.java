package com.ospo.kafkademo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SimpleMessage {

    private String id;
    private String message;
}
