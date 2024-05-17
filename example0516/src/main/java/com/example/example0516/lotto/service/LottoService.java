package com.example.example0516.lotto.service;

import com.example.example0516.lotto.domain.PurchaseRecord;
import com.example.example0516.lotto.domain.repository.PurchaseRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LottoService {
    @Autowired
    PurchaseRecordRepository purchaseRecordRepository;

    public List<PurchaseRecord> getAllPurchaseRecord(){
        List<PurchaseRecord> purchaseRecordList = purchaseRecordRepository.findAll();
        System.out.print(purchaseRecordList);
        return purchaseRecordList;
    }
}
