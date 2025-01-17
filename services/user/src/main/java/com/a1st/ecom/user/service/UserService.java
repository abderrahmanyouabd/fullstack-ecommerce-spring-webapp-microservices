package com.a1st.ecom.user.service;

import com.a1st.ecom.user.request.UserRequest;
import com.a1st.ecom.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

public interface UserService {

    String createUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    Boolean userExistsById(String userId);

    UserResponse findUserById(String userId);

    void deleteUser(String userId);
}
