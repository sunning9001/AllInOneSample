package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp02;
import com.sun.entity.automodel.Fs_kp02Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp02Mapper {
    long countByExample(Fs_kp02Example example);

    int deleteByExample(Fs_kp02Example example);

    int insert(Fs_kp02 record);

    int insertSelective(Fs_kp02 record);

    List<Fs_kp02> selectByExample(Fs_kp02Example example);

    int updateByExampleSelective(@Param("record") Fs_kp02 record, @Param("example") Fs_kp02Example example);

    int updateByExample(@Param("record") Fs_kp02 record, @Param("example") Fs_kp02Example example);
}