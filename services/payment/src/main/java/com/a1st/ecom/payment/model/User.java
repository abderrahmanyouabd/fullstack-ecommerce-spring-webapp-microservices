package com.a1st.ecom.payment.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Validated
public record User
        (
                String id,
                @NotNull(message = "First name is required")
                String firstName,
                @NotNull(message = "Last name is required")
                String lastName,
                @NotNull(message = "Email is required")
                @Email(message = "Email is invalid")
                String email
        ) {
}
