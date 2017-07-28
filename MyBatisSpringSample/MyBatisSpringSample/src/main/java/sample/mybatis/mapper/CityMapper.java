package sample.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sample.mybatis.domain.City;

public interface CityMapper {

	  @Select("SELECT * FROM city WHERE id = #{cityId}")
	  City getCity(@Param("cityId") String cityId);

	  @Insert("insert into city (name, state, country) values (#{city.name}, #{city.state}, #{city.country});")
	  void insertCity(@Param("city") City city);
	  
	  
	  City selectCityById(@Param("id") String id);
	  
}
