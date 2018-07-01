package com.lh708.result;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:57
 */
public abstract class ValidationResultHolder<T> {
    protected T errorMsgs;

    /**
     * add error messages to the target errorMsgs
     * @param errorMsg
     */
    public abstract void addErrorMsg(String errorMsg);

    /**
     * get the error messages
     * @return the error messages
     */
    public abstract T getErrorMsgs();
}
