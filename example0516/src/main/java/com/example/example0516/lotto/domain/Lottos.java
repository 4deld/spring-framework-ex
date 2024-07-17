package com.example.example0516.lotto.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}

