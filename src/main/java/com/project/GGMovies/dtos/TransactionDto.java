package com.project.GGMovies.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDto {
    
    private Integer id;
    private Date transactionDate;
    private BigDecimal transactionAmount;
    private boolean transactionStatus;
    private String transactionType;
    private String userEmail;

    public TransactionDto() {
    }

    public TransactionDto(Integer id, Date transactionDate, BigDecimal transactionAmount, boolean transactionStatus, String transactionType, String userEmail) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.userEmail = userEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getUser() {
        return userEmail;
    }

    public void setUser(String userEmail) {
        this.userEmail = userEmail;
    }
  
}
