package com.example.example0516.lotto.service;

import com.example.example0516.lotto.domain.Lotto;
import com.example.example0516.lotto.domain.Lottos;
import com.example.example0516.lotto.domain.PurchaseRecord;
import com.example.example0516.lotto.dto.BuyRequest;
import com.example.example0516.lotto.dto.PurchaseSummary;
import com.example.example0516.lotto.repository.PurchaseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LottoService {
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final PurchaseRecordService purchaseRecordService;

    @Transactional
    public Lottos generateLotto(BuyRequest request) {
        PurchaseSummary purchaseSummary = purchaseRecordService.findTotalPrice(request);
        if (purchaseSummary.totalPrice() >= 100000) { // 사용자가 구매 금액이 10만원보다 크다면
            log.info("{} 의 {} 회차 구매 금액은 {}원 입니다.", purchaseSummary.purchaserName(), purchaseSummary.drawNumberId(), purchaseSummary.totalPrice());
            throw new IllegalArgumentException();
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < request.amount() / LOTTO_PRICE; i++) {
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public List<PurchaseRecord> getAllPurchaseRecord(){
        List<PurchaseRecord> purchaseRecordList = purchaseRecordRepository.findAll();
        System.out.print(purchaseRecordList);
        return purchaseRecordList;
    }
}
