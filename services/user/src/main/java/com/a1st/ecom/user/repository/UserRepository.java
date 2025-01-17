package com.a1st.ecom.user.repository;

import com.a1st.ecom.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

public interface UserRepository extends MongoRepository<User, String> {
}
