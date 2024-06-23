package com.example.atmroom.models;

import com.example.atmroom.atmstates.ATMState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATM {
    private Long id;
    private Double totalCash;
    private Integer countOf2000Notes;
    private Integer countOf500Notes;
    private Integer countOf100Notes;
    private ATMState atmState;

    public ATM setTotalCash(){
        this.totalCash = (double) ((this.countOf2000Notes * 2000)
                        + this.countOf500Notes * 500 + (this.countOf100Notes * 100));
        return this;
    }
}
