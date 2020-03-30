package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.RankDao;
import com.soft1851.spring.web.entity.Rank;
import com.soft1851.spring.web.service.RankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CRQ
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RankServiceImpl implements RankService {
    private RankDao rankDao;

    public RankServiceImpl(RankDao rankDao) {
        this.rankDao = rankDao;
    }


    @Override
    public int[] batchInsert(List<Rank> ranks) {
        return rankDao.batchInsert(ranks);
    }

}
