package com.enviro.assessment.grad011.marioantonio.respository;

import com.enviro.assessment.grad011.marioantonio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
