package com.example.vince.carelearning.model;

import android.icu.util.DateInterval;
import android.text.format.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class Session {
    private String token;
    private Calendar dateConnexion;

    public Session(String token){
        this.token = token;
        this.dateConnexion = Calendar.getInstance();

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Calendar dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public boolean sessionOk(){
        Calendar today = Calendar.getInstance();
        Calendar connexionAdd = this.getDateConnexion();
        connexionAdd.add(Calendar.MONTH, 1);
        if (connexionAdd.after(today)){
            this.setToken(null);
            return false;
        }
        return true;
    }
}
