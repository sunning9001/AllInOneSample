package com.afis.jx.entity.autodao;

import com.afis.jx.entity.automodel.Fs_kp06;
import com.afis.jx.entity.automodel.Fs_kp06Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp06Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    long countByExample(Fs_kp06Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int deleteByExample(Fs_kp06Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int insert(Fs_kp06 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int insertSelective(Fs_kp06 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    List<Fs_kp06> selectByExample(Fs_kp06Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Fs_kp06 record, @Param("example") Fs_kp06Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp06
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int updateByExample(@Param("record") Fs_kp06 record, @Param("example") Fs_kp06Example example);
}