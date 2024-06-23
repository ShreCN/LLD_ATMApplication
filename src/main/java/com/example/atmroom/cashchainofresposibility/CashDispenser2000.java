package com.example.atmroom.cashchainofresposibility;

import com.example.atmroom.models.ATM;

public class CashDispenser2000 extends CashDispenser {
    public CashDispenser2000(ATM atm, double withdrawAmount) {
        int count = atm.getCountOf2000Notes();
        int requiredCount = (int) (withdrawAmount/2000);
        int remainingAmount = (int) (withdrawAmount%2000);
        atm.setTotalCash(atm.getTotalCash() - (requiredCount*2000));
        atm.setCountOf2000Notes(count - requiredCount);
        if (remainingAmount != 0){
            new CashDispenser500(atm, remainingAmount);
        }
        System.out.println("Collect 2000 * "+requiredCount + " = " + (withdrawAmount - remainingAmount) + " rupees");
    }
}
