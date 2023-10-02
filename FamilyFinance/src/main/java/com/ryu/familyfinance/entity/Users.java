package com.ryu.familyfinance.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_users")
public class Users {
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private String occupation;
    private Long eid;
    private String description;
    private Long fid;
    private String remark;
    private Date createTime;
    private Date updateTime;
    @TableLogic
    private Integer deleted;
    private Integer isAccount;
    @TableField(exist = false)
    private Family family;
    @TableField(exist = false)
    private Education education;
}
