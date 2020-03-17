package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CRQ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private Double price;

}
