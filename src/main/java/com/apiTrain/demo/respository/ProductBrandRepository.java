package com.apiTrain.demo.respository;
import com.apiTrain.demo.entity.ProductBrand;
import com.apiTrain.demo.entity.keys.IdProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, IdProductBrand> {
}
