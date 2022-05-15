package com.geek.staff.employee.dao;

import com.geek.staff.employee.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    List<User> userInfo();

}
