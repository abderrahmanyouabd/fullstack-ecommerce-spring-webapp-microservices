package com.a1st.ecom.user.service.impl;

import com.a1st.ecom.user.exceptions.CustomerNotFoundException;
import com.a1st.ecom.user.model.User;
import com.a1st.ecom.user.repository.UserRepository;
import com.a1st.ecom.user.request.UserRequest;
import com.a1st.ecom.user.response.UserResponse;
import com.a1st.ecom.user.service.UserService;
import com.a1st.ecom.user.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String createUser(UserRequest userRequest) {
        var savedUser = userRepository.save(userMapper.toUser(userRequest));
        return savedUser.getId();
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        var user = userRepository.findById(userRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(String.format("User with id (%s) not found:: UPDATE FAILED", userRequest.id())));
        setNewUserDetails(user, userRequest);
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public Boolean userExistsById(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public UserResponse findUserById(String userId) {
        return userRepository.findById(userId).map(userMapper::toUserResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("User with id (%s) not found", userId)));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


    /**
     * Set new user details for update
     * @param user
     * @param userRequest
     */
    private void setNewUserDetails(User user, UserRequest userRequest) {
        if (StringUtils.isNotBlank(userRequest.firstName())) {
            user.setFirstName(userRequest.firstName());
        }
        if (StringUtils.isNotBlank(userRequest.lastName())) {
            user.setLastName(userRequest.lastName());
        }
        if (StringUtils.isNotBlank(userRequest.email())) {
            user.setEmail(userRequest.email());
        }
        if (userRequest.address() != null) {
            user.setAddress(userRequest.address());
        }

    }
}
