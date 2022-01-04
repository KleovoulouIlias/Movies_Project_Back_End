/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author odi
 */
@Service
public class TransactionSeriveImpl implements ITransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    
    @Autowired
    IUserService iUserService;
    
   @Override
    public List<TransactionDto> getAllTransactions() {
        List<TransactionDto> result =  transactionRepository.getAllTransactions();
        return result;
    } 

    @Override
    public List<SalesStatsDto> getMonthlySalesStats() {
        return transactionRepository.getMonthlySalesStats();
    }

    @Override
    public SalesStatsDto getThisMonthSales() {
        return transactionRepository.getThisMonthSales();
    }
    
}
