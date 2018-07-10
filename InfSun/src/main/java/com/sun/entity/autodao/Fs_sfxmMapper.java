package com.sun.entity.autodao;

import com.sun.entity.automodel.Fs_sfxm;
import com.sun.entity.automodel.Fs_sfxmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_sfxmMapper {
    long countByExample(Fs_sfxmExample example);

    int deleteByExample(Fs_sfxmExample example);

    int insert(Fs_sfxm record);

    int insertSelective(Fs_sfxm record);

    List<Fs_sfxm> selectByExample(Fs_sfxmExample example);

    int updateByExampleSelective(@Param("record") Fs_sfxm record, @Param("example") Fs_sfxmExample example);

    int updateByExample(@Param("record") Fs_sfxm record, @Param("example") Fs_sfxmExample example);
    
    public Fs_sfxm selectByDm(String dm);
    
    public String selectByDm2(String dm);
    
    
}