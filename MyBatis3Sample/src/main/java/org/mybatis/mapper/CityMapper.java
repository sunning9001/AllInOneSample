package org.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.example.City;
@Mapper
public interface CityMapper {

	
	City selectCityById(@Param("id") String id);
	
	int insert(City city);



}
