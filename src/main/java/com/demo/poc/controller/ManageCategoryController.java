package com.demo.poc.controller;

import com.demo.poc.entity.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController()
public class ManageCategoryController {

    HashMap<String, ArrayList<String>> profileCategoryMapping=new HashMap<String, ArrayList<String>>();

    ArrayList<String> profileType=new ArrayList<>();

    @GetMapping("/api/v1/resumeclassifier/category")
    public String getProfileCategory(@RequestParam("category_name") String categoryName,
                                     @RequestParam("user_name") String userName)
            throws JsonProcessingException {

        CategoryResponse category =new CategoryResponse();

        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<String> profileCategory=new ArrayList<>();

        profileCategory=profileCategoryMapping.get(categoryName);

        category.setProfile_category(profileCategory);
        category.setResponse("Keywords fetched successfully for:-"+categoryName);
        category.setCategory_name(categoryName);

        return objectMapper.writeValueAsString(category);

    }


    @PostMapping("/api/v1/resumeclassifier/category")
    public String postProfileCategory(@RequestBody CategoryList categoryList)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<String> profileCategory=new ArrayList<>();

        profileCategory=profileCategoryMapping.get(categoryList.getCategory_name());

        for(String s:categoryList.getCategory_list()) {

            profileCategory.add(s);
        }

        profileCategoryMapping.put(categoryList.getCategory_name(),profileCategory);

        CategoryResponse category =new CategoryResponse();

        category.setProfile_category(profileCategory);
        category.setResponse("Keywords added successfully for:-"+categoryList.getCategory_name());
        category.setCategory_name(categoryList.getCategory_name());

        return objectMapper.writeValueAsString(category);
    }

    @DeleteMapping("/api/v1/resumeclassifier/category")
    public String deleteProfileCategory(@RequestParam("category_name") String categoryName,
                                        @RequestParam("user_name") String userName,
                                        @RequestParam("keyword_list") ArrayList<String> keyword_list)
            throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<String> profileCategory=new ArrayList<>();

        profileCategory=profileCategoryMapping.get(categoryName);

        for(String s:keyword_list) {

            profileCategory.remove(s);
        }

        profileCategoryMapping.put(categoryName,profileCategory);

        CategoryResponse category =new CategoryResponse();

        category.setProfile_category(profileCategory);
        category.setResponse("Keywords removed successfully for:-"+categoryName);
        category.setCategory_name(categoryName);


        return objectMapper.writeValueAsString(category);
    }

    @GetMapping("/api/v1/resumeclassifier/profileType")
    public String getProfileType(@RequestParam("user_name") String userName)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProfileResponse profileResponse=new ProfileResponse();

        profileResponse.setProfile_type(profileType);
        profileResponse.setResponse("Profile categories fetched successfully");

        return objectMapper.writeValueAsString(profileResponse);
    }

    @PostMapping("/api/v1/resumeclassifier/profileType")
    public String postProfileType(@RequestBody ProfileRequest profileRequest)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProfileResponse profileResponse=new ProfileResponse();

        profileType.add(profileRequest.getProfile_type());

        profileCategoryMapping.put(profileRequest.getProfile_type(),new ArrayList<String>());
        profileResponse.setProfile_type(profileType);
        profileResponse.setResponse("New profile category added successfully");

        return objectMapper.writeValueAsString(profileResponse);
    }

    @DeleteMapping("/api/v1/resumeclassifier/profileType")
    public String deleteProfileType(@RequestParam("profileType") String proType,
                                        @RequestParam("user_name") String userName)
            throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        ProfileResponse profileResponse=new ProfileResponse();

        profileType.remove(proType);
        profileCategoryMapping.remove(proType);

        profileResponse.setProfile_type(profileType);
        profileResponse.setResponse("Profile Category removed successfully");

        return objectMapper.writeValueAsString(profileResponse);
    }

}







