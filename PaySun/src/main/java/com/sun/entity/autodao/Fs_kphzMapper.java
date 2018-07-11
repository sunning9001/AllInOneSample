package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kphzMapper {
    long countByExample(Fs_kphzExample example);

    int deleteByExample(Fs_kphzExample example);

    int insert(Fs_kphz record);

    int insertSelective(Fs_kphz record);

    List<Fs_kphz> selectByExample(Fs_kphzExample example);

    int updateByExampleSelective(@Param("record") Fs_kphz record, @Param("example") Fs_kphzExample example);

    int updateByExample(@Param("record") Fs_kphz record, @Param("example") Fs_kphzExample example);
}