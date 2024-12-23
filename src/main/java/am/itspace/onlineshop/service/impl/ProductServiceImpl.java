package am.itspace.onlineshop.service.impl;

import am.itspace.onlineshop.entity.Product;
import am.itspace.onlineshop.entity.User;
import am.itspace.onlineshop.entity.UserType;
import am.itspace.onlineshop.repository.ProductRepository;
import am.itspace.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Value("${online.shop.upload.path}")
    private String uploadPath;
    @Override
    public List<Product> findProductByCategory(String categoryName) {
        return productRepository.findProductByCategoryName(categoryName);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int id) {
productRepository.deleteById(id);
    }

    @SneakyThrows
    @Override
    public Product save(Product product, MultipartFile multipartFile) {
        String fileName;
        if (!multipartFile.isEmpty()) {
            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(uploadPath, fileName);
            multipartFile.transferTo(file);
            product.setPictureName(fileName);
        }
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

}
