package com.ryu.familyfinance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryu.familyfinance.entity.Account;
import com.ryu.familyfinance.entity.Account;
import com.ryu.familyfinance.service.AccountService;
import com.ryu.familyfinance.tools.Result;
import com.ryu.familyfinance.vo.AccountVo;
import com.ryu.familyfinance.vo.AccountVo;
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
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;
    /**
     * 添加方法
     */

    @PostMapping("/add")
    public Result add(@RequestBody Account account){//将account转为json格式
        account.setCreateTime(new Date());
        account.setDeleted(0);
        boolean save = accountService.save(account);
        if(save){
            return Result.ok(save).message("添加成功");
        }
        return Result.fail().message("添加失败");
    }

    /**
     * 修改
     * @param account
     * @return
     */
    @PutMapping ("/update")
    public Result update(@RequestBody Account account){

        account.setUpdateTime(new Date());

        boolean save = accountService.updateById(account);
        if(save){
            return Result.ok(save).message("修改成功");
        }
        return Result.fail().message("修改失败");
    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Long id){
        boolean remove = accountService.removeById(id);
        if(remove){
            return Result.ok(remove).message("删除成功");
        }
        return Result.fail().message("删除失败");
    }

    /**
     * 查询account表单
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Account> list = accountService.list(null);
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
                           @RequestBody (required = false) AccountVo accountVo){
        Page page = new Page<>(pageIndex,pageSize);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        //判断页面是否有传值
        if(StringUtils.checkValNotNull(accountVo.getAccountDes())){
            //注意修改这边的数据库表格栏目名称
            queryWrapper.like("account_des",accountVo.getAccountDes());
        }
        IPage<Account> pageList = accountService.page(page, queryWrapper);
        if (pageList == null){
            return Result.fail().message("未查到数据");
        }
        return Result.ok(pageList);
    }
}
