package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CRQ
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
      private Integer id;
      private String name;
      private String cover;
}
