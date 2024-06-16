package com.sgt.mediumoverflow.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> fetchComments(int post_id){
        return jdbcTemplate.queryForList("EXEC medium.sp_fetch_all_comments ?",post_id);
    }

    public int insertCommentToPost(int user_id,int post_id,String comment){
        return jdbcTemplate.update("EXEC medium.sp_insert_commentToPost ?,?,?",user_id,post_id,comment);
    }

    public int deleteComment(int comment_id,int user_id){
        return jdbcTemplate.update("EXEC medium.sp_delete_commentFromPost ?,?",comment_id,user_id);
    }
}
