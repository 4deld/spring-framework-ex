package com.example.example0509.lotto.controller;

import com.example.example0509.lotto.domain.Lotto;
import com.example.example0509.lotto.domain.Lottos;
import com.example.example0509.lotto.dto.LottosDTO;
import com.example.example0509.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lottos")
@RequiredArgsConstructor//auto Di, final 객체만 DI함
public class LottoController {
    private final LottoService lottoService;
    //로또 구매
    @GetMapping() //컨트롤러 메소드명은 클라이언트입장에서 처리
    ResponseEntity<LottosDTO> buyLotto(@RequestParam(name = "amount") Integer amount){
        Lottos lottos = lottoService.generateLotto(amount);
        LottosDTO lottosDTO = LottosDTO.of(lottos);

        return ResponseEntity.status(HttpStatus.OK).body(lottosDTO);
    }
    //당첨번호 조회
    @GetMapping("winning-number")
    ResponseEntity<?> getWinningLottoNumber(){
        Lotto lotto=lottoService.getWinningNumber();

        return ResponseEntity.status(HttpStatus.OK).body(lotto);
    }
    //당첨여부 조회
    @PostMapping("check")
    ResponseEntity<?> checkLotto(@RequestBody Lotto lotto){
        boolean result = lottoService.checkLotto(lotto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
