package com.sgt.mediumoverflow.service;

import com.sgt.mediumoverflow.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    public List<Map<String,Object>>  fetchComments(int post_id){
        return commentRepository.fetchComments(post_id);
    }

    public ResponseEntity<String> insertCommentToPost(Map<String,Object> body){
        int user_id=(int) body.get("user_id");//1
        int post_id=(int) body.get("post_id");//1
        String comment=(String) body.get("comment");//wow
        int noOfRows=commentRepository.insertCommentToPost(user_id,post_id,comment);
        if(noOfRows>0){
            return ResponseEntity.ok("comment successfully inserted");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Comment Insertion failed");
    }

    public ResponseEntity<String> deleteComment(Map<String,Object> body){
        int comment_id=(int) body.get("comment_id");
        int user_id=(int) body.get("user_id");
        int noOfRows=commentRepository.deleteComment(comment_id,user_id);
        if(noOfRows>0){
            return ResponseEntity.ok("comment deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("comment deletion failed");
    }
}

