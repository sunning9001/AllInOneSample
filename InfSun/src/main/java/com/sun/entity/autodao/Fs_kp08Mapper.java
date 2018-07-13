package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp08;
import com.sun.entity.automodel.Fs_kp08Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp08Mapper {
    long countByExample(Fs_kp08Example example);

    int deleteByExample(Fs_kp08Example example);

    int insert(Fs_kp08 record);

    int insertSelective(Fs_kp08 record);

    List<Fs_kp08> selectByExample(Fs_kp08Example example);

    int updateByExampleSelective(@Param("record") Fs_kp08 record, @Param("example") Fs_kp08Example example);

    int updateByExample(@Param("record") Fs_kp08 record, @Param("example") Fs_kp08Example example);
}