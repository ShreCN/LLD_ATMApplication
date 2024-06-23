package com.example.atmroom.atmstates;

import com.example.atmroom.models.ATM;

public class ATMStateIdle extends ATMState {
    public ATM insertCard(ATM atm){
        atm.setAtmState(new ATMStateCardInserted());
        return atm;
    }
}
