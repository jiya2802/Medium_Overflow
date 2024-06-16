package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Map<String,Object>> fetchProducts(){
        return productRepository.fetchProducts();
    }

    public List<Map<String,Object>> fetchProductByCategory(int category_id){
        return productRepository.fetchProductByCategory(category_id);
    }
}
