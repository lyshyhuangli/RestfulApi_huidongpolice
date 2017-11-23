package com.api.service.impl;

import com.api.entity.UserRecord;
import com.api.mapper.UserMapper;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录，校验用户是否存在
     *
     * @param userName
     * @param pwd
     * @return
     */
    public boolean checkUserByUserAndPwd(String userName, String pwd)
    {
        UserRecord u = userMapper.checkUserByUserAndPwd(userName, pwd);
        if (null != u)
        {
            return true;
        }

        return false;
    }

    /**
     * 检查数据库是否连通
     *
     * @return
     */
    public boolean checkDbConnect()
    {
        UserRecord u = userMapper.getOne();
        if (null != u)
        {
            return true;
        }

        return false;
    }

    /**
     * 修改用户密码
     *
     * @param userName
     * @param pwd
     * @return
     */
    public boolean modifyPwdByUserName(String userName, String pwd)
    {
        int result = userMapper.modifyPwdByUserName(userName, pwd);

        if (result != 0)
        {
            return true;
        }

        return false;

    }
}
