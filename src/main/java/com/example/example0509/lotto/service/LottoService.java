package com.example.example0509.lotto.service;

import com.example.example0509.lotto.domain.Lotto;
import com.example.example0509.lotto.domain.Lottos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LottoService {
    private final LottoGenerator lottoGenerator;

    private final static int LOTTO_PRICE=1_000;
    public Lottos generateLotto(int amount){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount/LOTTO_PRICE; i++) {
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public Boolean checkLotto(Lotto lotto){
        return
    }
}
