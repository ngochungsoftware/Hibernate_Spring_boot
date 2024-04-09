package com.apiTrain.demo.controller;

import com.apiTrain.demo.entity.SubCategory;
import com.apiTrain.demo.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/")
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/{id}")
    public SubCategory getSubCategoryById(@PathVariable long id) {
        return subCategoryService.getSubCategoryById(id);
    }

    @PostMapping("/")
    public SubCategory createOrUpdateSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.saveOrUpdateSubCategory(subCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable long id) {
        subCategoryService.deleteSubCategory(id);
    }
}
