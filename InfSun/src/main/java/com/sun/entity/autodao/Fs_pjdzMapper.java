package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_pjdz;
import com.sun.entity.automodel.Fs_pjdzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_pjdzMapper {
    long countByExample(Fs_pjdzExample example);

    int deleteByExample(Fs_pjdzExample example);

    int insert(Fs_pjdz record);

    int insertSelective(Fs_pjdz record);

    List<Fs_pjdz> selectByExample(Fs_pjdzExample example);

    int updateByExampleSelective(@Param("record") Fs_pjdz record, @Param("example") Fs_pjdzExample example);

    int updateByExample(@Param("record") Fs_pjdz record, @Param("example") Fs_pjdzExample example);
}