package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//backend entry point is -representational state transfer(REST)
//RestController comes from our downloaded dependency Spring web,it make a class as presentation layer - RestController responsible for mapping,json parsing etc.
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
//distinguishing factor between frontend and backend urls is "/api" suffix
//mapping is api because yaha se data aaega,it is a Rest API endpt from where data will come not a view as in django.
//get request also works on chrome
public class BlogResource {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
//    in get request,data should be same whenever an api is fired
    public List<Map<String,Object>> fetchBlogs(){
        return blogService.fetchBlogs();
//        return List.of("Demo1","Demo2");
    }
//    we can run get requests on chrome and we can also use postman for get and post requests.
//    don't put verbs in request such as /fetchblogs

    @PostMapping("/blog")
    public ResponseEntity<String> insertBlog(@RequestBody Map<String,Object> body){
//        System.out.println(body);
//        data extraction is a logic and therefore written in service file
          return blogService.insertBlog(body);
    }

    @GetMapping("/blogs/{slug}")
    public Map<String,Object> fetchSingleBlog(@PathVariable String slug){
        return blogService.fetchSingleBlog(slug);
    }

    @PutMapping("/blog/{slug}")
    public ResponseEntity<String> editBlog(@PathVariable String slug,@RequestBody Map<String,Object> body){
         return blogService.editBlog(slug,body);
    }

    @GetMapping("blogs/category/{id}")
    public List<Map<String,Object>> fetchCategoryBasedBlog(@PathVariable int id){
        return blogService.fetchCategoryBasedBlog(id);
    }


}
