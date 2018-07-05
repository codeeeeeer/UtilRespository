package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/3 20:01
 */
public class RequiredIfEmptyRule<I> extends AbstractValidationRule<I>{
    private final IField<I> other;

    public RequiredIfEmptyRule(IField<I> field, IField<I> other) {
        super(field);
        this.other = other;
        this.errorMsg = String.format("%s must not be empty if %s is empty",
                this.field.getName(), this.other.getName());
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isNotEmpty(value)){
            return true;
        }
        return ValidationUtil.isNotEmpty(this.other.getValue(input));
    }
}
