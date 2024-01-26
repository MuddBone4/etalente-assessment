package com.enviro.assessment.grad011.marioantonio.service;

import com.enviro.assessment.grad011.marioantonio.model.Investor;

import java.util.List;
import java.util.Optional;

public interface InvestorService {
    List<Investor> getAllInvestors();

    Optional<Investor> getInvestorById(Long id);
}
