package scan;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sample.mybatis.domain.City;

public interface CityMapper {

	  @Select("SELECT * FROM city WHERE id = #{cityId}")
	public  City getCity(@Param("cityId") String cityId);

	  @Insert("insert into city (name, state, country) values (#{city.name}, #{city.state}, #{city.country});")
	public  void insertCity(@Param("city") City city);
	  
	  
}
