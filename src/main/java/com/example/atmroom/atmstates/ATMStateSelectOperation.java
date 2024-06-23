package com.example.atmroom.atmstates;

import com.example.atmroom.cashchainofresposibility.CashDispenser;
import com.example.atmroom.cashchainofresposibility.CashDispenser2000;
import com.example.atmroom.exceptions.InsufficientBalanceException;
import com.example.atmroom.models.ATM;
import com.example.atmroom.models.Account;
import com.example.atmroom.models.User;

public class ATMStateSelectOperation extends ATMState {
    public void balanceEnquiry(Account account){
        System.out.println("Your Account Balance is " + account.getBalance());
    }

    public void cashWithDraw(ATM atm, User user, double withdrawAmount){
        if(atm.getTotalCash() < withdrawAmount){
            throw new InsufficientBalanceException("ATM out of cash");
        }
        if(user.getAccount().getBalance() < withdrawAmount){
            throw new InsufficientBalanceException("Insufficient Balance, Try withdrawing lower amount");
        }
        CashDispenser cashDispenser = new CashDispenser2000(atm, withdrawAmount);
        user.getAccount().setBalance(user.getAccount().getBalance() - withdrawAmount);
    }

}
