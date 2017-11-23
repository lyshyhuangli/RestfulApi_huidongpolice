package com.api.request;

import com.api.common.CommonRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SendLogsToServerReq extends CommonRequest
{
    private String logMessages;

    public String getLogMessages()
    {
        return logMessages;
    }

    public void setLogMessages(String logMessages)
    {
        this.logMessages = logMessages;
    }

    public String toString()
    {
        String str = ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        return str;
    }
}
