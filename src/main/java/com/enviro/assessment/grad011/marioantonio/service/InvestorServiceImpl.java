package com.enviro.assessment.grad011.marioantonio.service;

import com.enviro.assessment.grad011.marioantonio.model.Investor;
import com.enviro.assessment.grad011.marioantonio.respository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorServiceImpl implements InvestorService {
    @Autowired
    InvestorRepository investorRepository;

    @Override
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    @Override
    public Optional<Investor> getInvestorById(Long id){
        return investorRepository.findById(id);
    }
}
