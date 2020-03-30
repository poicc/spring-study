package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author CRQ
 */
public interface ForumService {
    /**
     * 查询所有Forum
     * @return List<Forum>
     */
    List<Forum> selectAll();
    /**
     * 根据id查询Forum
     * @param forumId
     * @return
     */
    Forum get(int forumId);
}
