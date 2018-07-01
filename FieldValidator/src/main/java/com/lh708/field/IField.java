package com.lh708.field;

import com.lh708.result.ValidationResultHolder;

/**
 * 〈this provides some common methods of field 〉
 *
 * @author LewJay
 * @create 2018/6/30 8:47
 */
public interface IField<I, O extends ValidationResultHolder> {
    /**
     * get the field value from the input
     * @param input value source
     * @return the value
     */
    Object getValue(I input);

    /**
     *  validate the field value
     * @param input
     * @param output
     * @return
     */
    boolean validate(I input, O output);
    String getName();
    IEnum[] getEnums();
}
