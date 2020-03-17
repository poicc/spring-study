package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDAOTest {
    @Autowired
    private ForumDAO forumDAO;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("疫情论坛").build();
        int n = forumDAO.insert(forum);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        Forum[] forums = {
                Forum.builder().forumName("编程论坛").build(),
                Forum.builder().forumName("英语论坛").build(),
                Forum.builder().forumName("明日方舟论坛").build()
        };
        List<Forum> forumList = Arrays.asList(forums);
        int[] rows = forumDAO.batchInsert(forumList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n = forumDAO.delete(5);
        assertEquals(1,n);
    }

    @Test
    public void update() {
        Forum forum = forumDAO.get(6);
        forum.setForumName("测试论坛修改的新名词");
        int n = forumDAO.update(forum);
        assertEquals(1,n);
    }

    @Test
    public void get() {
        Forum forum = forumDAO.get(7);
        assertNotNull(forum);
    }

    @Test
    public void selectAll() {
        List<Forum> forums = forumDAO.selectAll();
        assertEquals(4,forums.size());
    }
}
