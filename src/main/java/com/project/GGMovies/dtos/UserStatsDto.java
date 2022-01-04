package com.project.GGMovies.dtos;

public class UserStatsDto {
    
    Integer month;
    long userCount;

    public UserStatsDto() {
    }

    public UserStatsDto(Integer month, long userCount) {
        this.month = month;
        this.userCount = userCount;
    }
    
     public UserStatsDto(long userCount) {
         this.userCount=userCount;
    }

    

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }
    
}
