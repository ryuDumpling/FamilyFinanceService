package com.ryu.familyfinance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.entity.Users;
import com.ryu.familyfinance.mapper.FamilyMapper;
import com.ryu.familyfinance.mapper.UsersMapper;
import com.ryu.familyfinance.service.FamilyService;
import com.ryu.familyfinance.service.UsersService;
import com.ryu.familyfinance.vo.UsersVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:57
 */
@Service
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Override
    public Users ListFamilyEdu(Long uid){
        return baseMapper.ListFamilyEdu(uid);
    }

    @Override
    public Page<Users> userspage(Page<Users> page, UsersVo usersVo) {
        return baseMapper.userspage(page,usersVo);
    }
}
