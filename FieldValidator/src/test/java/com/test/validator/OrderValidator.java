package com.test.validator;

import com.lh708.result.ResultContainer;
import com.test.bean.Order;
import com.test.helper.OrderFieldEnums;
import com.test.helper.OrderValidationHelper;

import java.math.BigDecimal;

import static com.test.helper.OrderValidationHelper.OrderField.*;
import static com.test.helper.OrderValidationHelper.ItemField.*;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:51
 */
public class OrderValidator {
    static {
        OrderId.validator.
                required();
        PaymentAccount.validator
                .required()
                .sizeIfEquals(11, 11, PaymentType, OrderFieldEnums.PaymentTypeEnums.AliPay.getValue())
                .sizeIfEquals(10, 12, PaymentType, OrderFieldEnums.PaymentTypeEnums.WeChat.getValue())
                .sizeIfEquals(16, 20, PaymentType, OrderFieldEnums.PaymentTypeEnums.CreditCard.getValue());
        PaymentType.validator
                .required()
                .checkEnums();
        PaymentTime.validator
                .required();
        PostFee.validator
                .range(null, BigDecimal.valueOf(15));      //邮费不高于15元
        ShippingName.validator
                .requiredIfEmpty(ShippingCode);             //ShippingName和ShippingCode必须至少一个不为空
        CustomerId.validator
                .required()
                .size(6, 15);
        CustomerType.validator
                .required()
                .checkEnums();
        BuyerMessage.validator
                .size(null, 100);             //买家信息不多于100字
        BuyerNick.validator
                .size(6, 15);
        BuyerRate.validator
                .range(Double.valueOf(0.00), Double.valueOf(0.99));
        Details.validator
                .required()
                .sizeIfEquals(1, 5, CustomerType, OrderFieldEnums.CustomerTypeEnums.Common.getValue())
                .sizeIfEquals(1, 20, CustomerType, OrderFieldEnums.CustomerTypeEnums.Member.getValue())
                .sizeIfEquals(1, 100, CustomerType, OrderFieldEnums.CustomerTypeEnums.Cooperator.getValue());

        ItemId.validator
                .required()
                .size(14, 15);
        Num.validator
                .required()
                .range(1, 100);
        Price.validator
                .required()
                .range(BigDecimal.valueOf(0.01), BigDecimal.valueOf(10000.00));
        TotalFee.validator
                .required()
                .range(BigDecimal.valueOf(0.00), BigDecimal.valueOf(100.00));
    }

    public static boolean validate(Order order, ResultContainer resultHolder){
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
