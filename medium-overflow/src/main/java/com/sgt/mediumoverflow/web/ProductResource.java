package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Map<String,Object>> fetchProducts(){
        return productService.fetchProducts();
    }

    @GetMapping("/product/{category_id}")
    public List<Map<String,Object>> fetchProductByCategory(@PathVariable int category_id){
        return productService.fetchProductByCategory(category_id);
    }

}
