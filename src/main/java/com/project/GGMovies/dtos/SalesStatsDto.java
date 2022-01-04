package com.project.GGMovies.dtos;

import java.math.BigDecimal;

public class SalesStatsDto {
   
    Integer month;
    BigDecimal sum;

    public SalesStatsDto() {
    }

    public SalesStatsDto(Integer month, BigDecimal sum) {
        this.month = month;
        this.sum = sum;
    }
    public SalesStatsDto(BigDecimal sum) {
        this.sum = sum;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
    
    
}
