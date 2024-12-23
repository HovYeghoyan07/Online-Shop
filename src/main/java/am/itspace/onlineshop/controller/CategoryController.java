package am.itspace.onlineshop.controller;

import am.itspace.onlineshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/createCategory";
    }

}
