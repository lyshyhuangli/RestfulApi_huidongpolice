package com.api.response;

import com.api.common.CommonResult;
import com.api.entity.StaticFilesRecord;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

public class GetStaticFilsInfoByCountResp extends CommonResult
{
    List<StaticFilesRecord> fileList;

    public List<StaticFilesRecord> getFileList()
    {
        return fileList;
    }

    public void setFileList(List<StaticFilesRecord> fileList)
    {
        this.fileList = fileList;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
