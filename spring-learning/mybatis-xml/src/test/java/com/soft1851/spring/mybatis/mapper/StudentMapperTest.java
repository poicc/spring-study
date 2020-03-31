package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectById() {
        Student student = studentMapper.selectById(2011);
        System.out.println(student);
    }

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                // .birthday(LocalDate.of(2000,01,01))
                .birthday("2000-01-01")
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(2010);
    }

    @Test
    public void update() {
        Student student = studentMapper.selectById(2011);
        student.setStudentName("新名字");
        student.setHometown("上海");
        // student.setBirthday(LocalDate.of(1999,11,11));
        student.setBirthday("1999-11-11");
        studentMapper.update(student);
        System.out.println(studentMapper.selectById(2011));

    }


    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(4000 + i)
                    .studentName("批量插入测试" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday("1999-01-01")
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        for (int i = 0; i < 10; i++) {
            studentMapper.delete(4000 + i);
        }
    }

    @Test
    public void selectLimit() {
        System.out.println(studentMapper.selectLimit());
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder()
                .clazzId(1)
                .build();
        System.out.println(studentMapper.selectLimitByDynamicSql(student));
    }


    @Test
    public void selectAll() {
        List<Student> students = studentMapper.selectAll();
        students.forEach(student -> {
            System.out.println(student.getStudentId()
            +","+student.getStudentName()
            +","+student.getHometown()
            +","+student.getBirthday()
            +","+student.getClazz().getClazzName());
        });
    }
}