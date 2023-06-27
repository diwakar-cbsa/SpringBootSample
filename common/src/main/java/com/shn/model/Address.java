package com.shn.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String city;
    private Integer pin;
}
