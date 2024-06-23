package com.example.atmroom.cashchainofresposibility;

import com.example.atmroom.models.ATM;

public class CashDispenser500 {
    public CashDispenser500(ATM atm, int withdrawAmount) {
        int count = atm.getCountOf2000Notes();
        int requiredCount = (int) (withdrawAmount/500);
        int remainingAmount = (int) (withdrawAmount%500);
        atm.setTotalCash(atm.getTotalCash() - (requiredCount*500));
        atm.setCountOf2000Notes(count - requiredCount);
        if (remainingAmount != 0){
            new CashDispenser100(atm, remainingAmount);
        }
        System.out.println("Collect 500 * "+requiredCount + " = " + (withdrawAmount - remainingAmount) + " rupees");
    }
}
