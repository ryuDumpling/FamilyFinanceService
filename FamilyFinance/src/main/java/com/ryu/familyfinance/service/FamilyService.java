package com.ryu.familyfinance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.mapper.FamilyMapper;

public interface FamilyService extends IService<Family> {
    public Family selectById(Long fid);
}
