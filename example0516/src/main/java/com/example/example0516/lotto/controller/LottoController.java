package com.example.example0516.lotto.controller;

import com.example.example0516.lotto.domain.PurchaseRecord;
import com.example.example0516.lotto.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LottoController {
    @Autowired
    LottoService lottoService;

    @GetMapping("/get-purchases")
    public ResponseEntity<List<PurchaseRecord>> getPurchases(){
        List<PurchaseRecord> purchaseRecordList = lottoService.getAllPurchaseRecord();
        return ResponseEntity.ok(purchaseRecordList);
    }
}
