package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> fetchProducts(){
        return jdbcTemplate.queryForList("EXEC sp_fetch_all_products");
    }

    public List<Map<String,Object>> fetchProductByCategory(int category_id){
        return jdbcTemplate.queryForList("EXEC sp_fetch_categoryBased_Product ?",category_id);
    }
}
