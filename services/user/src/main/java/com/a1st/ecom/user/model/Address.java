package com.a1st.ecom.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class Address {
    private String street;
    private String street2;
    private String houseNumber;
    private String city;
    private String zip;
    private String country;

}
