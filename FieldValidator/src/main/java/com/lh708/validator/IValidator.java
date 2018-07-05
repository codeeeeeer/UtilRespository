package com.lh708.validator;

import com.lh708.field.IField;
import com.lh708.result.ResultContainer;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 8:53
 */
public interface IValidator<I> {
    IValidator<I> required();
    IValidator<I> checkEnums();
    <V extends Comparable> IValidator<I> range(V min, V max);
    IValidator<I> size(Integer min, Integer max);
    IValidator<I> requiredIfEquals(IField<I> other, Object expected);
    IValidator<I> mustEmptyIfEmpty(IField<I> other);
    IValidator<I> requiredIfEmpty(IField<I> other);
    IValidator<I> sizeIfEquals(Integer min, Integer max, IField<I> other, Object expected);
    IValidator<I> regex(String regex);
    IValidator<I> regexIfEquals(String regex, IField<I> other, Object expected);

    boolean validate(I input, ResultContainer output);
}
