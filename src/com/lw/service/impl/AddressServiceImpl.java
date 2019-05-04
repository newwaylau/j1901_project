package com.lw.service.impl;

import com.lw.dao.AddressDao;
import com.lw.dao.impl.AddressDaoImpl;
import com.lw.entity.Address;
import com.lw.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Address> findByAddress(int id, String table) {
        return addressDao.findByAddress(id,table);
    }
}
