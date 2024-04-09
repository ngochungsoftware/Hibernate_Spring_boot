package com.apiTrain.demo.service;

import com.apiTrain.demo.entity.SubCategory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface SubCategoryService  {
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategoryById(long id);
    SubCategory saveOrUpdateSubCategory(SubCategory subCategory);
    void deleteSubCategory(long id);
}
