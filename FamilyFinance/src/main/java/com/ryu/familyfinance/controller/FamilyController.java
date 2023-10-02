package com.ryu.familyfinance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Family;
import com.ryu.familyfinance.service.FamilyService;
import com.ryu.familyfinance.tools.Result;
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
@RequestMapping("/family")
public class FamilyController {
    @Resource
    private FamilyService familyService;
    /**
     * 添加方法
     */
//    自定义查询
//    @GetMapping("/findFamilyNameByFid/{fid}")
//    public String findFamilyNameByFid(@PathVariable Long fid){
//        Family family = familyService.selectById(fid);
//        if (family == null) return "null";
//        return family.getFamilyName();
//    }

    @PostMapping("/add")
    public Result add(@RequestBody Family family){//将family转为json格式
        family.setCreateTime(new Date());
        family.setDeleted(0);
        boolean save = familyService.save(family);
        if(save){
            return Result.ok(save).message("添加成功");
        }
        return Result.fail().message("添加失败");
    }

    /**
     * 修改
     * @param family
     * @return
     */
    @PutMapping ("/update")
    public Result update(@RequestBody Family family){

        family.setUpdateTime(new Date());

        boolean save = familyService.updateById(family);
        if(save){
            return Result.ok(save).message("修改成功");
        }
        return Result.fail().message("修改失败");
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Long id){
        boolean remove = familyService.removeById(id);
        if(remove){
            return Result.ok(remove).message("删除成功");
        }
        return Result.fail().message("删除失败");
    }

    /**
     * 查询家庭成员表单
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Family> list = familyService.list(null);
        if(list == null){
            return Result.fail().message("未查询到数据");
        }
        return Result.ok(list);

    }

    /**
     * 分页方法
     */
    @PostMapping("/listData/{pageIndex}/{pageSize}")
    public Result listData(@PathVariable Long pageIndex, @PathVariable Long pageSize,
                           @RequestBody (required = false)FamilyVo familyVo){
        Page page = new Page<>(pageIndex,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //判断页面是否有传值
        if(StringUtils.checkValNotNull(familyVo.getFamilyCode())){
            queryWrapper.like("family_code",familyVo.getFamilyCode());
        }
        if (StringUtils.checkValNotNull(familyVo.getFamilyName())){
            queryWrapper.like("family_name",familyVo.getFamilyName());
        }

        IPage<Family> pageList = familyService.page(page, queryWrapper);
        if (pageList == null){
            return Result.fail().message("未查到数据");
        }
        return Result.ok(pageList);
    }
}
