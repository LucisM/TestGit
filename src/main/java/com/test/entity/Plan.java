package com.test.entity;

public class Plan {
    private String username;

    private String goal;

    private Integer days;

    private Integer remindDays;

    private Integer wordsNumber;

    private Integer wordsFinished;

    private Integer remindDaywords;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal == null ? null : goal.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getRemindDays() {
        return remindDays;
    }

    public void setRemindDays(Integer remindDays) {
        this.remindDays = remindDays;
    }

    public Integer getWordsNumber() {
        return wordsNumber;
    }

    public void setWordsNumber(Integer wordsNumber) {
        this.wordsNumber = wordsNumber;
    }

    public Integer getWordsFinished() {
        return wordsFinished;
    }

    public void setWordsFinished(Integer wordsFinished) {
        this.wordsFinished = wordsFinished;
    }

    public Integer getRemindDaywords() {
        return remindDaywords;
    }

    public void setRemindDaywords(Integer remindDaywords) {
        this.remindDaywords = remindDaywords;
    }
}