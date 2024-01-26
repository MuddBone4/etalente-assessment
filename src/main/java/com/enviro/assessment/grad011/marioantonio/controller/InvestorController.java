package com.enviro.assessment.grad011.marioantonio.controller;

import com.enviro.assessment.grad011.marioantonio.model.Investor;
import com.enviro.assessment.grad011.marioantonio.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class InvestorController {
    @Autowired
    private InvestorService investorService;

    @GetMapping("/investors")
    public List<Investor> getAllInvestors(){
        return investorService.getAllInvestors();
    }

    @GetMapping("/investor/{id}")
    public List<Investor> getInvestorById(@PathVariable Long id){
        Optional<Investor> investorOptional = investorService.getInvestorById(id);

        return investorOptional.map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }
}
