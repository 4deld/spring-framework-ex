package com.example.example0516.lotto.service;

import com.example.example0516.lotto.repository.PurchaseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseRecordService {
    private final PurchaseRecordRepository purchaseRecordRepository;

}
