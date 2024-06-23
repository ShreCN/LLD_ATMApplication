package com.example.atmroom.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long number;
    private String name;
    private Double balance;
}
