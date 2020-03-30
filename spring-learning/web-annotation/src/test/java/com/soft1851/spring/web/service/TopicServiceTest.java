package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.spider.JunJinSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicServiceTest {
    @Autowired
    private TopicService topicService;

    @Test
    public void queryAll() {
    }

    @Test
    public void addTopic() {
        Topic topic = Topic.builder()
                .id("1122")
                .topicName("test")
                .topicIcon("1.png")
                .description("test")
                .msgCount(111)
                .followersCount(111)
                .followed(true)
                .build();
        topicService.addTopic(topic);
    }

    @Test
    public void batchInsert() throws IOException {
        int[] ints = topicService.batchInsert(JunJinSpider.getTopics());
        assertEquals(JunJinSpider.getTopics().size(),ints.length);
    }
}