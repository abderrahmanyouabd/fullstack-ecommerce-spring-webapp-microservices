package com.a1st.ecom.product.response;

import java.util.Map;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ErrorResponse(Map<String, String> errors) { }
