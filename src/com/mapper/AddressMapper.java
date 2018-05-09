package com.mapper;

import com.dynamicSql.AddressMapperDynamicSql;
import com.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * Created by shuwei.yu.
 * on 2018/5/4.
 */
public interface AddressMapper {

//    调用的mapper.xml中的sql
    void save(Address address);

    Address select(Address address);

    Address  login(@Param("username") String username, @Param("age") String age);

//    采用注解方式：如果接口类中有一个方法出现问题则其他的方法都会出现问题
//    @Insert() 注解sql语句
//    @Options()中的 useGeneratedKeys=true 表示数据库主键自增
//    keyProperty表示将插入数据库生成的主键到id字段
    @Insert("insert into address(name ,age, mm) values(#{name},#{age},#{mm})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    int saveAddress(Address address);

    @Update("update address set name=#{name},age=#{age},mm=#{mm} where id=#{id}")
    int modifyAddress(Address address);

//    @Param("id")标识@Delete()中的#{id}:明确哪个参数  如果没有注解则默认顺序匹配
    @Delete("delete from address where id=#{id}")
    int deleteAddress(@Param("id2") int id, @Param("id") int id2);

//    @Result注解列和属性之间的映射，如果相同可以省略
    @Select("select * from address a where a.id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "mm",property = "mm")
    } )
    Address selectAddress(int id);

//动态sql
//        type为拼接动态sql的类  method为类中的方法
    @SelectProvider(type= AddressMapperDynamicSql.class ,method = "testSelectWithParam")
    Address selectWithParam(Map<String, Object> map);

    @InsertProvider(type= AddressMapperDynamicSql.class ,method = "testSaveWithParam")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveWithParam(Address address);

    @UpdateProvider(type= AddressMapperDynamicSql.class ,method = "testUpdateWithParam")
    int updateWithParam(Address address);

    @DeleteProvider(type= AddressMapperDynamicSql.class ,method = "testdeleteWithParam")
    int deleteWithParam(Map<String, Object> param);

}
