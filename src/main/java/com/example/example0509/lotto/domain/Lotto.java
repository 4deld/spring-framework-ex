package com.example.example0509.lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString //setter는 추가를 잘 안함 생성자를 사용함
@Builder
public class Lotto {
    @Builder.Default
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers){
        this.numbers=numbers;
    }

}
