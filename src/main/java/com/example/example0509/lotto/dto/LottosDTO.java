package com.example.example0509.lotto.dto;

import com.example.example0509.lotto.domain.Lottos;

//@Getter @Setter @Tostring @hasheq @Data
public record LottosDTO {
    Lottos lottos //response에 들어갈 변수명이 됨
}{
    public static LottosDTO of(Lottos lottos){

    }
}
