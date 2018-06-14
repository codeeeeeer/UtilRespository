package com.test.beans;

import lombok.Data;
import lombok.Setter;

import java.util.Set;

/**
 * 〈master〉
 *
 * @author LewJay
 * @create 2018/6/9 10:06
 */
@Data
public class Master {
    private String name;
    private String age;
    private Set<Teacher> teachers;
}
