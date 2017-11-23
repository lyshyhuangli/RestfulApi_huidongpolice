package com.api.restfulApi;

import com.api.common.ResultCode;
import com.api.common.StaticNumber;
import com.api.entity.StaticFilesRecord;
import com.api.request.CheckDbConnectReq;
import com.api.request.GetStaticFilsInfoByCountReq;
import com.api.response.CheckDbConnectResp;
import com.api.response.GetStaticFilsInfoByCountResp;
import com.api.service.StaticFilesService;
import com.api.service.UserService;
import com.api.utils.PropertyUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restfulApi", produces = "application/json;charset=UTF-8")
@ResponseBody
public class StaticFilesController
{
    private static Log logger = LogFactory.getLog(StaticFilesController.class);

    @Autowired
    private StaticFilesService staticFilesService;


    @RequestMapping(value = "/getStaticFilsInfoByCount", method = {RequestMethod.POST})
    public GetStaticFilsInfoByCountResp getStaticFilsInfoByCount(@RequestBody GetStaticFilsInfoByCountReq req)
    {
        GetStaticFilsInfoByCountResp resp = new GetStaticFilsInfoByCountResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<StaticFilesRecord> result = staticFilesService.getStaticFilsInfoByCount(req.getCount() * StaticNumber.THIRTY_FIVE.getCode(),
                req.getFileType(), req.getFileName());
        //logger.info("result:" + result.toString());
        resp.setFileList(result);
        return resp;

    }
}
