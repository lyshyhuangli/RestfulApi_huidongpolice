package com.api.service;

import com.api.entity.StaticFilesRecord;

import java.util.List;

public interface StaticFilesService
{
    /**
     * 滑动获取数据接口
     * @param count
     * @param fileType
     * @param fileName
     * @return
     */
    List<StaticFilesRecord> getStaticFilsInfoByCount(int count, String fileType, String fileName);
}
