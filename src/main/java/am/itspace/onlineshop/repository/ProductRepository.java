package am.itspace.onlineshop.repository;

import am.itspace.onlineshop.entity.Category;
import am.itspace.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductByCategoryName(String categoryName);

}

