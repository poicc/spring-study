package com.soft1851.spring.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CRQ
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatterDto {
    private String teacherName;
    private String clazzName;
    private String studentName;
    //private Student student;
}
