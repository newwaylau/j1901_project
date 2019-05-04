package com.lw.service;

import com.lw.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findByAddress(int id, String table);

    Address getAddressByPhone(String phone, String table);
}
