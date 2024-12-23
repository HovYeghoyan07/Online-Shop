package am.itspace.onlineshop.controller;

import am.itspace.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id){
        productService.deleteProduct(id);
        return "redirect:/admin/adminProduct";
    }
}
