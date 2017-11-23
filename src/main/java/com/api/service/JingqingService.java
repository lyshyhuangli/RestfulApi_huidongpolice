package com.api.service;

import com.api.entity.AnQingRecord;
import com.api.entity.JingQingInfoRecord;

import java.util.List;

public interface JingqingService
{
    List<JingQingInfoRecord> getLastSevenNumberJingQing();

    JingQingInfoRecord getJingQingInfoById(String id);

    /**
     * 滑动获取数据
     *
     * @param count
     * @return
     */
    List<JingQingInfoRecord> getJingQingMoreInfoByCount(
            int count, String startTime, String endTime, String briefly, String
            conformJingqingXingzhi, String alarmCompany, String chooseIdNo, String
            informantPhoneChoose
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
    List<List<AnQingRecord>> getWeekAlarmStatic();

}
