package com.a1st.ecom.user.utils;

import com.a1st.ecom.user.model.User;
import com.a1st.ecom.user.request.UserRequest;
import com.a1st.ecom.user.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
@Slf4j
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        if (userRequest == null) {
            log.warn("UserRequest is null");
            return null;
        }
        return User.builder()
                .id(userRequest.id())
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .address(userRequest.address())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        if (user == null) {
            log.warn("User is null");
            return null;
        }
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
