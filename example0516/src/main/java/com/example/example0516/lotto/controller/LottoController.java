package com.example.example0516.lotto.controller;

import com.example.example0516.lotto.domain.Lottos;
import com.example.example0516.lotto.domain.PurchaseRecord;
import com.example.example0516.lotto.dto.BuyRequest;
import com.example.example0516.lotto.dto.BuyResponse;
import com.example.example0516.lotto.dto.LottoResponse;
import com.example.example0516.lotto.service.LottoService;
import com.example.example0516.lotto.service.PurchaseRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lottos")
@RequiredArgsConstructor // auto DI, final 객체만 DI

public class LottoController {
    private final LottoService lottoService;
    private final PurchaseRecordService purchaseRecordService;

    // 로또 구매
    @PostMapping("/purchases")
    public ResponseEntity<BuyResponse> buyLotto(@RequestBody BuyRequest buyRequest) {
        Lottos lottos = lottoService.generateLotto(buyRequest);
        // 저장하는 부분
        purchaseRecordService.logPurchaseRecord(buyRequest, lottos);

        List<LottoResponse> lottoResponses = lottos.getLottos().stream()
                .map(lotto -> new LottoResponse(lotto.getNumbers()))
                .collect(Collectors.toList());

        BuyResponse response = new BuyResponse(lottoResponses);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/get-purchases")
    public ResponseEntity<List<PurchaseRecord>> getPurchases(){
        List<PurchaseRecord> purchaseRecordList = lottoService.getAllPurchaseRecord();
        return ResponseEntity.ok(purchaseRecordList);
    }
}
