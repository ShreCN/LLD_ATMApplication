package com.example.atmroom.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private Long number;
    private Integer cvv;
    private Long accountNumber;
    private Integer pin;
}
