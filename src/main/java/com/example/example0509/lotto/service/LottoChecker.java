package com.example.example0509.lotto.service;

import com.example.example0509.lotto.domain.Lotto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LottoChecker {
    private static List<Integer> winningNumbers=List.of(11,34,25,16,2,1);
    public boolean check(Lotto lotto){
        return winningNumbers.equals(lotto.getNumbers());
    }
    public Lotto getWinningNumber(){
        return new Lotto(winningNumbers);
    }
}
