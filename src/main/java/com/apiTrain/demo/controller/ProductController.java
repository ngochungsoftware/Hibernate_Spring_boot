package com.apiTrain.demo.controller;

import com.apiTrain.demo.dto.ProductDTO;
import com.apiTrain.demo.entity.Product;
import com.apiTrain.demo.entity.SubCategory;
import com.apiTrain.demo.service.SubCategoryServiceImpl;
import com.apiTrain.demo.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private SubCategoryServiceImpl subCategoryServiceImpl;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        // cos the dung @JsonIgnore de tranh loi vong lap vo tan
        return new ResponseEntity<>(productServiceImp.getAllProdcuts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        // check brand name -> nêú không có thì trả về fail
        String brandName = productDTO.getBrandName();
        System.out.println(brandName);
        // check subcatagory
        SubCategory subcategory = subCategoryServiceImpl.getSubCategoryByName(productDTO.getSubCategoryName());
        subcategory.setSubCategory_id(1);
        productServiceImp.add(productDTO, brandName, subcategory);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{productName}")
    public ResponseEntity<?> getProductByProductName(@PathVariable String productName) {
        return new ResponseEntity<>(productServiceImp.getProductByProductName(productName), HttpStatus.OK);
    }

    @PutMapping("/{productName}")
    public Product createOrUpdateProduct(@PathVariable String productName,@RequestBody ProductDTO product) {
        // check brand name -> nêú không có thì trả về fail
        String brandName = product.getBrandName();
        System.out.println(brandName);
        // check subcatagory
        SubCategory subcategory = subCategoryServiceImpl.getSubCategoryByName(product.getSubCategoryName());
        subcategory.setSubCategory_id(1);
       return productServiceImp.update(productName,product,brandName,subcategory);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productServiceImp.deleteProductById(id);
    }

    // Endpoint cho chức năng tìm kiếm
    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String subCategoryName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        // Gọi phương thức tìm kiếm của service và trả về kết quả
        List<Product> searchResult = productServiceImp.searchProducts(productName, brandName, subCategoryName, pageRequest);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }
}