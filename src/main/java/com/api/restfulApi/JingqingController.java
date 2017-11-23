package com.api.restfulApi;

import com.api.common.ResultCode;
import com.api.entity.AnQingRecord;
import com.api.entity.JingQingInfoRecord;
import com.api.request.*;
import com.api.response.*;
import com.api.service.JingqingService;
import com.api.utils.PropertyUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restfulApi", produces = "application/json;charset=UTF-8")
@ResponseBody
public class JingqingController
{
    private static Log logger = LogFactory.getLog(JingqingController.class);

    @Autowired
    private JingqingService jingqingService;

    @RequestMapping(value = "/getLastSevenNumberJingQing", method = {RequestMethod.POST})
    public GetLastSevenNumberJingQingResp getLastSevenNumberJingQing(@RequestBody GetLastSevenNumberJingQingReq req)
    {
        GetLastSevenNumberJingQingResp resp = new GetLastSevenNumberJingQingResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<JingQingInfoRecord> result = jingqingService.getLastSevenNumberJingQing();
        //logger.info("result:" + result.toString());
        resp.setInfoList(result);
        return resp;
    }

    @RequestMapping(value = "/getJingQingInfoById", method = {RequestMethod.POST})
    public GetJingQingInfoByIdResp getJingQingInfoById(@RequestBody GetJingQingInfoByIdReq req)
    {
        GetJingQingInfoByIdResp resp = new GetJingQingInfoByIdResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        JingQingInfoRecord result = jingqingService.getJingQingInfoById(req.getId());
        if (null != result)
        {
            logger.info("result:" + result.toString());
        }

        resp.setInfo(result);
        return resp;
    }

    /**
     * 滑动获取数据
     *
     * @return
     */
    @RequestMapping(value = "/getJingQingMoreInfoByCount", method = {RequestMethod.POST})
    public GetJingQingMoreInfoByCountResp getJingQingMoreInfoByCount(
            @RequestBody GetJingQingMoreInfoByCountReq req
    )
    {
        GetJingQingMoreInfoByCountResp resp = new GetJingQingMoreInfoByCountResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<JingQingInfoRecord> result = jingqingService.getJingQingMoreInfoByCount(req.getCount(), req.getStartTime(), req.getEndTime(), req.getBriefly(), req.getConformJingqingXingzhi(), req.getAlarmCompany(), req.getChooseIdNo(), req.getInformantPhoneChoose());
        //logger.debug("result:" + result.toString());
        resp.setInfList(result);
        return resp;
    }

    /**
     * 获取所有的确认警情性质
     *
     * @return
     */
    @RequestMapping(value = "/getAllConformJingqingXingzhi", method = {RequestMethod.POST})
    public GetAllConformJingqingXingzhiResp getAllConformJingqingXingzhi(@RequestBody GetAllConformJingqingXingzhiReq req)
    {
        GetAllConformJingqingXingzhiResp resp = new GetAllConformJingqingXingzhiResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<String> result = jingqingService.getAllConformJingqingXingzhi();
        logger.info("result:" + result.toString());
        resp.setInfoLit(result);
        return resp;
    }

    /**
     * 获取所有的  派出所
     *
     * @return
     */
    @RequestMapping(value = "/getAllAlarmCompany", method = {RequestMethod.POST})
    public GetAllAlarmCompanyResp getAllAlarmCompany(@RequestBody GetAllAlarmCompanyReq req)
    {
        GetAllAlarmCompanyResp resp = new GetAllAlarmCompanyResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<String> result = jingqingService.getAllAlarmCompany();
        logger.info("result:" + result.toString());
        resp.setInfoList(result);
        return resp;
    }

    /**
     * 一周警情统计
     *
     * @return
     */
    @RequestMapping(value = "/getWeekAlarmStatic", method = {RequestMethod.POST})
    public GetWeekAlarmStaticResp getWeekAlarmStatic(@RequestBody GetWeekAlarmStaticReq req)
    {
        GetWeekAlarmStaticResp resp = new GetWeekAlarmStaticResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        List<List<AnQingRecord>> result = jingqingService.getWeekAlarmStatic();
        logger.info("result:" + result.toString());
        resp.setInfoList(result);
        return resp;
    }
}
