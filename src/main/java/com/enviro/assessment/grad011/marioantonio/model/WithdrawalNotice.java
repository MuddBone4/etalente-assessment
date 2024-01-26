package com.enviro.assessment.grad011.marioantonio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double withdrawalAmount;
    private Date withdrawalDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public WithdrawalNotice(Long id, double withdrawalAmount, Date withdrawalDate, Product product) {
        this.id = id;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.product = product;
    }

    public WithdrawalNotice(Date withdrawalDate, double withdrawalAmount, Product product) {
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.product = product;
    }

    public WithdrawalNotice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "WithdrawalNotice{" +
                "id=" + id +
                ", withdrawalAmount=" + withdrawalAmount +
                ", withdrawalDate=" + withdrawalDate +
                ", product=" + product +
                '}';
    }
}
