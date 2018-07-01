package com.test.validator;

import com.lh708.result.ValidationResultHolder;
import com.test.bean.Order;
import com.test.helper.OrderValidationHelper;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:51
 */
public class OrderValidator {
    static {
        OrderValidationHelper.OrderField.ItemName.validator.required();
    }

    public static boolean validate(Order order, ValidationResultHolder resultHolder){
        boolean flag = true;
        for (OrderValidationHelper.OrderField field:
        OrderValidationHelper.OrderField.values()) {
            if ( ! field.validate(order, resultHolder)){
                flag = false;
            }
        }
        return flag;
    }
}
