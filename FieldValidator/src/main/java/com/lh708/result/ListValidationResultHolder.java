package com.lh708.result;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 10:05
 */
public class ListValidationResultHolder extends ValidationResultHolder<List<String>> {
    public ListValidationResultHolder(){
        errorMsgs = new ArrayList<String>();
    }
    @Override
    public void addErrorMsg(String errorMsg) {
        this.errorMsgs.add(errorMsg);
    }

    @Override
    public List<String> getErrorMsgs() {
        return this.errorMsgs;
    }
}
