package Weapon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Entity.MapperMenus;
import Weapon.Entity.Menus;

@Repository
public class MenusDao extends BaseDao{
	public List<Menus> GetDataMenu(){
		List<Menus> list = new ArrayList<Menus>();
		String sql ="select * from menus";
		list = _jdbcTemplate.query(sql,new MapperMenus());
		return list;
	}
}
