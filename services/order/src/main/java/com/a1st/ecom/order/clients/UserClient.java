package com.a1st.ecom.order.clients;

import com.a1st.ecom.order.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {
    @GetMapping("/{user-id}")
    Optional<UserResponse> findUserById(@PathVariable("user-id") String userId);
}
