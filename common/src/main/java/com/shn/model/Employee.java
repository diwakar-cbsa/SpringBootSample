package com.shn.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String name;
    private List<Address> addresses;
}
