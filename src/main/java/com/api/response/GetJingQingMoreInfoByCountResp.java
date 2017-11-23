package com.api.response;

import com.api.common.CommonResult;
import com.api.entity.JingQingInfoRecord;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

public class GetJingQingMoreInfoByCountResp extends CommonResult
{
    List<JingQingInfoRecord> infList = new LinkedList<JingQingInfoRecord>();

    public List<JingQingInfoRecord> getInfList()
    {
        return infList;
    }

    public void setInfList(List<JingQingInfoRecord> infList)
    {
        this.infList = infList;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }

}
