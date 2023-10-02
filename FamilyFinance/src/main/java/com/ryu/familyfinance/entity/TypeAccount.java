package com.ryu.familyfinance.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户转账表
 * @author ryuDumpling
 * @version 2023/9/12 16:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_type_account")
public class TypeAccount {

    @TableId(value = "ttid", type = IdType.AUTO)
    private Long ttid;

    private Long aid;

    private Long tid;

    private String accountDes;

    private String accountCode;

    private String accountName;

    private String divertName;

    private BigDecimal accrualMoney;

    private BigDecimal balanceMoney;

    private String remark;

    private Date createTime;

    private Date divertTime;

    private Date updateTime;
    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private Type type;

}
