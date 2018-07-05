package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/2 20:54
 */
public class RangeRule<I, V extends Comparable> extends AbstractValidationRule<I> {
    private final V min, max;

    public RangeRule(IField<I> field, V min, V max) {
        super(field);
        this.min = min;
        this.max = max;
        if (min != null && max != null){
            this.errorMsg = String.format("the value of %s must between %s and %s",
                    this.field.getName(), this.min.toString(), this.max.toString());
        }else if (min != null){
            this.errorMsg = String.format("the value of %s must greater than or equal to %s",
                    this.field.getName(), this.min.toString());
        }else if (max != null){
            this.errorMsg = String.format("the value of %s must smaller than or equal to %s",
                    this.field.getName(), this.max.toString());
        }
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(input)){
            return true;
        }

        if (min != null && max != null){
            return this.min.compareTo(value) <= 0 && this.max.compareTo(value) >= 0;
        }else if (min != null){
            return this.min.compareTo(value) <= 0;
        }else if (max != null){
            return this.max.compareTo(value) >= 0;
        }

        return true;
    }
}
