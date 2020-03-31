package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CRQ
 */
public interface StudentService {
    /**
     * 通过Id查询student
     * @param id
     * @return student
     */
    Student selectById(int id);
    /**
     * 新增student,并返回自增主键
     *
     * @param student
     *
     */
    void insert (Student student);

    /**
     * 根据学生id删除student
     *
     * @param studentId
     */
    void delete (int studentId);

    /**
     * 更改student
     *
     * @param student
     */
    void update (Student student);


    /**
     * 批量插入
     * @param students
     * @return
     */
    int batchInsert(@Param("students") List<Student>students);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 单表（带两个指定条件）查询
     * @return
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);
}
