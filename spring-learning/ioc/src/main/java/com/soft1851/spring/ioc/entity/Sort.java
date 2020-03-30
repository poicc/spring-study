package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @author CRQ
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sort {
    int[] arr = {3,7,0,56,11,79,41,22};

    @Override
    public String toString() {
        return "Sort{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
