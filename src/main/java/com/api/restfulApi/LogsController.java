package com.api.restfulApi;

import com.api.common.ResultCode;
import com.api.request.SendLogsToServerReq;
import com.api.response.SendLogsToServerResp;
import com.api.utils.PropertyUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restfulApi", produces = "application/json;charset=UTF-8")
@ResponseBody
public class LogsController
{
    private static Log logger = LogFactory.getLog(LogsController.class);

    /**
     * 打印从app上传的日志
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/sendLogsToServer", method = {RequestMethod.POST})
    public SendLogsToServerResp sendLogsToServer(@RequestBody SendLogsToServerReq req)
    {
        SendLogsToServerResp resp = new SendLogsToServerResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("sendLogsToServer enter. ");

        logger.info(req.getLogMessages());

        logger.info("sendLogsToServer exit. ");
        return resp;
    }
}
