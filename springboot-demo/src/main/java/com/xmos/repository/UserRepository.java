package com.xmos.repository;

import com.xmos.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
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
}
