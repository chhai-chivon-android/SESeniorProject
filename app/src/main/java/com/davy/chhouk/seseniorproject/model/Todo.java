package com.davy.chhouk.seseniorproject.model;

import java.util.Date;

public class Todo {
    private String title;
    private Date dateTime;
    private String who;

    public Todo(String title, Date dateTime, String who) {
        this.title = title;
        this.dateTime = dateTime;
        this.who = who;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Long getMilli() {
        return dateTime.getTime();
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getStringTodo() {
        return title + " " + dateTime.getDate() + "/" + dateTime.getMonth() + "/" + dateTime.getYear() + " " + dateTime.getHours() + ":" + dateTime.getMinutes() + " " + who;
    }
}
