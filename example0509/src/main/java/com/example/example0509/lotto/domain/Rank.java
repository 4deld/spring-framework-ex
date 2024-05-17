package com.example.example0509.lotto.domain;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Rank {
    private Integer rank;


    public Rank(Integer rank) {
        this.rank=rank;
    }
}
