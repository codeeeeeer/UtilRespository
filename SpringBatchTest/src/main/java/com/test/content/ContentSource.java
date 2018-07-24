package com.test.content;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/24 21:25
 */
@Data
@Accessors(chain = true)
public class ContentSource {
    private int id;
    private String status;
}
