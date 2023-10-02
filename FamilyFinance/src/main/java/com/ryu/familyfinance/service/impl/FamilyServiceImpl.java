package com.ryu.familyfinance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.mapper.FamilyMapper;
import com.ryu.familyfinance.service.FamilyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:57
 */
@Service
@Transactional
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements FamilyService{
    @Resource
    private FamilyMapper familyMapper;
    @Override
    public Family selectById(Long fid) {
        return familyMapper.selectById(fid);
    }
}
