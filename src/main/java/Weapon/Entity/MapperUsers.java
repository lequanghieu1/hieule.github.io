package Weapon.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users>{
	public  Users mapRow(ResultSet rs,int rowNum) throws SQLException{
		Users users = new Users();
		users.setId(rs.getInt("id"));
		users.setUser(rs.getString("user"));
		users.setPassword(rs.getString("password"));
		users.setDisplayname(rs.getString("displayname"));
		users.setAddress(rs.getString("address"));
		users.setId_role(rs.getInt("id_role"));
		Roles role = new Roles();
		role.setName(rs.getString("name"));
		users.setRole(role);
		return users;
	}

}
