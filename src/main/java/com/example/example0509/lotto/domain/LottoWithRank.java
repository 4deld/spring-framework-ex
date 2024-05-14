package com.example.example0509.lotto.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoWithRank {
    Lotto lotto;
    Rank rank;
    public LottoWithRank(Lotto lotto,Rank rank){
        this.lotto=lotto;
        this.rank =rank;
    }

    public void setRank(Rank rank) {
        this.rank=rank;
    }
}
