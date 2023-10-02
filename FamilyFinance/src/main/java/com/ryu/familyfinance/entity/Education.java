package com.ryu.familyfinance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ryuDumpling
 * @version 2023/9/14 9:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_education")
public class Education {
    //复制的时候记得修改tableId的value
    @TableId(value = "eid", type = IdType.AUTO)
    private Long eid;

    private String educationCode;

    private String educationName;

    private String remark;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer deleted;

}
