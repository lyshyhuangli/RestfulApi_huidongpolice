package com.api.response;

import com.api.common.CommonResult;
import com.api.entity.JingQingInfoRecord;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetJingQingInfoByIdResp extends CommonResult
{
    private JingQingInfoRecord info;

    public JingQingInfoRecord getInfo()
    {
        return info;
    }

    public void setInfo(JingQingInfoRecord info)
    {
        this.info = info;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
