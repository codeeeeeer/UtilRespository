package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/4 20:08
 */
public class MustEmptyIfEmptyRule<I> extends AbstractValidationRule<I> {
    private final IField<I> other;

    public MustEmptyIfEmptyRule(IField<I> field, IField<I> other) {
        super(field);
        this.other = other;
        this.errorMsg = String.format("%s must be empty when %s is empty",
                this.field.getName(), this.other.getName());
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) return true;

        Object otherValue = this.other.getValue(input);
        return ValidationUtil.isNotEmpty(otherValue);
    }
}
