package com.ryu.familyfinance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryu.familyfinance.entity.Education;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.mapper.EducationMapper;
import com.ryu.familyfinance.mapper.FamilyMapper;
import com.ryu.familyfinance.service.EducationService;
import com.ryu.familyfinance.service.FamilyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:57
 */
@Service
@Transactional
public class EducationServiceImpl extends ServiceImpl<EducationMapper, Education> implements EducationService{
}
