package Weapon.Dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Entity.MapperSlides;
import Weapon.Entity.Slides;

@Repository
public class SlidesDao extends BaseDao{
	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql ="select * from slides";
		list = _jdbcTemplate.query(sql,new MapperSlides());
		return list;
	}
}
