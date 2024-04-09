package com.apiTrain.demo.respository;

import com.apiTrain.demo.dto.ProductDTO;
import com.apiTrain.demo.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.product_name AS productName, " +
            "b.brand_name AS brandName, " +
            "sc.sub_cate_name AS subCategoryName, " +
            "p.sell_price AS sellPrice, " +
            "st.status_name AS statusName " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN status st ON p.status_id = st.status_id " +
            "LEFT JOIN product_brand pb ON p.product_id = pb.product_id " +
            "LEFT JOIN brand b ON pb.brand_id = b.brand_id", nativeQuery = true)
    List<Object[]> findAllProductDetails();

    @Query(value = "SELECT p.product_id AS productId, " +
            "p.product_name AS productName, " +
            "b.brand_name AS brandName, " +
            "sc.sub_cate_name AS subCategoryName, " +
            "p.color AS color, " +
            "p.quantity AS quantity, " +
            "p.sell_price AS sellPrice, " +
            "p.origin_price AS originPrice, " +
            "st.status_name AS statusName " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN status st ON p.status_id = st.status_id " +
            "LEFT JOIN product_brand pb ON p.product_id = pb.product_id " +
            "LEFT JOIN brand b ON pb.brand_id = b.brand_id " +
            "WHERE p.product_name = :productName", nativeQuery = true)
    List<Object[]> findProductByName(@Param("productName") String productName);

    @Query(value = "SELECT p.product_id AS productId, " +
            "p.product_name AS productName, " +
            "b.brand_name AS brandName, " +
            "sc.sub_cate_name AS subCategoryName, " +
            "p.color AS color, " +
            "p.quantity AS quantity, " +
            "p.sell_price AS sellPrice, " +
            "p.origin_price AS originPrice, " +
            "st.status_name AS statusName " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN status st ON p.status_id = st.status_id " +
            "LEFT JOIN product_brand pb ON p.product_id = pb.product_id " +
            "LEFT JOIN brand b ON pb.brand_id = b.brand_id " +
            "WHERE p.product_name = :productName", nativeQuery = true)
    Product findProductByProductName(@Param("productName") String productName);


    @Query(value = "SELECT p.product_id AS productId, " +
            "p.product_name AS productName, " +
            "b.brand_name AS brandName, " +
            "sc.sub_cate_name AS subCategoryName, " +
            "p.color AS color, " +
            "p.quantity AS quantity, " +
            "p.sell_price AS sellPrice, " +
            "p.origin_price AS originPrice, " +
            "st.status_name AS statusName " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN status st ON p.status_id = st.status_id " +
            "LEFT JOIN product_brand pb ON p.product_id = pb.product_id " +
            "LEFT JOIN brand b ON pb.brand_id = b.brand_id " +
            "WHERE (:#{#product.productName} IS NULL OR p.product_name = :#{#product.productName}) " +
            "AND (:#{#product.brandName} IS NULL OR b.brand_name = :#{#product.brandName})",
            nativeQuery = true)
    List<Object[]> searchProducts(@Param("product") Product product);

    @Query(value = "SELECT p.product_id AS productId, " +
            "p.product_name AS productName, " +
            "b.brand_name AS brandName, " +
            "sc.sub_cate_name AS subCategoryName, " +
            "p.color AS color, " +
            "p.quantity AS quantity, " +
            "p.sell_price AS sellPrice, " +
            "p.origin_price AS originPrice, " +
            "st.status_name AS statusName " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN status st ON p.status_id = st.status_id " +
            "LEFT JOIN product_brand pb ON p.product_id = pb.product_id " +
            "LEFT JOIN brand b ON pb.brand_id = b.brand_id " +
            "WHERE (:productName IS NULL OR p.product_name = :productName) " +
            "OR (:brandName IS NULL OR b.brand_name = :brandName) " +
            "OR (:subCategoryName IS NULL OR sc.sub_cate_name = :subCategoryName) " +
            "OR (:statusName IS NULL OR st.status_name = :statusName) " +
            "OR (:minPrice IS NULL OR p.sell_price >= :minPrice)",
            nativeQuery = true)
    List<Object[]> searchProducts(
            @Param("productName") String productName,
            @Param("brandName") String brandName,
            @Param("subCategoryName") String subCategoryName,
            @Param("statusName") String statusName,
            @Param("minPrice") Long minPrice);


    @Query(value = "SELECT p.* " +
            "FROM product p " +
            "JOIN sub_category sc ON p.subcate_id = sc.subcate_id " +
            "JOIN product_brand pb ON p.product_id = pb.product_id " +
            "JOIN brand b ON pb.brand_id = b.brand_id " +
            "WHERE (:productName IS NULL OR p.product_name LIKE %:productName%) " +
            "AND (:brandName IS NULL OR b.brand_name LIKE %:brandName%) " +
            "AND (:subCategoryName IS NULL OR sc.sub_cate_name LIKE %:subCategoryName%) ",
            nativeQuery = true)
    List<Product> searchProductsByNameBrandSubcate(
            @Param("productName") String productName, @Param("brandName") String brandName,
            @Param("subCategoryName") String subCategoryName, Pageable pageable);
//    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
//    List<Product> findByProductName(@Param("productName") String productName);
//
//    @Query("SELECT p FROM Product p JOIN p.product_brands pb JOIN pb.brand b WHERE b.brandName = :brandName")
//    List<Product> findByBrandName(@Param("brandName") String brandName);
//
//    @Query("SELECT p FROM Product p WHERE p.subCategory.subCategoryName = :subCategoryName")
//    List<Product> findBySubCategoryName(@Param("subCategoryName") String subCategoryName);
//
//    @Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.brand.brandName = :brandName")
//    List<Product> findByProductNameAndBrandName(@Param("productName") String productName, @Param("brandName") String brandName);
//
//    @Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.subCategory.subCategoryName = :subCategoryName")
//    List<Product> findByProductNameAndSubCategoryName(@Param("productName") String productName, @Param("subCategoryName") String subCategoryName);
//
//    @Query("SELECT p FROM Product p WHERE p.brand.brandName = :brandName AND p.subCategory.subCategoryName = :subCategoryName")
//    List<Product> findByBrandNameAndSubCategoryName(@Param("brandName") String brandName, @Param("subCategoryName") String subCategoryName);
//
//    @Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.brand.brandName = :brandName AND p.subCategory.subCategoryName = :subCategoryName")
//    List<Product> findByProductNameAndBrandNameAndSubCategoryName(@Param("productName") String productName, @Param("brandName") String brandName, @Param("subCategoryName") String subCategoryName);






}
