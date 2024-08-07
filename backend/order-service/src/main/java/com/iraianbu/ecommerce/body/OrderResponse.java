package com.iraianbu.ecommerce.body;

import com.iraianbu.ecommerce.model.PaymentMethod;

import java.io.Serializable;
import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) implements Serializable {
}
