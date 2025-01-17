package com.a1st.ecom.user.response;

import lombok.Data;

import java.util.Map;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ErrorResponse(Map<String, String> errors) { }
