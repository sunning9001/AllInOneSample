package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp01;
import com.sun.entity.automodel.Fs_kp01Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp01Mapper {
    long countByExample(Fs_kp01Example example);

    int deleteByExample(Fs_kp01Example example);

    int insert(Fs_kp01 record);

    int insertSelective(Fs_kp01 record);

    List<Fs_kp01> selectByExample(Fs_kp01Example example);

    int updateByExampleSelective(@Param("record") Fs_kp01 record, @Param("example") Fs_kp01Example example);

    int updateByExample(@Param("record") Fs_kp01 record, @Param("example") Fs_kp01Example example);
}