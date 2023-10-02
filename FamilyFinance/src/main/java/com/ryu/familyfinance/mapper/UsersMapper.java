package com.ryu.familyfinance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.entity.Users;
import com.ryu.familyfinance.vo.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Users ListFamilyEdu(Long uid);

    Page<Users> userspage(@Param("usersVo") Page<Users> page, UsersVo usersVo);
}
