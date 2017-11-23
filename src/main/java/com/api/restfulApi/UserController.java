package com.api.restfulApi;


import com.api.common.ResultCode;
import com.api.request.CheckDbConnectReq;
import com.api.request.CheckUserByUserAndPwdReq;
import com.api.response.CheckDbConnectResp;
import com.api.response.CheckUserByUserAndPwdResp;
import com.api.response.ModifyPwdByUserNameResp;
import com.api.service.UserService;
import com.api.utils.PropertyUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restfulApi", produces = "application/json;charset=UTF-8")
@ResponseBody
public class UserController
{

    private static Log logger = LogFactory.getLog(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkDbConnect", method = {RequestMethod.POST})
    public CheckDbConnectResp checkDbConnect(@RequestBody CheckDbConnectReq req)
    {
        logger.info("checkDbConnect enter.");

        CheckDbConnectResp resp = new CheckDbConnectResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("req is " + req.toString());

        boolean result = userService.checkDbConnect();
        logger.info("result:" + result);
        resp.setIsConnect(result);
        logger.info("checkDbConnect exit.");
        return resp;

    }

    /**
     * 校验用户是否存在
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/checkUserByUserAndPwd", method = {RequestMethod.POST})
    public CheckUserByUserAndPwdResp checkUserByUserAndPwd(@RequestBody CheckUserByUserAndPwdReq req)
    {
        CheckUserByUserAndPwdResp resp = new CheckUserByUserAndPwdResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("usesrName:" + req.getUserName());
        boolean result = userService.checkUserByUserAndPwd(req.getUserName(), req.getPwd());
        logger.info("result:" + result);

        resp.setIsExist(result);
        return resp;
    }


    /**
     * 修改用户密码
     *
     * @return
     */
    @RequestMapping(value = "/modifyPwdByUserName", method = {RequestMethod.POST})
    public ModifyPwdByUserNameResp modifyPwdByUserName(@RequestBody CheckUserByUserAndPwdReq req)
    {
        ModifyPwdByUserNameResp resp = new ModifyPwdByUserNameResp();
        resp.setResultCode(ResultCode.SUCCESS.getCode());
        resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.SUCCESS.getCode())));

        if (null == req)
        {
            resp.setResultCode(ResultCode.COMMON_REQ_NULL.getCode());
            resp.setResultDesc(PropertyUtil.getProperty(String.valueOf(ResultCode.COMMON_REQ_NULL.getCode())));
            return resp;
        }

        logger.info("usesrName:" + req.getUserName());
        boolean result = userService.modifyPwdByUserName(req.getUserName(), req.getPwd());
        logger.info("result:" + result);

        resp.setIsOK(result);
        return resp;
    }

}