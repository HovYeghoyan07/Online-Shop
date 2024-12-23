package am.itspace.onlineshop.service;

import am.itspace.onlineshop.entity.Category;
import am.itspace.onlineshop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product>findProductByCategory(String categoryName);
    List<Product>findAll();
    void deleteProduct(int id);
    Product save(Product product, MultipartFile multipartFile);
}
