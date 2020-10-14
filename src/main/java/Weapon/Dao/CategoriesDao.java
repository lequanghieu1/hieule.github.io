package Weapon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Entity.Categories;
import Weapon.Entity.MapperCategories;
import Weapon.Entity.MapperRoles;
import Weapon.Entity.Roles;

@Repository
public class CategoriesDao extends BaseDao {
		public List<Categories> GetDataCate(){
			List<Categories> list = new ArrayList<Categories>();
			String sql ="SELECT * FROM categories";
			list = _jdbcTemplate.query(sql,new MapperCategories());
			return list;
		}
		public List<Roles> GetDataRole(){
			List<Roles> listr = new ArrayList<Roles>();
			String sql ="SELECT * FROM role";
			listr = _jdbcTemplate.query(sql,new MapperRoles());
			return listr;
		}
		
}
