package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Map<String,Object>> fetchCategories(){
        return categoryRepository.fetchCategories();
    }
}
