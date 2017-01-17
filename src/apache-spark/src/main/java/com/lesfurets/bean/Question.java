package com.lesfurets.bean;

import java.io.Serializable;

public class Question implements Serializable {

    private String couverture;

    private String commune;

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

}