package com.afis.jx.entity.autodao;

import com.afis.jx.entity.automodel.Fs_kp12;
import com.afis.jx.entity.automodel.Fs_kp12Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Fs_kp12Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    long countByExample(Fs_kp12Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int deleteByExample(Fs_kp12Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int insert(Fs_kp12 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int insertSelective(Fs_kp12 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    List<Fs_kp12> selectByExample(Fs_kp12Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Fs_kp12 record, @Param("example") Fs_kp12Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fs_kp12
     *
     * @mbg.generated Thu Jul 05 12:21:56 CST 2018
     */
    int updateByExample(@Param("record") Fs_kp12 record, @Param("example") Fs_kp12Example example);
}