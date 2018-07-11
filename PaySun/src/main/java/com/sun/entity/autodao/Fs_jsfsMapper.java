package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_jsfs;
import com.sun.entity.automodel.Fs_jsfsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_jsfsMapper {
    long countByExample(Fs_jsfsExample example);

    int deleteByExample(Fs_jsfsExample example);

    int insert(Fs_jsfs record);

    int insertSelective(Fs_jsfs record);

    List<Fs_jsfs> selectByExample(Fs_jsfsExample example);

    int updateByExampleSelective(@Param("record") Fs_jsfs record, @Param("example") Fs_jsfsExample example);

    int updateByExample(@Param("record") Fs_jsfs record, @Param("example") Fs_jsfsExample example);
}