package com.lh708.rule;

import com.lh708.common.ValidationUtil;
import com.lh708.field.IField;

import java.util.regex.Pattern;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/7/4 21:26
 */
public class RegexIfEqualsRule<I> extends AbstractValidationRule<I> {
    private final IField<I> other;
    private final Object expected;
    private final Pattern pattern;

    public RegexIfEqualsRule(IField<I> field, String regex, IField<I> other, Object expected) {
        super(field);
        this.other = other;
        this.expected = expected;
        this.pattern = Pattern.compile(regex);
        this.errorMsg = String.format("%s is invalid when %s is %s",
                this.field.getName(), this.other.getName(), expected.toString());
    }

    @Override
    public boolean validate(I input) {
        Object value = this.field.getValue(input);
        if (ValidationUtil.isEmpty(value)) return true;

        if (! (value instanceof String)) return false;
        return this.pattern.matcher((String) value).matches()
                || ValidationUtil.notEquals(this.other.getValue(input), expected);
    }
}
