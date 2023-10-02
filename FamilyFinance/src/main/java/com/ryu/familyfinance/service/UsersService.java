package com.ryu.familyfinance.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.entity.Users;
import com.ryu.familyfinance.vo.UsersVo;

public interface UsersService extends IService<Users> {
    Users ListFamilyEdu(Long uid);

    Page<Users> userspage(Page<Users> page, UsersVo usersVo);
}
