package com.api.response;

import com.api.common.CommonResult;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CheckDbConnectResp extends CommonResult
{
    private boolean isConnect;

    public boolean getIsConnect()
    {
        return isConnect;
    }

    public void setIsConnect(boolean connect)
    {
        isConnect = connect;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
