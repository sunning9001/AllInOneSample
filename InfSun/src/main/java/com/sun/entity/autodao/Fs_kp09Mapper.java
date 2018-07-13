package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp09;
import com.sun.entity.automodel.Fs_kp09Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp09Mapper {
    long countByExample(Fs_kp09Example example);

    int deleteByExample(Fs_kp09Example example);

    int insert(Fs_kp09 record);

    int insertSelective(Fs_kp09 record);

    List<Fs_kp09> selectByExample(Fs_kp09Example example);

    int updateByExampleSelective(@Param("record") Fs_kp09 record, @Param("example") Fs_kp09Example example);

    int updateByExample(@Param("record") Fs_kp09 record, @Param("example") Fs_kp09Example example);
}