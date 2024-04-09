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


@Entity
@Data
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcate_id;

    @Column(name="sub_cate_code",nullable = false)
    private String subCateCode;

    @Column(name="sub_cate_name",nullable = false)
    private String subCateName;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private Set<Product> listProduct;

    public long getSubCategory_id() {
        return subcate_id;
    }

    public void setSubCategory_id(long subcate_id) {
        this.subcate_id = subcate_id;
    }

    public String getSubCateCode() {
        return subCateCode;
    }

    public void setSubCateCode(String subCateCode) {
        this.subCateCode = subCateCode;
    }

    public String getSubCateName() {
        return subCateName;
    }

    public void setSubCateName(String subCateName) {
        this.subCateName = subCateName;
    }

    public Category getCategory() {
        return category;
    }

    public long getSubcate_id() {
        return subcate_id;
    }

    public void setSubcate_id(long subcate_id) {
        this.subcate_id = subcate_id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
