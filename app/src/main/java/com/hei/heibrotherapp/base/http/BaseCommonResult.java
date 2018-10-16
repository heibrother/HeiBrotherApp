package com.hei.heibrotherapp.base.http;

import com.google.gson.annotations.SerializedName;

/**
 * @ClassName: BaseCommonResult
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/16 16:26
 */

public class BaseCommonResult<T> {
    private int  code;
    @SerializedName("success")
    private boolean succ;
    private String msg;
    private String result;
    @SerializedName("obj")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess(){
        return getSucc();
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean getSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
