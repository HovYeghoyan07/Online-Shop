package am.itspace.onlineshop.service;

import am.itspace.onlineshop.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    void deleteCategory(int id);
}
