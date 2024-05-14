package com.example.example0509.lotto.dto;

import com.example.example0509.lotto.domain.LottoWithRank;

import java.util.List;

public record ResultDTO(List<LottoWithRank> results) {
    public ResultDTO {
    }

    public static ResultDTO of(LottosDTO lottosDTO) {
        List<LottoWithRank> lottoWithRankList = lottosDTO.lottos().stream()
                .map(lotto -> new LottoWithRank(lotto, null))
                .toList();

        return new ResultDTO(lottoWithRankList);
    }
}
