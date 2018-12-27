package com.demo.poc.entity;

import java.util.ArrayList;

public class CategoryList {

    private String category_name;
    private String user_name;
    private ArrayList<String> category_list;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public ArrayList<String> getCategory_list() {
        return category_list;
    }

    public void setCategory_list(ArrayList<String> category_list) {
        this.category_list = category_list;
    }
}
