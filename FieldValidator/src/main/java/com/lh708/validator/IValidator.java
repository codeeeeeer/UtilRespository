package com.lh708.validator;

import com.lh708.result.ValidationResultHolder;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 8:53
 */
public interface IValidator<I, O extends ValidationResultHolder> {
    IValidator<I, O> required();
    boolean validate(I input, O output);
}
