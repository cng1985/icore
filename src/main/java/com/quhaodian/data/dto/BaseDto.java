package com.quhaodian.data.dto;

public class BaseDto {
    /**
     * 状态码
     */
    private int code = 0;

    /**
     * 状态信息 默认为 success
     */
    private String msg = "success";

    /**
     * 返回状态码
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 返回状态信息
     *
     * @return 状态信息
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseVo [code=" + code + ", msg=" + msg + "]";
    }

}
