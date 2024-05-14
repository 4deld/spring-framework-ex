package com.example.example0509.lotto.service;

import com.example.example0509.lotto.domain.Lotto;
import com.example.example0509.lotto.domain.Rank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LottoChecker {
    private static List<Integer> winningNumbers=List.of(11,34,25,16,2,1);
    public Integer check(Lotto lotto){
        if(winningNumbers.equals(lotto.getNumbers()))
            return 1;
        return null;
    }
    public Lotto getWinningNumber(){
        return new Lotto(winningNumbers);
    }

    public  void setWinningNumber(List<Integer> lotto){
        this.winningNumbers=lotto;
    }
}
