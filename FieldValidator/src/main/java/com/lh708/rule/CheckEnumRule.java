package com.lh708.rule;

import com.lh708.field.IEnum;
import com.lh708.field.IField;
import com.lh708.result.ValidationResultHolder;
import com.lh708.util.ValidationUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:02
 */
public class CheckEnumRule<I, O extends ValidationResultHolder> implements IValidationRule<I, O> {
    private IField<I, O> field = null;
    private String errorMsg = null;

    public CheckEnumRule(IField<I, O> field) {
        this.field = field;
        this.errorMsg = String.format("%s must be one of the values %s", field.getName(), Arrays.asList(this.field.getEnums()));
    }

    public boolean validate(I input, O output) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) {
            return true;
        }
        IEnum[] enums = this.field.getEnums();
        if (enums == null || enums.length == 0) {
            return true;
        }
        for (IEnum enumValue:
                enums) {
            if (ValidationUtil.equals(enumValue.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
