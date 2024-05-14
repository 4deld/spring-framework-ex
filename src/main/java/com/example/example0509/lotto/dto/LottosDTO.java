package com.example.example0509.lotto.dto;

import com.example.example0509.lotto.domain.Lotto;

import java.util.List;

//@Getter @Setter @Tostring @hasheq @Data
public record LottosDTO (List<Lotto> lottos){//response에 들어갈 변수명이 됨
    public LottosDTO{

    }
    public static LottosDTO of(List<Lotto> lottos) { // 오버로딩이 자유롭다. //빌더를 못씀
        return new LottosDTO(lottos);
    }

}
