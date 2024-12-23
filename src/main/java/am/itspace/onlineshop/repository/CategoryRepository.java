package am.itspace.onlineshop.repository;

import am.itspace.onlineshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
