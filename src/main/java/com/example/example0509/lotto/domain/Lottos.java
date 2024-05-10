package com.example.example0509.lotto.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString
public class Lottos {
    private List<Lotto> lotto=new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
    }

}
