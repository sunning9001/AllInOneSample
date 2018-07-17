package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp07;
import com.sun.entity.automodel.Fs_kp07Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp07Mapper {
    long countByExample(Fs_kp07Example example);

    int deleteByExample(Fs_kp07Example example);

    int insert(Fs_kp07 record);

    int insertSelective(Fs_kp07 record);

    List<Fs_kp07> selectByExample(Fs_kp07Example example);

    int updateByExampleSelective(@Param("record") Fs_kp07 record, @Param("example") Fs_kp07Example example);

    int updateByExample(@Param("record") Fs_kp07 record, @Param("example") Fs_kp07Example example);
}