package com.api.service.impl;

import com.api.entity.StaticFilesRecord;
import com.api.mapper.StaticFilesMapper;
import com.api.service.StaticFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaticFilesServiceImpl implements StaticFilesService
{
    @Autowired
    private StaticFilesMapper staticFilesMapper;

    /**
     * 滑动获取数据接口
     *
     * @param count
     * @param fileType
     * @param fileName
     * @return
     */
    public List<StaticFilesRecord> getStaticFilsInfoByCount(int count, String fileType, String fileName)
    {
        List<StaticFilesRecord> l = staticFilesMapper.getStaticFilsInfoByCount(count, fileType, fileName);
        return l;
    }
}
