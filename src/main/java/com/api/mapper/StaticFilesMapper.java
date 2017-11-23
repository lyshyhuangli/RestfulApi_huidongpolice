package com.api.mapper;

import com.api.entity.StaticFilesRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaticFilesMapper
{
    /**
     * 滑动获取数据接口
     *
     * @param count
     * @param fileType
     * @param fileName
     * @return
     */
    List<StaticFilesRecord> getStaticFilsInfoByCount(
            @Param("count") int count, @Param("fileType") String fileType, @Param("fileName") String fileName
    );
}
