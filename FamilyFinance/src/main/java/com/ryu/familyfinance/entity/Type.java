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
@TableName("t_type")
public class Type {
    //复制的时候记得修改tableId的value
    @TableId(value = "tid", type = IdType.AUTO)
    private Long tid;

    private String typeCode;

    private String typeName;

    private String remark;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer deleted;

}
