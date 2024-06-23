package com.example.atmroom.cashchainofresposibility;

import com.example.atmroom.exceptions.InvalidAmountException;
import com.example.atmroom.models.ATM;

public class CashDispenser100 {
    public CashDispenser100(ATM atm, int withdrawAmount) {
        int count = atm.getCountOf2000Notes();
        int requiredCount = (int) (withdrawAmount/100);
        int remainingAmount = (int) (withdrawAmount%100);
        atm.setTotalCash(atm.getTotalCash() - (requiredCount*100));
        atm.setCountOf2000Notes(count - requiredCount);
        if (remainingAmount != 0){
            new InvalidAmountException("Enter Amount in multiples of 100");
        }
        System.out.println("Collect 100 * "+requiredCount + " = " + (withdrawAmount - remainingAmount) + " rupees");
    }
}
