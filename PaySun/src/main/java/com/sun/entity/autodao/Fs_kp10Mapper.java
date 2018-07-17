package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp10;
import com.sun.entity.automodel.Fs_kp10Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp10Mapper {
    long countByExample(Fs_kp10Example example);

    int deleteByExample(Fs_kp10Example example);

    int insert(Fs_kp10 record);

    int insertSelective(Fs_kp10 record);

    List<Fs_kp10> selectByExample(Fs_kp10Example example);

    int updateByExampleSelective(@Param("record") Fs_kp10 record, @Param("example") Fs_kp10Example example);

    int updateByExample(@Param("record") Fs_kp10 record, @Param("example") Fs_kp10Example example);
}