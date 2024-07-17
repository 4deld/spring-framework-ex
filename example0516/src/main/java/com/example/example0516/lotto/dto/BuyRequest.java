package com.example.example0516.lotto.dto;

import com.example.example0516.lotto.domain.PurchaseType;

public record BuyRequest(
        String purchaserName,
        Integer amount,
        PurchaseType purchaseType,
        Long drawNumberId
) {
}
