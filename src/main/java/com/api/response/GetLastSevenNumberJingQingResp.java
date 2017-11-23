package com.api.response;

import com.api.common.CommonResult;
import com.api.entity.JingQingInfoRecord;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

public class GetLastSevenNumberJingQingResp extends CommonResult
{
    private List<JingQingInfoRecord> infoList = new LinkedList<JingQingInfoRecord>();

    public List<JingQingInfoRecord> getInfoList()
    {
        return infoList;
    }

    public void setInfoList(List<JingQingInfoRecord> infoList)
    {
        this.infoList = infoList;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
