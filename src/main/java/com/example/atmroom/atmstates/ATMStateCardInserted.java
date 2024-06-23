package com.example.atmroom.atmstates;

import com.example.atmroom.exceptions.InvalidCardException;
import com.example.atmroom.models.ATM;
import com.example.atmroom.models.User;

import java.util.Scanner;

public class ATMStateCardInserted extends ATMState {
    public ATM authenticateCard(ATM atm, User user){
        System.out.println("Enter pin");
        Integer pin = new Scanner(System.in).nextInt();
        if (!pin.equals(user.getCard().getPin())){
            throw new InvalidCardException("Card invalid");
        }
        atm.setAtmState(new ATMStateSelectOperation());
        return atm;
    }
}
