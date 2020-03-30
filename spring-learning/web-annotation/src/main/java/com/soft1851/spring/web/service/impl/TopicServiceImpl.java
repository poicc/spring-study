package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CRQ
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {
    private final TopicDao topicDao;

    public TopicServiceImpl(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
        try {
           int a = 1 / 0;
        }catch (Exception e){
            e.printStackTrace();
         //  throw new RuntimeException();
        }
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {

        return topicDao.batchInsert(topics);
    }
}
