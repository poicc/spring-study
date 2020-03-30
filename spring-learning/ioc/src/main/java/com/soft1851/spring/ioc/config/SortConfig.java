package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CRQ
 */
@Configuration
public class SortConfig {
    @Bean
    public Sort sort() {
        Sort sort = new Sort();
        int[] arr = sort.getArr();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int item = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = item;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
        return sort;
}

}
