package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;
import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;
    @Test
    public void getCourseById() {
        Course course = courseMapper.getCourseById(20001);
        System.out.println(course.getCourseId()+","+course.getCourseName());
        System.out.println("********");
        List<Student> students = course.getStudents();
        students.forEach(student -> {
            System.out.println(student.getStudentId()
            +","+student.getStudentName()
            +","+student.getHometown()
            +","+student.getBirthday());
        });
    }
}