package com.a1st.ecom.user.response;

import com.a1st.ecom.user.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record UserResponse
        (
                String id,
                String firstName,
                String lastName,
                String email,
                Address address
        ) {
}
