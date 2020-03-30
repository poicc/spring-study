package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.ForumDAO;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CRQ
 */

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDAO forumDAO;


    @Override
    public List<Forum> selectAll() {
        return forumDAO.selectAll();
    }

    @Override
    public Forum get(int forumId) {
        return forumDAO.get(13);
    }
}
