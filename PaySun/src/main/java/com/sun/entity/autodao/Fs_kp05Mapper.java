package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp05;
import com.sun.entity.automodel.Fs_kp05Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp05Mapper {
    long countByExample(Fs_kp05Example example);

    int deleteByExample(Fs_kp05Example example);

    int insert(Fs_kp05 record);

    int insertSelective(Fs_kp05 record);

    List<Fs_kp05> selectByExample(Fs_kp05Example example);

    int updateByExampleSelective(@Param("record") Fs_kp05 record, @Param("example") Fs_kp05Example example);

    int updateByExample(@Param("record") Fs_kp05 record, @Param("example") Fs_kp05Example example);
}