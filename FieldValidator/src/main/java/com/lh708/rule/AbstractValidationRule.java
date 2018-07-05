package com.lh708.rule;

import com.lh708.field.IField;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:01
 */
public abstract class AbstractValidationRule<I> {
    protected final IField<I> field;
    protected String errorMsg;

    public AbstractValidationRule(IField<I> field) {
        this.field = field;
    }

    public abstract boolean validate(I input);

    public String getErrorMsg(){
        return this.errorMsg;
    }
}
