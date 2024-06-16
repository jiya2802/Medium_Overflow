package com.sgt.mediumoverflow.web;

import com.sgt.mediumoverflow.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blog")

public class CommentResource {
    @Autowired
    CommentService commentService;

//    api/blog/comments/3
    @GetMapping("/comments/{post_id}")
    public List<Map<String,Object>>  fetchComments(@PathVariable int post_id){
        return commentService.fetchComments(post_id);
    }

    @PostMapping("/comment")
    public ResponseEntity<String> insertCommentToPost(@RequestBody Map<String,Object> body){
        return commentService.insertCommentToPost(body);
    }

    @PutMapping("/comment")
    public ResponseEntity<String> deleteComment(@RequestBody Map<String,Object> body){
        return commentService.deleteComment(body);
    }

}
