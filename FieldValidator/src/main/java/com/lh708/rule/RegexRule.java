package com.lh708.rule;

import com.lh708.common.ValidationUtil;
import com.lh708.field.IField;

import java.util.regex.Pattern;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/4 21:20
 */
public class RegexRule<I> extends AbstractValidationRule<I> {
    private final Pattern pattern;

    public RegexRule(IField<I> field, String regex) {
        super(field);
        this.pattern = Pattern.compile(regex);
        this.errorMsg = String.format("%s is invalid", this.field.getName());
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) return true;
        if (value instanceof String)
            return this.pattern.matcher((String) value).matches();
        return false;
    }
}
