package com.enviro.assessment.grad011.marioantonio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private double currentBalance;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    @JsonIgnore
    private Investor investor;

    @OneToMany(mappedBy = "product")
    private List<WithdrawalNotice> withdrawalNotices;

    public Product(Long id, String type, String name, double currentBalance, Investor investor, List<WithdrawalNotice> withdrawalNotices) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.currentBalance = currentBalance;
        this.investor = investor;
        this.withdrawalNotices = withdrawalNotices;
    }

    public Product(String type, String name, double currentBalance) {
        this.type = type;
        this.name = name;
        this.currentBalance = currentBalance;
        this.withdrawalNotices = new ArrayList<WithdrawalNotice>();
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public List<WithdrawalNotice> getWithdrawalNotices() {
        return withdrawalNotices;
    }

    public void setWithdrawalNotices(List<WithdrawalNotice> withdrawalNotices) {
        this.withdrawalNotices = withdrawalNotices;
    }

    public Boolean isValidWithdrawalAmount(double withdrawalAmount){
        boolean validAge = (type.equals("RETIREMENT") && investor.getAge() > 65) || type.equals("SAVINGS");
        return (withdrawalAmount <= 0.9 * currentBalance) && validAge;
    }

    public WithdrawalNotice createWithdrawalNotice(Date withdrawalDate, double withdrawalAmount){
        if (!isValidWithdrawalAmount(withdrawalAmount)) return null;
        currentBalance -= withdrawalAmount;
        WithdrawalNotice withdrawalNotice = new WithdrawalNotice(withdrawalDate, withdrawalAmount, this);
        withdrawalNotices.add(withdrawalNotice);
        return withdrawalNotice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", currentBalance=" + currentBalance +
                ", investor=" + investor +
                ", withdrawalNotices=" + withdrawalNotices +
                '}';
    }
}
