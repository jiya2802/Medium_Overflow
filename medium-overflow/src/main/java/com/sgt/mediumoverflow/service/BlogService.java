package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;
    public List<Map<String,Object>> fetchBlogs(){
        return blogRepository.fetchBlogs();
    }

    public ResponseEntity<String> insertBlog(Map<String,Object> body){
        int authorId=(int)  body.get("authorId");
        String title=(String) body.get("title");
        String imageUrl=(String) body.get("imageUrl");
        String description=(String) body.get("description");
        int category=(int) body.get("category");
        String tags=(String) body.get("tags");
//        System.out.println(authorId+" "+title+" "+description+" "+imageUrl+" "+category);
        int noOfRows=blogRepository.insertBlog(title,description,authorId,category,imageUrl,tags);
        if(noOfRows>0){
            return ResponseEntity.ok("successfully inserted");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Insertion failed");
    }

    public Map<String,Object> fetchSingleBlog(@PathVariable String slug){
        return blogRepository.fetchSingleBlog(slug);
    }

    public ResponseEntity<String> editBlog(String slug,@RequestBody Map<String,Object> body){
//        int authorId=(int)  body.get("authorId");
        String title=(String) body.get("title");
        String description=(String) body.get("description");
        int category=(int) body.get("category");
        String imageUrl=(String) body.get("imageUrl");
        int noOfRows=blogRepository.editBlog(title,description,category,slug,imageUrl);
        if(noOfRows>0){
            return ResponseEntity.ok("Updated inserted");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Updation failed");
    }

    public List<Map<String,Object>>  fetchCategoryBasedBlog(int id){
        return blogRepository.fetchCategoryBasedBlog(id);
    }
}
