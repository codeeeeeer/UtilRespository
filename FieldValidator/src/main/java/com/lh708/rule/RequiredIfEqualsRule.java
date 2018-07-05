package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/3 19:53
 */
public class RequiredIfEqualsRule<I> extends AbstractValidationRule<I>{
    private final IField<I> other;
    private final Object expected;

    public RequiredIfEqualsRule(IField<I> field, IField<I> other, Object expected) {
        super(field);
        this.other = other;
        this.expected = expected;
        this.errorMsg = String.format("%s must not be empty if %s is %s",
                this.field.getName(), this.other.getName(), this.expected.toString());
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isNotEmpty(value)){
            return true;
        }

        return ValidationUtil.notEquals(this.other.getValue(input), this.expected);
    }
}
