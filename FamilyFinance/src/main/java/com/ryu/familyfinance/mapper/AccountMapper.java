package com.ryu.familyfinance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryu.familyfinance.entity.Account;
import com.ryu.familyfinance.entity.Family;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
