package com.api.common;

public enum ResultCode
{

    COMMON_REQ_NULL(10000),

    COMMON_DB_OPERATE_ERROR(10001),

    COMMON_PARAM_NULL_ERROR(10002),

    COMMON_PARAM_INVALID(10003),

    SUCCESS(0);

    private int code;

    private ResultCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return this.code;
    }

}
