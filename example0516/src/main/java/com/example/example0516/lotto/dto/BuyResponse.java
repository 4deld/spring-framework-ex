package com.example.example0516.lotto.dto;

import java.util.List;

public record BuyResponse(
        List<LottoResponse> lottos
) {
}
