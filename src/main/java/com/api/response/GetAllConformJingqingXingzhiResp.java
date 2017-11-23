package com.api.response;

import com.api.common.CommonResult;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

public class GetAllConformJingqingXingzhiResp extends CommonResult
{
    private List<String> infoLit = new LinkedList<String>();

    public List<String> getInfoLit()
    {
        return infoLit;
    }

    public void setInfoLit(List<String> infoLit)
    {
        this.infoLit = infoLit;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
