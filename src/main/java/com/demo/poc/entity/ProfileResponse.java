package com.demo.poc.entity;

import java.util.ArrayList;

public class ProfileResponse {

    private ArrayList<String> profile_type;
    String response;

    public ArrayList<String> getProfile_type() {
        return profile_type;
    }

    public void setProfile_type(ArrayList<String> profile_type) {
        this.profile_type = profile_type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
