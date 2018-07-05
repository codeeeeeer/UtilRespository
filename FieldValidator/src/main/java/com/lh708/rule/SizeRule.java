package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:39
 */
public class SizeRule<I> extends AbstractValidationRule<I> {
    private final Integer min, max;
    public SizeRule(IField<I> field, Integer min, Integer max){
        super(field);
        this.min = min;
        this.max = max;
        if (min != null && max != null){
            this.errorMsg = String.format("the size/length of %s must between %s and %s",
                    this.field.getName(), this.min.toString(), this.max.toString());
        }else if (min != null){
            this.errorMsg = String.format("the size/length of %s must greater than or equal to %s",
                    this.field.getName(), this.min.toString());
        }else if (max != null){
            this.errorMsg = String.format("the size/length of %s must smaller than or equal to %s",
                    this.field.getName(), this.max.toString());
        }
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) {
            return true;
        }

        int size = 0;
        if (value instanceof String) {
            size = ((String) value).length();
        } else if (value instanceof List){
            size = ((List) value).size();
        }
        return ValidationUtil.between(size, min, max);
    }
}
