package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp06;
import com.sun.entity.automodel.Fs_kp06Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp06Mapper {
    long countByExample(Fs_kp06Example example);

    int deleteByExample(Fs_kp06Example example);

    int insert(Fs_kp06 record);

    int insertSelective(Fs_kp06 record);

    List<Fs_kp06> selectByExample(Fs_kp06Example example);

    int updateByExampleSelective(@Param("record") Fs_kp06 record, @Param("example") Fs_kp06Example example);

    int updateByExample(@Param("record") Fs_kp06 record, @Param("example") Fs_kp06Example example);
}