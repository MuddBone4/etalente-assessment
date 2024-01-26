package com.enviro.assessment.grad011.marioantonio.service;

import com.enviro.assessment.grad011.marioantonio.model.WithdrawalNotice;

import java.util.List;

public interface WithdrawalNoticeService {
    WithdrawalNotice createWithdrawalNotice(Long productId, double withdrawalAmount);
    List<WithdrawalNotice> getWithdrawalNoticeByProductId(Long id);
}
