package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp12;
import com.sun.entity.automodel.Fs_kp12Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp12Mapper {
    long countByExample(Fs_kp12Example example);

    int deleteByExample(Fs_kp12Example example);

    int insert(Fs_kp12 record);

    int insertSelective(Fs_kp12 record);

    List<Fs_kp12> selectByExample(Fs_kp12Example example);

    int updateByExampleSelective(@Param("record") Fs_kp12 record, @Param("example") Fs_kp12Example example);

    int updateByExample(@Param("record") Fs_kp12 record, @Param("example") Fs_kp12Example example);
}