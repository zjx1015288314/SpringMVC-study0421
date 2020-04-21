package com.itzjx.exception;

/**
 *
 */
public class SystemException extends Exception{
    //存储提示信息
    private String msg;

    public SystemException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
