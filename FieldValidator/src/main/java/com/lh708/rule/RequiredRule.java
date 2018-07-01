package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.result.ValidationResultHolder;
import com.lh708.util.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:02
 */
public class RequiredRule<I, O extends ValidationResultHolder> implements IValidationRule<I, O> {
    private IField<I, O> field = null;
    private String errorMsg = null;

    public RequiredRule(IField<I, O> field) {
        this.field = field;
        this.errorMsg = String.format("%s must not be empty", field.getName());
    }

    public boolean validate(I input, O output) {
        return ValidationUtil.isEmpty(field.getValue(input));
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
