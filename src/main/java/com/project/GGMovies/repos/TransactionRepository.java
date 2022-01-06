/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.models.Transaction;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author odi
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT new com.project.GGMovies.dtos.TransactionDto(t.transactionsId, t.dateTime, t.amount, t.status, t.type, t.user.email) from Transaction t")
    public List<TransactionDto> getAllTransactions();

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Month(t.dateTime),Sum(t.amount)) from Transaction t where t.status = true GROUP BY Month(t.dateTime)")
    public List<SalesStatsDto> getMonthlySalesStats();

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and date(t.dateTime)>?1 and date(t.dateTime)<?2")
    public SalesStatsDto getThisMonthSales(Date monthStart, Date monthEnd);

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and date(t.dateTime)=curdate()")
    public SalesStatsDto getTodaySales();

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and date(t.dateTime)=?1")
    public SalesStatsDto getTodaySales(Date date);

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and Year(t.dateTime)=Year(curdate())")
    public SalesStatsDto getThisYearSales();

    @Query("SELECT new com.project.GGMovies.dtos.SalesStatsDto(Sum(t.amount)) from Transaction t where t.status = true and Year(t.dateTime)=Year(curdate())-1")
    public SalesStatsDto getLastYearSales();

}
