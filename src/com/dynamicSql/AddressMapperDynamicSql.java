package com.dynamicSql;

import com.entity.Address;
import org.apache.ibatis.jdbc.SQL;
import org.omg.CORBA.Object;

import java.util.Map;

/**
 * 接口动态sql的拼接类
 * Created by shuwei.yu.
 * on 2018/5/5.
 */
public class AddressMapperDynamicSql {
    public String testSelectWithParam(Map<String ,Object> param){
        return new SQL(){
            {
//              注意：  SELECT()\FROM()\WHERE()等方法区分大小写  必须使用大写
                SELECT ("*");
                FROM ("address");
                if (param.get("id")!=null){
                    WHERE("id=#{id}");

                }else{
                    WHERE("id=9");
                }

            }

        }.toString();
    }
    public String testSaveWithParam(Address address){
        return new SQL(){
            {
                INSERT_INTO("address");
                if (address.getName()!=null){
                    VALUES("name","#{name}");
                }
                if(address.getAge()!=null){
                    VALUES("age","#{age}");
                }
                if(address.getMm()!=null){
                    VALUES("mm","#{mm}");
                }

            }
        }.toString();


    }

    public String testUpdateWithParam(Address address){
        return new SQL(){
            {
                UPDATE("address");
                if (address.getName()!=null){
                    SET("name=#{name}");
                }
                if(address.getAge()!=null){
                    SET("age=#{age}");
                }
                if(address.getMm()!=null){
                    SET("mm=#{mm}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String testdeleteWithParam(Map<String, Object> param){
        return new SQL(){
            {
                DELETE_FROM("Address");
                if (param.get("id")!=null) {
                    WHERE("id=#{id}");
                }
                if (param.get("name")!=null) {
                    WHERE("name=#{name}");
                }
                if (param.get("age")!=null) {
                    WHERE("age=#{age}");
                }

            }
        }.toString();
    }
}



