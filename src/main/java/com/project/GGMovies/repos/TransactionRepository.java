/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.models.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author odi
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    
    @Query("SELECT new com.project.GGMovies.dtos.TransactionDto(t.transactionsId, t.dateTime, t.amount, t.status, t.type, t.user.email) from Transaction t")
    public List<TransactionDto> getAllTransactions();
    
    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Month(t.dateTime),Sum(t.amount)) from Transaction t where t.status = true GROUP BY Month(t.dateTime)")
    public List<SalesStatsDto> getMonthlySalesStats();
    
    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and MONTH(t.dateTime)=MONTH(curdate())")
    public SalesStatsDto getThisMonthSales();
}
