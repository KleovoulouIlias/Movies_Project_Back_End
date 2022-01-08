package com.project.GGMovies.services;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.repos.TransactionRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionSeriveImpl implements ITransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    IUserService iUserService;

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<TransactionDto> result = transactionRepository.getAllTransactions();
        return result;
    }

    @Override
    public List<SalesStatsDto> getMonthlySalesStats() {
        return transactionRepository.getMonthlySalesStats();
    }

    @Override
    public List<SalesStatsDto> getLastTwoMonthsSales() {
        LocalDate lastStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastEnd = LocalDate.now().minusMonths(1).withDayOfMonth(lastStart.lengthOfMonth());
        LocalDate thisStart = LocalDate.now().withDayOfMonth(1);
        LocalDate thisEnd = LocalDate.now().withDayOfMonth(thisStart.lengthOfMonth());
        List<SalesStatsDto> result = new ArrayList();
        result.add(transactionRepository.getThisMonthSales(Date.valueOf(lastStart), Date.valueOf(lastEnd)));
        result.add(transactionRepository.getThisMonthSales(Date.valueOf(thisStart), Date.valueOf(thisEnd)));
        return result;
    }

    @Override
    public List<SalesStatsDto> getLastTwoDaysSales() {
        LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        Date yesterday = Date.valueOf(yesterdayLocalDate);
        List<SalesStatsDto> result = new ArrayList();
        result.add(transactionRepository.getTodaySales(yesterday));
        result.add(transactionRepository.getTodaySales());
        return result;
    }

    @Override
    public List<SalesStatsDto> getLastTwoYearsSales() {
        List<SalesStatsDto> result = new ArrayList();
        result.add(transactionRepository.getLastYearSales());
        result.add(transactionRepository.getThisYearSales());
        return result;
    }

}
