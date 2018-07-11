package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_yhwd;
import com.sun.entity.automodel.Fs_yhwdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_yhwdMapper {
    long countByExample(Fs_yhwdExample example);

    int deleteByExample(Fs_yhwdExample example);

    int insert(Fs_yhwd record);

    int insertSelective(Fs_yhwd record);

    List<Fs_yhwd> selectByExample(Fs_yhwdExample example);

    int updateByExampleSelective(@Param("record") Fs_yhwd record, @Param("example") Fs_yhwdExample example);

    int updateByExample(@Param("record") Fs_yhwd record, @Param("example") Fs_yhwdExample example);
}