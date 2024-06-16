package com.sgt.mediumoverflow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> fetchBlogs(){
        return jdbcTemplate.queryForList("EXEC medium.sp_fetch_all_blogs");
    }

    public int insertBlog(String title,String description,int authorId,int category,String imageUrl,String tags){
        return jdbcTemplate.update("EXEC medium.sp_insert_blog ?,?,?,?,?,?",title,description,authorId,category,imageUrl,tags);
    }


    public Map<String,Object> fetchSingleBlog(@PathVariable String slug){
        return jdbcTemplate.queryForMap("EXEC medium.sp_fetch_SinglePost ?",slug);
    }

    public int editBlog(String title,String description,int category,String slug,String imageUrl){
        return jdbcTemplate.update("EXEC medium.sp_edit_blog ?,?,?,?,?",slug,title,description,imageUrl,category);
    }

    public List<Map<String,Object>>  fetchCategoryBasedBlog(int id){
        return jdbcTemplate.queryForList("EXEC medium.sp_fetch_all_blogs ?",id);
    }
}
