package com.iwant.api.model;

import java.util.List;

public class WantersRequest {
    int pageNum;
    int perPageCount;
    List<Integer> categories;
    String country;

    public WantersRequest() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPerPageCount() {
        return perPageCount;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public String getCountry() {
        return country;
    }
}