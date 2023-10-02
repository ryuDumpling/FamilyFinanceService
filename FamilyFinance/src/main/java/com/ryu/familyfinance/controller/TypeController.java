package com.ryu.familyfinance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Type;
import com.ryu.familyfinance.service.TypeService;
import com.ryu.familyfinance.tools.Result;
import com.ryu.familyfinance.vo.TypeVo;
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
@RequestMapping("/type")
public class TypeController {
    @Resource
    private TypeService typeService;
    /**
     * 添加方法
     */

    @PostMapping("/add")
    public Result add(@RequestBody Type type){//将type转为json格式
        type.setCreateTime(new Date());
        type.setDeleted(0);
        boolean save = typeService.save(type);
        if(save){
            return Result.ok(save).message("添加成功");
        }
        return Result.fail().message("添加失败");
    }

    /**
     * 修改
     * @param type
     * @return
     */
    @PutMapping ("/update")
    public Result update(@RequestBody Type type){

        type.setUpdateTime(new Date());

        boolean save = typeService.updateById(type);
        if(save){
            return Result.ok(save).message("修改成功");
        }
        return Result.fail().message("修改失败");
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Long id){
        boolean remove = typeService.removeById(id);
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
        List<Type> list = typeService.list(null);
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
                           @RequestBody (required = false) TypeVo typeVo){
        Page page = new Page<>(pageIndex,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //判断页面是否有传值
        if(StringUtils.checkValNotNull(typeVo.getTypeCode())){
            queryWrapper.like("type_code",typeVo.getTypeCode());
        }
        if (StringUtils.checkValNotNull(typeVo.getTypeName())){
            queryWrapper.like("type_name",typeVo.getTypeName());
        }

        IPage<Type> pageList = typeService.page(page,queryWrapper);
        if (pageList == null){
            return Result.fail().message("未查到数据");
        }
        return Result.ok(pageList);
    }
}
