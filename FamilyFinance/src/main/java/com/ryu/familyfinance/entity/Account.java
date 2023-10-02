package com.ryu.familyfinance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_account")
public class Account {

    @TableId(value = "aid", type = IdType.AUTO)
    private Long aid;

    private Long uid;

    private String accountDes;

    private BigDecimal accountMoney;

    private String remark;

    private Date createTime;

    private Date updateTime;
    @TableLogic
    private Integer deleted;

}
