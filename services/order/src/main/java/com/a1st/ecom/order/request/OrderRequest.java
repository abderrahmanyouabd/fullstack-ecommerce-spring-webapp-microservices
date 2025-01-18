package com.a1st.ecom.order.request;

import com.a1st.ecom.order.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record OrderRequest
        (
                Long id,
                String reference,
                @Positive(message = "Amount should be greater than 0")
                BigDecimal amount,
                @NotNull(message = "Payment method should not be null")
                PaymentMethod paymentMethod,
                @NotNull(message = "User id should not be null")
                @NotEmpty(message = "User id should not be empty")
                @NotBlank(message = "User id should not be blank")
                String userId,
                @NotNull(message = "Desired products should not be null")
                @NotEmpty(message = "Desired products should not be empty")
                List<PurchaseRequest> desiredProducts
        ) {
}
