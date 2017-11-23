package com.api.mapper;


import com.api.entity.UserRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper
{
    /**
     * 获取一条记录，判断数据库是否能连通
     * @return
     */
    UserRecord getOne();

    String selectAgeByName(String name);

    /**
     * 校验登录用户
     *
     * @param userName
     * @param pwd
     * @return
     */
    UserRecord checkUserByUserAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);

    /**
     * 修改用户密码
     *
     * @param userName
     * @param pwd
     * @return
     */
    int modifyPwdByUserName(@Param("userName") String userName, @Param("pwd") String pwd);
}
