package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.service.StudentService;

import java.util.List;

/**
 * @author CRQ
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public Student selectById(int id) {
        return null;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public void delete(int studentId) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public int batchInsert(List<Student> students) {
        return 0;
    }

    @Override
    public int batchDelete(List<Integer> idList) {
        return 0;
    }

    @Override
    public List<Student> selectLimit() {
        return null;
    }

    @Override
    public List<Student> selectLimitByDynamicSql(Student student) {
        return null;
    }
}
