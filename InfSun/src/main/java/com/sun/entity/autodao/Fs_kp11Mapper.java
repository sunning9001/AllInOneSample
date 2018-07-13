package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp11;
import com.sun.entity.automodel.Fs_kp11Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp11Mapper {
    long countByExample(Fs_kp11Example example);

    int deleteByExample(Fs_kp11Example example);

    int insert(Fs_kp11 record);

    int insertSelective(Fs_kp11 record);

    List<Fs_kp11> selectByExample(Fs_kp11Example example);

    int updateByExampleSelective(@Param("record") Fs_kp11 record, @Param("example") Fs_kp11Example example);

    int updateByExample(@Param("record") Fs_kp11 record, @Param("example") Fs_kp11Example example);
}