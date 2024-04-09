package com.apiTrain.demo.service;

import com.apiTrain.demo.entity.SubCategory;
import com.apiTrain.demo.respository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategoryById(long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public SubCategory saveOrUpdateSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }


    public SubCategory getSubCategoryByName(String name) {
        return subCategoryRepository.findBySubCateName(name);
    }


    @Override
    public void deleteSubCategory(long id) {
        subCategoryRepository.deleteById(id);
    }
}
