package com.api.mapper;

import com.api.entity.AnQingRecord;
import com.api.entity.JingQingInfoRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JingqingMapper
{
    List<JingQingInfoRecord> getLastFiveNumberJingQing();

    JingQingInfoRecord getJingQingInfoById(@Param("id") String id);

    /**
     * 滑动获取数据
     *
     * @param count
     * @return
     */
    List<JingQingInfoRecord> getJingQingMoreInfoByCount(
            @Param("count")  int count,  @Param("startTime")  String startTime,
            @Param("endTime")  String endTime, @Param("brieflyss") List<String> brieflyss,
            @Param("conformJingqingXingzhis") List<String> conformJingqingXingzhis, @Param("alarmCompanys") List<String> alarmCompanys,
            @Param("chooseIdNo") String chooseIdNo, @Param("informantPhoneChoose") String informantPhoneChoose
    );

    /**
     * 获取所有的确认警情性质
     *
     * @return
     */
    List<String> getAllConformJingqingXingzhi();

    /**
     * 获取所有的  派出所
     *
     * @return
     */
    List<String> getAllAlarmCompany();

    /**
     * 一周警情统计
     *
     * @return
     */
    List<AnQingRecord> getWeekAlarmStatic();

}
