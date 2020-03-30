package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @author CRQ
 */
public interface RankService {
    /**
     * 批量插入
     * @param ranks
     * @return
     */
    int[] batchInsert(List<Rank> ranks);
}
