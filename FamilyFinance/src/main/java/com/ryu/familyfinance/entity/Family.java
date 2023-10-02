package com.ryu.familyfinance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("t_family")
public class Family {

    @TableId(value = "fid", type = IdType.AUTO)
    private Long fid;

    private String familyCode;

    private String familyName;

    private String remark;

    private Date createTime;

    private Date updateTime;
    @TableLogic
    private Integer deleted;

}
