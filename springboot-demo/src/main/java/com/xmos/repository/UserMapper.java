package com.xmos.repository;

import com.xmos.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where name = #{name} and password = #{password}")
    User findByNameAndPassword(User user);

    @Select("select * from user where name = #{name}")
    User findByName(User user);

    @Insert("insert into user values(#{name},#{password},#{age},#{dept},#{level})")
    int addUser(User user);

    @Select("<script>" +
            "select * from user" +
            "<where>" +
            "<if test = \"dept != null and dept !='' \">" +
            "dept = #{dept}" +
            "</if>" +
            "<if test = \"name != null and name !=''\">" +
            "and name = #{name}" +
            "</if>" +
            "</where>" +
            "</script>")
    List<User> findUser(User user);

    @Update("update user set name=#{name},password=#{password},age=#{age},dept=#{dept},level=#{level} where name=#{name}")
    int updateUser(User user);

    @Delete("delete from user where name=#{name}")
    int deleteUser(User user);
}