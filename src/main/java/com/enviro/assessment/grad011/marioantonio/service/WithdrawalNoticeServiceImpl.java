package com.enviro.assessment.grad011.marioantonio.service;

import com.enviro.assessment.grad011.marioantonio.model.Product;
import com.enviro.assessment.grad011.marioantonio.model.WithdrawalNotice;
import com.enviro.assessment.grad011.marioantonio.respository.ProductRepository;
import com.enviro.assessment.grad011.marioantonio.respository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {
    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public WithdrawalNotice createWithdrawalNotice(Long productId, double withdrawalAmount) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.orElse(null);
        if (product != null) {
            WithdrawalNotice withdrawalNotice = product.createWithdrawalNotice(new Date(), withdrawalAmount);
            withdrawalNoticeRepository.save(withdrawalNotice);
            return withdrawalNotice;
        }
        return null;
    }

    @Override
    public List<WithdrawalNotice> getWithdrawalNoticeByProductId(Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.orElse(null);
        if (product != null) {
            return product.getWithdrawalNotices();
        }
        return Collections.emptyList();
    }
}
