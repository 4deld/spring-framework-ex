package com.example.example0509.lotto.controller;

import com.example.example0509.lotto.domain.Lotto;
import com.example.example0509.lotto.domain.LottoWithRank;
import com.example.example0509.lotto.dto.LottosDTO;
import com.example.example0509.lotto.dto.ResultDTO;
import com.example.example0509.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lottos")
@RequiredArgsConstructor//auto Di, final 객체만 DI함
public class LottoController {
    private final LottoService lottoService;
    //로또 구매
    @GetMapping() //컨트롤러 메소드명은 클라이언트입장에서 처리
    ResponseEntity<LottosDTO> buyLotto(@RequestParam(name = "amount") Integer amount){
        List<Lotto> lottos = lottoService.generateLotto(amount);
        System.out.println(lottos);
        LottosDTO lottosDTO = LottosDTO.of(lottos);

        return ResponseEntity.status(HttpStatus.OK).body(lottosDTO);
    }
    //당첨번호 조회
    @GetMapping("winning-number")
    ResponseEntity<Lotto> getWinningLottoNumber(){
        Lotto lotto=lottoService.getWinningNumber();

        return ResponseEntity.status(HttpStatus.OK).body(lotto);
    }
    //당첨여부 조회
    @PostMapping("check")
    ResponseEntity<ResultDTO> checkLotto(@RequestBody LottosDTO lottosDTO){
        ResultDTO resultDTO= ResultDTO.of(lottosDTO);
        for (LottoWithRank lottoWithRank : resultDTO.results()) {
            lottoWithRank.setRank(lottoService.checkLotto(lottoWithRank.getLotto()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultDTO);
    }

    //당첨 번호 갱신
    @PutMapping("winning-number")
    ResponseEntity<Lotto> newWinningNumber(@RequestBody Lotto winning){
        //numbers와 REQbody의 json에 있는 numbers가 이름이 같아야 함
        
        lottoService.setWinningNumber(winning.getNumbers());
        Lotto lotto=lottoService.getWinningNumber();
        return ResponseEntity.status(HttpStatus.OK).body(lotto);
    }
}
