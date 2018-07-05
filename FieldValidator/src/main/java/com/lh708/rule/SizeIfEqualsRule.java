package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/4 20:01
 */
public class SizeIfEqualsRule<I> extends AbstractValidationRule<I> {
    private final Integer min, max;
    private final IField<I> other;
    private final Object expected;

    public SizeIfEqualsRule(IField<I> field, Integer min, Integer max,
                            IField<I> other, Object expected) {
        super(field);
        this.other = other;
        this.expected = expected;
        this.max = max;
        this.min = min;
        if (min != null && max != null){
            this.errorMsg = String.format("the size/length of %s must between %s and %s when %s is %s",
                    this.field.getName(), this.min.toString(), this.max.toString(), this.other.getName(), expected.toString());
        }else if (min != null){
            this.errorMsg = String.format("the size/length of %s must greater than or equal to %s when %s is %s",
                    this.field.getName(), this.min.toString(), this.other.getName(), expected.toString());
        }else if (max != null){
            this.errorMsg = String.format("the size/length of %s must smaller than or equal to %s when %s is %s",
                    this.field.getName(), this.max.toString(), this.other.getName(), expected.toString());
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

        Object otherValue = this.other.getValue(input);
        if (ValidationUtil.notEquals(otherValue, expected)) return true;

        return ValidationUtil.between(size, min, max);
    }
}
