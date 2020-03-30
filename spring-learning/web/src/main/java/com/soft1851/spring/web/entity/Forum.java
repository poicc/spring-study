package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CRQ
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Forum implements Serializable {
    private Integer forumId;
    private String forumName;
}
