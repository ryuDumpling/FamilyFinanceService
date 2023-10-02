package com.ryu.familyfinance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Education;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.service.EducationService;
import com.ryu.familyfinance.service.FamilyService;
import com.ryu.familyfinance.tools.Result;
import com.ryu.familyfinance.vo.EducationVo;
import com.ryu.familyfinance.vo.FamilyVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:59
 */
@CrossOrigin//跨域查询注解
@RestController
@RequestMapping("/education")
public class EducationController {
    @Resource
    private EducationService educationService;
    /**
     * 添加方法
     */

    @PostMapping("/add")
    public Result add(@RequestBody Education education){//将education转为json格式
        education.setCreateTime(new Date());
        education.setDeleted(0);
        boolean save = educationService.save(education);
        if(save){
            return Result.ok(save).message("添加成功");
        }
        return Result.fail().message("添加失败");
    }

    /**
     * 修改
     * @param education
     * @return
     */
    @PutMapping ("/update")
    public Result update(@RequestBody Education education){

        education.setUpdateTime(new Date());

        boolean save = educationService.updateById(education);
        if(save){
            return Result.ok(save).message("修改成功");
        }
        return Result.fail().message("修改失败");
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Long id){
        boolean remove = educationService.removeById(id);
        if(remove){
            return Result.ok(remove).message("删除成功");
        }
        return Result.fail().message("删除失败");
    }

    /**
     * 查询教育表单
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Education> list = educationService.list(null);
        if(list == null){
            return Result.fail().message("未查询到数据");
        }
        return Result.ok(list);

    }

    /**
     * 分页方法 /未修改
     */
    @PostMapping("/listData/{pageIndex}/{pageSize}")
    public Result listData(@PathVariable Long pageIndex, @PathVariable Long pageSize,
                           @RequestBody (required = false) EducationVo educationVo){
        Page page = new Page<>(pageIndex,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //判断页面是否有传值
        if(StringUtils.checkValNotNull(educationVo.getEducationCode())){
            queryWrapper.like("education_code",educationVo.getEducationCode());
        }
        if (StringUtils.checkValNotNull(educationVo.getEducationName())){
            queryWrapper.like("education_name",educationVo.getEducationName());
        }

        IPage<Education> pageList = educationService.page(page,queryWrapper);
        if (pageList == null){
            return Result.fail().message("未查到数据");
        }
        return Result.ok(pageList);
    }
}
