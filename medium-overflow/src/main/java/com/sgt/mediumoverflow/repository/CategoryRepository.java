package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String , Object>> fetchCategories(){
        return jdbcTemplate.queryForList("EXEC medium.sp_fetch_category");
    }

}
