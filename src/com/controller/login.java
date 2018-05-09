package com.controller;

import com.entity.Address;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shuwei.yu.
 * on 2018/5/9.
 */
@RequestMapping("login")
@Controller
public class login {

    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;

    @RequestMapping("welcom")
    public String test(){
        return "login";
    }

//    form表单的提交的参数用“@RequestParam”注解接收  且用标签的“name”属性
    @RequestMapping("userLogin")
    public String testLogin(@RequestParam("loginName") String name, @RequestParam("loginPassWord") String age){
        System.out.println(name+"----"+age);
        Address address = addressService.login(name,age);
        if(null!=address){
            return "welcom";
        }else{
            return "error";
        }
    }

}
