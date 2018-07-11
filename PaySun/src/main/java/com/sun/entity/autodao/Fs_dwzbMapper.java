package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_dwzb;
import com.sun.entity.automodel.Fs_dwzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_dwzbMapper {
    long countByExample(Fs_dwzbExample example);

    int deleteByExample(Fs_dwzbExample example);

    int insert(Fs_dwzb record);

    int insertSelective(Fs_dwzb record);

    List<Fs_dwzb> selectByExample(Fs_dwzbExample example);

    int updateByExampleSelective(@Param("record") Fs_dwzb record, @Param("example") Fs_dwzbExample example);

    int updateByExample(@Param("record") Fs_dwzb record, @Param("example") Fs_dwzbExample example);
}