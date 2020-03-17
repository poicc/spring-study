package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDAO;
import com.soft1851.spring.ioc.entity.Forum;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CRQ
 */
@Repository
public class PostDAOImpl implements PostDAO {
@Autowired
private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?)";
        Object[] args = {post.getName()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        return new int[0];
    }

    @Override
    public int delete(int postId) {
        return 0;
    }

    @Override
    public int update(Post post) {
        return 0;
    }

    @Override
    public Forum get(int postId) {
        return null;
    }

    @Override
    public List<Forum> selectAll() {
        return null;
    }
}
