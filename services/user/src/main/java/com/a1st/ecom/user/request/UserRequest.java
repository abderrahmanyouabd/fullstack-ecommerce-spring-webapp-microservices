package com.a1st.ecom.user.request;

import com.a1st.ecom.user.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record UserRequest
        (
                String id,
                @NotNull(message = "First name is required")
                String firstName,
                @NotNull(message = "Last name is required")
                String lastName,
                @NotNull(message = "Email is required")
                @Email(message = "Email is invalid")
                String email,
                Address address
        ) {
}
