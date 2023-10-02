package com.ryu.familyfinance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryu.familyfinance.entity.Account;
import com.ryu.familyfinance.entity.TypeAccount;
import com.ryu.familyfinance.mapper.AccountMapper;
import com.ryu.familyfinance.mapper.TypeAccountMapper;
import com.ryu.familyfinance.service.AccountService;
import com.ryu.familyfinance.service.TypeAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:57
 */
@Service
@Transactional
public class TypeAccountServiceImpl extends ServiceImpl<TypeAccountMapper, TypeAccount> implements TypeAccountService {

}
