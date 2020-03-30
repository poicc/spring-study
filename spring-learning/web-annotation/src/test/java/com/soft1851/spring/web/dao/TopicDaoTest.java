package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")//WebAppConfiguration转移
public class TopicDaoTest {

@Autowired
private TopicDao topicDao;
    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }

    @Test
    public void batchInsert(List<Topic> topics){
    }
}