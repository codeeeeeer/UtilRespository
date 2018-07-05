package com.lh708.rule;

import com.lh708.field.IField;
import com.lh708.common.ValidationUtil;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:02
 */
public class RequiredRule<I> extends AbstractValidationRule<I> {
    public RequiredRule(IField<I> field) {
        super(field);
        this.errorMsg = String.format("%s must not be empty", this.field.getName());
    }

    @Override
    public boolean validate(I input) {
        return ValidationUtil.isNotEmpty(this.field.getValue(input));
    }
}
