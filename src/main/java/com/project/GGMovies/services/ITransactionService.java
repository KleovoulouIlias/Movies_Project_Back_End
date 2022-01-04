/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import java.util.List;

/**
 *
 * @author odi
 */
public interface ITransactionService {
    public List<TransactionDto> getAllTransactions();
    public List<SalesStatsDto> getMonthlySalesStats();
    public SalesStatsDto getThisMonthSales();
}
