package com.api.response;

import com.api.common.CommonResult;
import com.api.entity.AnQingRecord;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.List;

public class GetWeekAlarmStaticResp extends CommonResult
{
    private List<List<AnQingRecord>> infoList = new LinkedList<List<AnQingRecord>>();

    public List<List<AnQingRecord>> getInfoList()
    {
        return infoList;
    }

    public void setInfoList(List<List<AnQingRecord>> infoList)
    {
        this.infoList = infoList;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
