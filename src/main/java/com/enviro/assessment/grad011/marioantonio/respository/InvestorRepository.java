package com.enviro.assessment.grad011.marioantonio.respository;

import com.enviro.assessment.grad011.marioantonio.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
