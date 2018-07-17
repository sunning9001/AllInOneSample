package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp04;
import com.sun.entity.automodel.Fs_kp04Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp04Mapper {
    long countByExample(Fs_kp04Example example);

    int deleteByExample(Fs_kp04Example example);

    int insert(Fs_kp04 record);

    int insertSelective(Fs_kp04 record);

    List<Fs_kp04> selectByExample(Fs_kp04Example example);

    int updateByExampleSelective(@Param("record") Fs_kp04 record, @Param("example") Fs_kp04Example example);

    int updateByExample(@Param("record") Fs_kp04 record, @Param("example") Fs_kp04Example example);
}