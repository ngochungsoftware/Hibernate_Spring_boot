package com.apiTrain.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Entity(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cate_id;

    @Column(name = "cate_code")
    private String cateCode;

    @Column(name = "cate_name")
    private String cateName;

    @OneToMany(mappedBy = "category")
    private Set<SubCategory> listSubCategory;


    public long getCategory_id() {
        return cate_id;
    }

    public void setCategory_id(long category_id) {
        this.cate_id = category_id;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Set<SubCategory> getListSubCategory() {
        return listSubCategory;
    }

    public void setListSubCategory(Set<SubCategory> listSubCategory) {
        this.listSubCategory = listSubCategory;
    }
}
