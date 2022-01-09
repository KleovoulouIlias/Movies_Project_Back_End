package com.project.GGMovies.services;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import java.util.List;

public interface ITransactionService {

    public List<TransactionDto> getAllTransactions();

    public List<SalesStatsDto> getMonthlySalesStats();

    public List<SalesStatsDto> getLastTwoMonthsSales();

    public List<SalesStatsDto> getLastTwoDaysSales();

    public List<SalesStatsDto> getLastTwoYearsSales();
    
    public List<TransactionDto> getLastTransactions();
}
