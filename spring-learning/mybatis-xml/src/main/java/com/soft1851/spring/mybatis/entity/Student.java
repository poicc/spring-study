package com.soft1851.spring.mybatis.entity;

import com.soft1851.spring.mybatis.dto.MatterDto;
import com.soft1851.spring.mybatis.vo.MatterVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author CRQ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private String birthday;
    private MatterDto matterDto;
    private MatterVo matterVo;
    private  Clazz clazz;
    private List<Course> courses;
}
