package com.shn.util;

import com.shn.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressUtil {

    public static Address getBlrAddress() {
        return Address.builder().city("Bangalore").pin(560076).build();
    }

    public static List<Address> getDiwakarAddresses() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(getBlrAddress());
        addresses.add(Address.builder().city("Chaibasa").pin(833201).build());
        addresses.add(Address.builder().city("Bangalore").pin(560068).build());
        addresses.add(Address.builder().city("Bangalore").pin(560078).build());
        return addresses;
    }

    public static List<Address> getMonuAddresses() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().city("Chaibasa").pin(833201).build());
        addresses.add(Address.builder().city("Tata").pin(833001).build());
        return addresses;
    }
}
