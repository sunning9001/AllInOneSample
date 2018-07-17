package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_pjjf;
import com.sun.entity.automodel.Fs_pjjfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_pjjfMapper {
    long countByExample(Fs_pjjfExample example);

    int deleteByExample(Fs_pjjfExample example);

    int insert(Fs_pjjf record);

    int insertSelective(Fs_pjjf record);

    List<Fs_pjjf> selectByExample(Fs_pjjfExample example);

    int updateByExampleSelective(@Param("record") Fs_pjjf record, @Param("example") Fs_pjjfExample example);

    int updateByExample(@Param("record") Fs_pjjf record, @Param("example") Fs_pjjfExample example);
}