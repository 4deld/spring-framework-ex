package com.example.example0509.lotto.service;

import com.example.example0509.lotto.domain.Lotto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // spring framework에서 관리가 시작되고 DI가 가능해짐
public class LottoGenerator {
    private static List<Integer> numbers= List.of(1,2,3,4,5,6);
    public Lotto generate(){
        return new Lotto(numbers);
    }
}
