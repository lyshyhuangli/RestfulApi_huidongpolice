package com.api.service;


public interface UserService
{

    /**
     * 用户登录，校验用户是否存在
     *
     * @param userName
     * @param pwd
     * @return
     */
     boolean checkUserByUserAndPwd(String userName, String pwd);


    /**
     * 检查数据库是否连通
     * @return
     */
     boolean checkDbConnect();

    /**
     * 修改用户密码
     * @param userName
     * @param pwd
     * @return
     */
      boolean modifyPwdByUserName(String userName,String pwd);
}
