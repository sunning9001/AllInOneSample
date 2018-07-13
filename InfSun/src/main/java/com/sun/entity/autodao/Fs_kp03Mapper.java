package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kp03;
import com.sun.entity.automodel.Fs_kp03Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp03Mapper {
    long countByExample(Fs_kp03Example example);

    int deleteByExample(Fs_kp03Example example);

    int insert(Fs_kp03 record);

    int insertSelective(Fs_kp03 record);

    List<Fs_kp03> selectByExample(Fs_kp03Example example);

    int updateByExampleSelective(@Param("record") Fs_kp03 record, @Param("example") Fs_kp03Example example);

    int updateByExample(@Param("record") Fs_kp03 record, @Param("example") Fs_kp03Example example);
}