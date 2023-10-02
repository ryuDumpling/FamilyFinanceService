package com.ryu.familyfinance.tools;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author ryuDumpling
 * @version 2023/9/12 16:16
 * 全局统一返回结果
 */
@Data
@ApiModel(value = "全局同一返回结果")
public class Result<T> {
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){}

    //返回数据
    protected static <T> Result<T> build(T data){
        Result<T> result = new Result<T>();
        if(data != null){
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum){
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }


    public boolean isOk() {
        if(this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue()) {
            return true;
        }
        return false;
    }
}
