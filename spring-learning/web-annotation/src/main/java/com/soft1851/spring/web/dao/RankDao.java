package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @author CRQ
 */
public interface RankDao {

    /**
     * 批量插入
     * @param topics
     * @return
     */
    int[] batchInsert(List<Rank> topics);

}
