package com.davy.chhouk.seseniorproject.model;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
    private String title;
    private Date dateTime;
    private String who;

    public Todo() {
    }

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

    public long getMillis() {
        String myDate = getDateTime().getYear() + "/" + getDateTime().getMonth() + "/" + getDateTime().getDate() + " " + getDateTime().getHours() + ":" + getDateTime().getMinutes() +
                ":" + getDateTime().getSeconds();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = getDateTime();
        try {
            date = sdf.parse(myDate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return date.getTime();
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

    @SuppressLint("DefaultLocale")
    public String getStringTodo() {
        return title + " " + String.format("%02d", dateTime.getDate()) + "/" + String.format("%02d", dateTime.getMonth()) + "/" + dateTime.getYear()
                + " " + String.format("%02d", dateTime.getHours()) + ":" + String.format("%02d", dateTime.getMinutes()) + " by " + who;
    }
}
