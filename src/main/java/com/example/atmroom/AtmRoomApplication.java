package com.example.atmroom;

import com.example.atmroom.models.ATM;
import com.example.atmroom.models.Account;
import com.example.atmroom.models.Card;
import com.example.atmroom.models.User;
import com.example.atmroom.atmstates.ATMStateCardInserted;
import com.example.atmroom.atmstates.ATMStateIdle;
import com.example.atmroom.atmstates.ATMStateSelectOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmRoomApplication {
    public static void main(String[] args) {

        SpringApplication.run(AtmRoomApplication.class, args);
        // initialize system
        ATM atm = iniitializeATM();
        User user = iniitializeUser();

        // checkBalance amd withdraw cash
        /*      1. insertCard
                2. validate PIN
                3. select operation balanceEnquiry
                4. withdraw CASH
        *
        * */
        if(atm.getAtmState() instanceof ATMStateIdle){
            atm = ((ATMStateIdle) atm.getAtmState()).insertCard(atm);
        }
        if (atm.getAtmState() instanceof ATMStateCardInserted) {
            atm = ((ATMStateCardInserted) atm.getAtmState()).authenticateCard(atm, user);
        }
        if(atm.getAtmState() instanceof ATMStateSelectOperation){
            ((ATMStateSelectOperation) atm.getAtmState()).balanceEnquiry(user.getAccount());
        }

        // cashWithDraw
        if(atm.getAtmState() instanceof ATMStateSelectOperation){
            ((ATMStateSelectOperation) atm.getAtmState()).cashWithDraw(atm, user, 2700);
            ((ATMStateSelectOperation) atm.getAtmState()).balanceEnquiry(user.getAccount());
        }

    }

    private static User iniitializeUser() {
        User user = new User();
        user.setId(123L);
        // set card details
        Card card = new Card();
        card.setNumber(12345678L);
        card.setCvv(677);
        card.setPin(1234);
        card.setAccountNumber(500100300L);
        user.setCard(card);

        // set account details
        Account account = new Account().builder()
                            .number(500100300L)
                            .balance(3700.00)
                            .name("Shreyas").build();
        user.setAccount(account);
        return user;
    }

    private static ATM iniitializeATM() {
        ATM atm = new ATM();
        atm.setCountOf2000Notes(2);
        atm.setCountOf500Notes(2);
        atm.setCountOf100Notes(5);
        atm.setAtmState(new ATMStateIdle());
        return atm.setTotalCash();
    }

}
