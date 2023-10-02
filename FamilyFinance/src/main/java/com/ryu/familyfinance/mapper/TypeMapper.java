package com.ryu.familyfinance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryu.familyfinance.entity.Education;
import com.ryu.familyfinance.entity.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
}
