package com.afis.jx.entity.autodao;

import com.afis.jx.entity.automodel.Fs_jsfs;
import com.afis.jx.entity.automodel.Fs_jsfsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_jsfsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    long countByExample(Fs_jsfsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    int deleteByExample(Fs_jsfsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    int insert(Fs_jsfs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    int insertSelective(Fs_jsfs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    List<Fs_jsfs> selectByExample(Fs_jsfsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") Fs_jsfs record, @Param("example") Fs_jsfsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_jsfs
     *
     * @mbg.generated Thu Jul 05 10:53:48 CST 2018
     */
    int updateByExample(@Param("record") Fs_jsfs record, @Param("example") Fs_jsfsExample example);
}