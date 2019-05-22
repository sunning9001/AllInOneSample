package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_sync;
import com.sun.entity.automodel.Fs_syncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_syncMapper {
    long countByExample(Fs_syncExample example);

    int deleteByExample(Fs_syncExample example);

    int insert(Fs_sync record);

    int insertSelective(Fs_sync record);

    List<Fs_sync> selectByExample(Fs_syncExample example);

    int updateByExampleSelective(@Param("record") Fs_sync record, @Param("example") Fs_syncExample example);

    int updateByExample(@Param("record") Fs_sync record, @Param("example") Fs_syncExample example);
}