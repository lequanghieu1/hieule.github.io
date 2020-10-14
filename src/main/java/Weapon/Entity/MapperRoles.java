package Weapon.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperRoles implements RowMapper<Roles>{
	public Roles mapRow(ResultSet rs,int rowNum) throws SQLException{
		Roles role = new Roles();
		role.setId(rs.getInt("id"));
		role.setName(rs.getString("name"));
		return role;
	}

}
