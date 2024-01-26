package com.enviro.assessment.grad011.marioantonio.controller;

import com.enviro.assessment.grad011.marioantonio.model.WithdrawalNotice;
import com.enviro.assessment.grad011.marioantonio.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WithdrawalNoticeController {

    @Autowired
    private WithdrawalNoticeService withdrawalNoticeService;

    @PostMapping("/withdrawal-notice/{productId}/{withdrawalAmount}")
    public ResponseEntity<WithdrawalNotice> createWithdrawalNotice(
            @PathVariable Long productId,
            @PathVariable double withdrawalAmount
    ){
        try{
            WithdrawalNotice withdrawalNotice = withdrawalNoticeService.createWithdrawalNotice(productId, withdrawalAmount);
            return ResponseEntity.ok().body(withdrawalNotice);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/withdrawal-notices/{productId}")
    public List<WithdrawalNotice> getWithdrawalNoticeByProductId(@PathVariable Long productId) {
        System.out.println(productId);
        return withdrawalNoticeService.getWithdrawalNoticeByProductId(productId);
    }
}
