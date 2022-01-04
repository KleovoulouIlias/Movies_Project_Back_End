
package com.project.GGMovies.dtos;

import java.math.BigDecimal;


public class SaleStatsDto {
        private Integer month;
        private BigDecimal sum;

    public SaleStatsDto() {
    }

    public SaleStatsDto(Integer month, BigDecimal sum) {
        this.month = month;
        this.sum = sum;
    }
    
      public SaleStatsDto(BigDecimal sum) {
        this.sum = sum;  
    }


    public BigDecimal getSum() {
        return sum;
    }

    public void setSum( BigDecimal sum) {
        this.sum = sum;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
        
        
}
