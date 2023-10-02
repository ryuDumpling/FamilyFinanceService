package com.ryu.familyfinance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryu.familyfinance.entity.Education;
import com.ryu.familyfinance.entity.Type;
import com.ryu.familyfinance.mapper.EducationMapper;
import com.ryu.familyfinance.mapper.TypeMapper;
import com.ryu.familyfinance.service.EducationService;
import com.ryu.familyfinance.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:57
 */
@Service
@Transactional
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}
