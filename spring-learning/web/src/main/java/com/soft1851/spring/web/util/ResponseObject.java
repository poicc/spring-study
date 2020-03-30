package com.soft1851.spring.web.util;

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
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;
}
