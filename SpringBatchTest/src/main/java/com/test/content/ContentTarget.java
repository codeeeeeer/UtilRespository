package com.test.content;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 21:52
 */
@Data
@Accessors(chain = true)
public class ContentTarget {
    private Integer id;
    private String status;
}
