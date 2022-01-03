package com.project.GGMovies.dtos;

public class UserStatsDto {
    
    Integer month;
    Integer userCount;

    public UserStatsDto() {
    }

    public UserStatsDto(Integer month, Integer userCount) {
        this.month = month;
        this.userCount = userCount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
    
}
