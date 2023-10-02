package com.ryu.familyfinance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryu.familyfinance.entity.Family;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper extends BaseMapper<Family> {
    public Family selectById(Long fid);
}
