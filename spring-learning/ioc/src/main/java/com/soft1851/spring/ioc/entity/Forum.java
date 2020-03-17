package com.soft1851.spring.ioc.entity;

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
public class Forum {
    private Integer forumId;
    private String forumName;
}
