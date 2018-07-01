package com.lh708.rule;

import com.lh708.result.ValidationResultHolder;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:01
 */
public interface IValidationRule<I, O extends ValidationResultHolder> {
    boolean validate(I input, O output);
    String getErrorMsg();
}
