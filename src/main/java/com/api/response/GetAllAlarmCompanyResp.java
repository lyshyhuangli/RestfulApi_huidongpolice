package com.api.response;

import com.api.common.CommonResult;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

public class GetAllAlarmCompanyResp extends CommonResult
{
    private List<String> infoList = new LinkedList<String>();

    public List<String> getInfoList()
    {
        return infoList;
    }

    public void setInfoList(List<String> infoList)
    {
        this.infoList = infoList;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }

}
