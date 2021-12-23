/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Transaction;
import com.project.GGMovies.models.User;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author odi
 */
public class TransactionDto {
    
    Integer id;
    Date date;
    BigDecimal amountDto;
    short statusDto;
    String typeDto;
    Integer userDto;

    public TransactionDto(Integer id, Date date, BigDecimal amountDto, short statusDto, String typeDto) {
        this.id = id;
        this.date = date;
        this.amountDto = amountDto;
        this.statusDto = statusDto;
        this.typeDto = typeDto;
    }

    public TransactionDto(Integer id, Date date, BigDecimal amountDto, short statusDto, String typeDto, Integer userDto) {
        this.id = id;
        this.date = date;
        this.amountDto = amountDto;
        this.statusDto = statusDto;
        this.typeDto = typeDto;
        this.userDto = userDto;
    }

    public TransactionDto() {
    }
    
    public TransactionDto(Transaction transaction) {
        this.id = transaction.getTransactionsId();
        this.date = transaction.getDateTime();
        this.amountDto = transaction.getAmount();
        this.statusDto = transaction.getStatus();
        this.typeDto = transaction.getType();
        this.userDto = transaction.getUser().getUserId(); 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserDto() {
        return userDto;
    }

    public void setUserDto(Integer userDto) {
        this.userDto = userDto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmountDto() {
        return amountDto;
    }

    public void setAmountDto(BigDecimal amountDto) {
        this.amountDto = amountDto;
    }

    public short getStatusDto() {
        return statusDto;
    }

    public void setStatusDto(short statusDto) {
        this.statusDto = statusDto;
    }

    public String getTypeDto() {
        return typeDto;
    }

    public void setTypeDto(String typeDto) {
        this.typeDto = typeDto;
    }

    
}
