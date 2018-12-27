package com.demo.poc.entity;

import java.util.ArrayList;

public class CategoryResponse {

    private ArrayList<String> profile_category;
    String response;
    String category_name;

    public ArrayList<String> getProfile_category() {
        return profile_category;
    }

    public void setProfile_category(ArrayList<String> profile_category) {
        this.profile_category = profile_category;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
