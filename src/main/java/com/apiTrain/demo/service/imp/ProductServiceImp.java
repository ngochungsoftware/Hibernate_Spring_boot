package com.apiTrain.demo.service.imp;

import com.apiTrain.demo.dto.ProductDTO;
import com.apiTrain.demo.entity.Product;
import com.apiTrain.demo.entity.SubCategory;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductServiceImp {
    List<ProductDTO> getAllProdcuts();

    ProductDTO getProductByProductName(String productName);

    void deleteProductById(long id);

    Product saveOrUpdateProduct(Product product);

    Product update(String productName, ProductDTO productDTO, String brandName, SubCategory subcategory);

    Product add(ProductDTO productDTO, String brandName, SubCategory subcategory);

    List<Product> searchProducts(String productName, String brandName, String subCategoryName, PageRequest pageRequest);

    List<ProductDTO> searchProducts2(Product product);
}
