package com.api.response;

import com.api.common.CommonResult;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CheckUserByUserAndPwdResp extends CommonResult
{
    private boolean isExist;

    public boolean getIsExist()
    {
        return isExist;
    }

    public void setIsExist(boolean exist)
    {
        isExist = exist;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
