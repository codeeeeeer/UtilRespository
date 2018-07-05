package com.test.cases;

import com.lh708.result.ListResultContainer;
import com.test.bean.Order;
import com.test.validator.OrderValidator;
import junit.framework.TestCase;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 18:14
 */
public class OrderValidatorTest extends TestCase {
    public void test(){
        Order order = new Order();
        ListResultContainer resultHolder = new ListResultContainer();
        boolean validate = OrderValidator.validate(order, resultHolder);
        assertFalse(validate);
        System.out.println(resultHolder.getResult());
    }
}
