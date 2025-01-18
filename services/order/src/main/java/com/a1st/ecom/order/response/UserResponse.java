package com.a1st.ecom.order.response;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record UserResponse
        (
                String userId,
                String firstName,
                String lastName,
                String email
        ) {
}
