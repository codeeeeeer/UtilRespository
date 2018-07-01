package com.test.bean;

import lombok.Data;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:27
 */
@Data
public class Order {
    private Long itemId;
    private String itemName;
    private Integer count;
    private String type;
}
