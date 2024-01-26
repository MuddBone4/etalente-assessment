package com.enviro.assessment.grad011.marioantonio;

import com.enviro.assessment.grad011.marioantonio.model.Investor;
import com.enviro.assessment.grad011.marioantonio.model.Product;
import com.enviro.assessment.grad011.marioantonio.respository.InvestorRepository;
import com.enviro.assessment.grad011.marioantonio.respository.ProductRepository;
import com.enviro.assessment.grad011.marioantonio.respository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DummyDataInitializer implements CommandLineRunner {
    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize investor1
        Investor investor1 = new Investor(
                "John",
                "Doe",
                50,
                "123 Main Street",
                "johndoe@email.com",
                "012 345 6789"
        );

        // Initialize investor2
        Investor investor2 = new Investor(
                "Jane",
                "Smith",
                66,
                "456 New Avenue",
                "janesmith@email.com",
                "098 765 4321"
        );

        // Create products
        Product product1 = new Product("SAVINGS", "product1", 10000.0);
        Product product2 = new Product("RETIREMENT", "product2", 2000.0);
        Product product3 = new Product("RETIREMENT", "product3", 13000.0);

        // Add products to investors
        investor1.addProduct(product1);
        investor1.addProduct(product2);

        investor2.addProduct(product3);

        // Create withdrawal notices
        product1.createWithdrawalNotice(new Date(), product1.getCurrentBalance() * 0.5); // Valid
        product1.createWithdrawalNotice(new Date(), product1.getCurrentBalance() * 0.95); // Invalid
        product2.createWithdrawalNotice(new Date(), product2.getCurrentBalance() * 0.5); // Invalid

        product3.createWithdrawalNotice(new Date(), product3.getCurrentBalance() * 0.5); // Valid

        // Save investors in repository
        investorRepository.save(investor1);
        investorRepository.save(investor2);

        // Save products in repository
        investor1.getProducts().forEach(product -> productRepository.save(product));
        investor2.getProducts().forEach(product -> productRepository.save(product));

        // Save withdrawal notices in repository
        investor1.getProducts()
                .forEach(product -> product.getWithdrawalNotices()
                        .forEach(withdrawalNotice -> withdrawalNoticeRepository.save(withdrawalNotice)
                        ));

        investor2.getProducts()
                .forEach(product -> product.getWithdrawalNotices()
                        .forEach(withdrawalNotice -> withdrawalNoticeRepository.save(withdrawalNotice)
                        ));
    }
}
