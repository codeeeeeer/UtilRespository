package com.test.helper;

import com.lh708.field.IField;
import com.lh708.result.ValidationResultHolder;
import com.lh708.validator.CumulativeValidator;
import com.lh708.validator.IValidator;
import com.test.bean.Order;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:43
 */
public class OrderValidationHelper {
    public static enum  OrderField implements IField<Order, ValidationResultHolder> {
        ItemId{
            public Object getValue(Order input) {
                return input.getItemId();
            }
        },
        ItemName{
            public Object getValue(Order input) {
                return input.getItemName();
            }
        },
        Count{
            public Object getValue(Order input) {
                return input.getCount();
            }
        },
        Type{
            public Object getValue(Order input) {
                return input.getType();
            }
        };
        public final IValidator<Order, ValidationResultHolder> validator
                = new CumulativeValidator<Order, ValidationResultHolder>(this);

        public boolean validate(Order input, ValidationResultHolder output) {
            return validator.validate(input, output);
        }

        public String getName() {
            return name();
        }
    }
}
