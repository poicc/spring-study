package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CRQ
 */
@Service
@Transactional(rollbackFor = Exception.class)
public interface CourseMapper {
    /**
     * 根据班课id查询班课详情（班课情况，学生列表）
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
