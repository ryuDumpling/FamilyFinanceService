package com.ryu.familyfinance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Users;
import com.ryu.familyfinance.service.UsersService;
import com.ryu.familyfinance.service.UsersService;
import com.ryu.familyfinance.tools.MD5;
import com.ryu.familyfinance.tools.Result;
import com.ryu.familyfinance.vo.UsersVo;
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
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    //自建多表查询mapper测试数据-success
    @GetMapping("/familyEdu/{uid}")
    public Result ListFamilyEdu(@PathVariable Long uid){
        Users users = usersService.ListFamilyEdu(uid);
        if (users == null){
            return Result.fail().message("未查询到数据");
        }
        return Result.ok(users).message("查询成功");
    }

    /**
     * 添加方法
     */

    @PostMapping("/add")
    public Result add(@RequestBody Users users){//将users转为json格式
        String password = MD5.encrypt(users.getPassword());//将明文密码转为加密密码
        users.setPassword(password);
        users.setCreateTime(new Date());
        users.setDeleted(0);
        users.setIsAccount(0);
        boolean save = usersService.save(users);
        if(save){
            return Result.ok(save).message("添加成功");
        }
        return Result.fail().message("添加失败");
    }

    /**
     * 修改
     * @param users
     * @return
     */
    @PutMapping ("/update")
    public Result update(@RequestBody Users users){

        users.setUpdateTime(new Date());

        boolean save = usersService.updateById(users);
        if(save){
            return Result.ok(save).message("修改成功");
        }
        return Result.fail().message("修改失败");
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Long id){
        boolean remove = usersService.removeById(id);
        if(remove){
            return Result.ok(remove).message("删除成功");
        }
        return Result.fail().message("删除失败");
    }

    /**
     * 查询users表单
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Users> list = usersService.list(null);
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
                           @RequestBody (required = false)UsersVo usersVo){
        Page page = new Page<>(pageIndex,pageSize);
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        //判断页面是否有传值
//        if(StringUtils.checkValNotNull(usersVo.getUsername())){
//            queryWrapper.like("username",usersVo.getUsername());
//        }
//        if (StringUtils.checkValNotNull(usersVo.getName())){
//            queryWrapper.like("name",usersVo.getName());
//        }
        IPage<Users> pageList = usersService.userspage(page, usersVo);

        if (pageList == null){
            return Result.fail().message("未查到数据");
        }
        return Result.ok(pageList);
    }
}
