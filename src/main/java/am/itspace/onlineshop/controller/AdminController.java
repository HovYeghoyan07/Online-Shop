package am.itspace.onlineshop.controller;

import am.itspace.onlineshop.entity.Category;
import am.itspace.onlineshop.entity.Product;
import am.itspace.onlineshop.service.CategoryService;
import am.itspace.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public String adminPage(){
        return "/admin/adminHome";
    }

    @GetMapping("/createCategory")
    public String getAddCategory(ModelMap modelMap){
        modelMap.put("categories",categoryService.findAll());
        return "/admin/adminCategory";
    }

    @PostMapping("/createCategory")
    public String AddCategory(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/admin/createCategory";
    }

    @GetMapping("/product")
    public String getAdminProductPage(ModelMap modelMap){
        modelMap.put("products",productService.findAll());
        modelMap.put("categories",categoryService.findAll());
        return "/admin/adminProduct";
    }

    @PostMapping("/admin/createProduct")
    public String addProduct(@ModelAttribute Product product, @RequestParam("image")MultipartFile multipartFile){
        productService.save(product,multipartFile);
        return "redirect:/admin/adminProduct";
    }



}
