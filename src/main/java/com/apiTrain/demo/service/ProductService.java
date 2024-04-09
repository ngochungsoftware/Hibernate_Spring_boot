package com.apiTrain.demo.service;

import com.apiTrain.demo.dto.ProductDTO;
import com.apiTrain.demo.entity.Brand;
import com.apiTrain.demo.entity.Product;
import com.apiTrain.demo.entity.ProductBrand;
import com.apiTrain.demo.entity.Status;
import com.apiTrain.demo.entity.SubCategory;
import com.apiTrain.demo.respository.BrandRepository;
import com.apiTrain.demo.respository.ProductBrandRepository;
import com.apiTrain.demo.respository.ProductRepository;
import com.apiTrain.demo.respository.SubCategoryRepository;
import com.apiTrain.demo.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    ProductBrandRepository productBrandRepository;

    @Override
    public List<ProductDTO> getAllProdcuts() {
        List<Object[]> results = productRepository.findAllProductDetails();
        List<ProductDTO> listProductDTO = new ArrayList<>();

        for (Object[] result : results) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName((String) result[0]);
            productDTO.setBrandName((String) result[1]);
            productDTO.setSubCategoryName((String) result[2]);
            productDTO.setSellPrice((BigDecimal) result[3]);
            productDTO.setStatusName((String) result[4]);
            listProductDTO.add(productDTO);
        }

        return listProductDTO;
    }


    @Override
    public ProductDTO getProductByProductName(String productName) {
        List<Object[]> resultList = productRepository.findProductByName(productName);
        if (!resultList.isEmpty()) {
            Object[] result = resultList.get(0);
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId((Long) result[0]);
            productDTO.setProductName((String) result[1]);
            productDTO.setBrandName((String) result[2]);
            productDTO.setSubCategoryName((String) result[3]);
            productDTO.setColor((String) result[4]);
            productDTO.setQuantity((Long) result[5]);
            productDTO.setSellPrice((BigDecimal) result[6]);
            productDTO.setOriginPrice((BigDecimal) result[7]);
            productDTO.setStatusName((String) result[8]);
            return productDTO;
        }
        return null;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product add(ProductDTO productDTO, String brandName, SubCategory subcategory) {
//        Product product = new Product();
//        Status status = new Status();
//        status.setStatus_id(2);
//        status.setStatusName("Inactive");
//        product.setStatus(status);
//        product.setProductName(productDTO.getProductName());
//        product.setColor(productDTO.getColor());
//        product.setQuantity(productDTO.getQuantity());
////        product.setSellPrice(BigDecimal.valueOf(productDTO.getSellPrice()));
//        product.setSubCategory(subcategory);
//        product.setDescription("");
//        product = productRepository.save(product);
//        ProductBrand productBrand = new ProductBrand();
////        productBrand.setProduct_id(product.getProduct_id());
////        productBrand.setBrand_id(brandId);
//        productBrand.setProduct_id(product.getProduct_id());
//        productBrand.setBrand_id(2);
//        productBrandRepository.save(productBrand);
//        // null và xử lý Long và Deciamal
////       return productRepository.save(product);
//        return product;

        Product product = new Product();
        Status status = new Status();
        status.setStatus_id(2);
        status.setStatusName("Inactive");
        product.setStatus(status);
        product.setProductName(productDTO.getProductName());
        product.setColor(productDTO.getColor());
        product.setQuantity(productDTO.getQuantity());
        product.setSubCategory(subcategory);
        product.setDescription("");
        product = productRepository.save(product);
        // Tìm brand_id từ brandName
        Brand brand = brandRepository.findBrandByBrandName(brandName);
        if (brand == null) {
            // Xử lý nếu brand không tồn tại
        }
        ProductBrand productBrand = new ProductBrand();
        productBrand.setProduct_id(product.getProduct_id());
        productBrand.setBrand_id(brand.getBrand_id()); // Sử dụng brand thay vì brand_id
        productBrandRepository.save(productBrand);
        return product;
    }

    @Override
    public List<Product> searchProducts(String productName, String brandName, String subCategoryName, PageRequest pageRequest) {
  //      check null
        productName = handleStringNull(productName);
        brandName = handleStringNull(brandName);
        subCategoryName = handleStringNull(subCategoryName);
        return productRepository.searchProductsByNameBrandSubcate(productName, brandName, subCategoryName, pageRequest);
        // tìm sản phẩm
    }

    private String handleStringNull(String input) {
        if (input == null) {
            return "";
        }
        return input;
    }

    @Override
    public Product update(String productName, ProductDTO productDTO, String brandName, SubCategory subcategory) {
        // Tìm sản phẩm cần cập nhật trong cơ sở dữ liệu
//        Product existingProduct = productRepository.findById(productDTO.getProductId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));

//        Product product = productRepository.findProductByProductName(productName);
//        Optional<Product> product = productRepository.findById(productDTO.getProductId());
//        Product product = new Product();
        Status status = new Status();
        status.setStatus_id(2);
        status.setStatusName("Inactive");

//        product.setStatus(status);
//        product.setProductName(productDTO.getProductName());
//        product.setColor(productDTO.getColor());
//        product.setQuantity(productDTO.getQuantity());
//        product.setSubCategory(subcategory);
//        product.setDescription("");
//        product = productRepository.save(product);
//
//        // Tìm brand_id từ brandName
//        Brand brand = brandRepository.findBrandByBrandName(brandName);
//        ProductBrand productBrand = new ProductBrand();
//        productBrand.setProduct_id(product.getProduct_id());
//        productBrand.setBrand_id(brand.getBrand_id()); // Sử dụng brand thay vì brand_id
//        productBrandRepository.save(productBrand);
//
//        // Cập nhật thông tin của sản phẩm
////        existingProduct.setSubCategory(subcategory);
//
//        // Cập nhật thông tin thương hiệu (nếu cần)
////        Brand brand = brandRepository.findBrandByBrandName(brandName);
////        if (brand == null) {
////            throw new RuntimeException("Brand does not exist");
////        }
////        existingProduct.setBrand(brand);
//
//        // Lưu các thay đổi vào cơ sở dữ liệu
        Product product = null;

        Optional<Product> optionalProduct = productRepository.findById(productDTO.getProductId());
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            // Cập nhật thông tin của sản phẩm
            product.setProductName(productDTO.getProductName());
            product.setColor(productDTO.getColor());
            product.setQuantity(productDTO.getQuantity());
            product.setSubCategory(subcategory);
            // Nếu cần, cập nhật thông tin về thương hiệu
            // (Ở đây tạm thời sử dụng brandId được truyền vào)
            // Tìm brand_id từ brandName
            Brand brand = brandRepository.findBrandByBrandName(brandName);
            if (brand == null) {
                // Xử lý nếu brand không tồn tại
            }
            ProductBrand productBrand = new ProductBrand();
            productBrand.setProduct_id(product.getProduct_id());
            productBrand.setBrand_id(brand.getBrand_id()); // Sử dụng brand thay vì brand_id
            productBrandRepository.save(productBrand);
            // Lưu lại sản phẩm đã cập nhật
        }
        // Trường hợp không tìm thấy sản phẩm, product vẫn là null
        return productRepository.save(product);
    }
//    @Override
//    public List<Product> searchProducts(String productName, String brandName, String subCategoryName) {
//        // Kiểm tra các tham số truyền vào và tạo điều kiện tìm kiếm
//        if (productName != null && brandName != null && subCategoryName != null) {
//            // Tìm kiếm theo tên sản phẩm, tên thương hiệu và tên danh mục phụ
//            return productRepository.findByProductNameAndBrandNameAndSubCategoryName(productName, brandName, subCategoryName);
//        } else if (productName != null && brandName != null) {
//            // Tìm kiếm theo tên sản phẩm và tên thương hiệu
//            return productRepository.findByProductNameAndBrandName(productName, brandName);
//        } else if (productName != null && subCategoryName != null) {
//            // Tìm kiếm theo tên sản phẩm và tên danh mục phụ
//            return productRepository.findByProductNameAndSubCategoryName(productName, subCategoryName);
//        } else if (brandName != null && subCategoryName != null) {
//            // Tìm kiếm theo tên thương hiệu và tên danh mục phụ
//            return productRepository.findByBrandNameAndSubCategoryName(brandName, subCategoryName);
//        } else if (productName != null) {
//            // Tìm kiếm theo tên sản phẩm
//            return productRepository.findByProductName(productName);
//        } else if (brandName != null) {
//            // Tìm kiếm theo tên thương hiệu
//            return productRepository.findByBrandName(brandName);
//        } else if (subCategoryName != null) {
//            // Tìm kiếm theo tên danh mục phụ
//            return productRepository.findBySubCategoryName(subCategoryName);
//        } else {
//            // Trường hợp không có tham số truyền vào, trả về tất cả sản phẩm
//            return productRepository.findAll();
//        }
//    }

    @Override
    public List<ProductDTO> searchProducts2(Product product) {
        List<Object[]> results = productRepository.searchProducts(product);
        List<ProductDTO> listProductDTO = new ArrayList<>();
        for (Object[] result : results) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName((String) result[0]);
            productDTO.setBrandName((String) result[1]);
            productDTO.setSubCategoryName((String) result[2]);
            productDTO.setSellPrice((BigDecimal) result[3]);
            productDTO.setStatusName((String) result[4]);
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }

}
