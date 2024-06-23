package com.example.atmroom.models;

import com.example.atmroom.models.Account;
import com.example.atmroom.models.Card;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private Card card;
    private Account account;
}
