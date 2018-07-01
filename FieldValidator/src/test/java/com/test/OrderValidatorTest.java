package com.test;

import com.lh708.result.ListValidationResultHolder;
import com.test.bean.Order;
import com.test.validator.OrderValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 18:14
 */
public class OrderValidatorTest {
    @Test
    public void test(){
        Order order = new Order();
        ListValidationResultHolder resultHolder = new ListValidationResultHolder();
        boolean validate = OrderValidator.validate(order, resultHolder);
        assertFalse(validate);
        System.out.println(resultHolder.getErrorMsgs());
    }
}
