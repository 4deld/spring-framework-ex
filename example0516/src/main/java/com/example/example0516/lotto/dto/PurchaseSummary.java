package com.example.example0516.lotto.dto;

public record PurchaseSummary(
        String purchaserName,
        Long drawNumberId,
        Long totalPrice
) {
}