package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDAO;
import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDAOImplTest {
@Autowired
private PostDAO postDAO;
    @Test
    public void insert() {
        Post post = Post.builder().name("拼团测试贴").build();
        int n = postDAO.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testBatchInsert() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testSelectAll() {
    }
}