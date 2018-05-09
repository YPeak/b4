package com.service.imp;

import com.entity.Address;
import com.mapper.AddressMapper;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shuwei.yu.
 * on 2018/5/9.
 */
@Service("addressService")
public class AddressServiceImp implements AddressService {


    @Autowired
    private AddressMapper addressMapper;


    @Override
    public Address login(String name, String age) {
        return addressMapper.login(name,age);
    }
}
