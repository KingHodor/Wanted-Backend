package com.iwant.api.model;

import java.math.BigDecimal;

public class SubmitRequest {
    String userId;
    Integer category;
    String phone;
    String email;
    BigDecimal price;
    String description;
    String latitude;
    String longitude;
    String city;
    String country;
    String userIp;
    String userAgent;

    public SubmitRequest() {
    }

    public Integer getCategory() {
        return category;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}