package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ValidationResultHolder;
import com.lh708.rule.IValidationRule;
import com.lh708.rule.RequiredRule;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 8:56
 */
public class CumulativeValidator<I, O extends ValidationResultHolder> implements IValidator<I, O> {
    private IField<I, O> field;
    private List<IValidationRule<I, O>> rules = null;

    public CumulativeValidator(IField<I, O> field) {
        this.field = field;
        this.rules = new ArrayList<IValidationRule<I, O>>();
    }

    public IValidator<I, O> required() {
        this.rules.add(new RequiredRule<I, O>(this.field));
        return this;
    }

    public boolean validate(I input, O output) {
        boolean flag = true;
        for (IValidationRule<I, O> rule:
                rules) {
            if (rule.validate(input, output)){
                flag = false;
                output.addErrorMsg(rule.getErrorMsg());
            }
        }
        return flag;
    }
}
