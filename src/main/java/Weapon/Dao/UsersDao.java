package Weapon.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Entity.MapperUsers;
import Weapon.Entity.Users;

@Repository
public class UsersDao extends BaseDao{
 public int AddAcc(Users user) {
	 StringBuffer sql = new StringBuffer();
	 sql.append("insert into users (  user,password,displayname,address,id_role  ) values ( ");
	 sql.append("    '"+user.getUser()+"', ");
	 sql.append("    '"+user.getPassword()+"', ");
	 sql.append("    '"+user.getDisplayname()+"', ");
	 sql.append("    '"+user.getAddress()+"',2 ");
	 
	 sql.append(") ");
	 
	 int insert = _jdbcTemplate.update(sql.toString());
	 return insert;
 }
 public Users GetUserAcc(Users user) {
	 String sql="SELECT * FROM users AS u INNER JOIN role AS r on r.id = u.id_role WHERE user='"+user.getUser() +"'";
	 Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
	 return result;
 }
 public List<Users> GetAllUser() {
		String sql = "select * from users AS u INNER JOIN role AS r on r.id = u.id_role";
		List<Users> listusers = _jdbcTemplate.query(sql, new MapperUsers());
		return listusers;
	}
 public List<Users> getUserMana(int start,int totalPage) {
		String sql = "select * from users AS u INNER JOIN role AS r on r.id = u.id_role LIMIT "+(start -1)+","+totalPage;
		List<Users> listusers = _jdbcTemplate.query(sql, new MapperUsers());
		return listusers;
	}
 public int AddUser(Users user) {
	 StringBuffer sql = new StringBuffer();
		sql.append("insert into users(user,password,displayname,address,id_role) values('"+user.getUser()+"','"+user.getPassword()+"','"+user.getDisplayname()+"','"+user.getAddress()+"','"
				+user.getId_role()+"')");
	 
	 int insert = _jdbcTemplate.update(sql.toString());
	 return insert;
 }
public int EditUser(Users user, long id) {
	StringBuffer sql = new StringBuffer();
	sql.append("update users set displayname='"+user.getDisplayname()+"',address='"+user.getAddress()+"',"
			+ "id_role='"+user.getId_role()+" ' where id='"+id+"'");
	int insert = _jdbcTemplate.update(sql.toString());
	 return insert;
}
public int DeleteUser(long id) {
	StringBuffer sql = new StringBuffer();
	sql.append("delete from users where id = '"+id+"'");
	int insert = _jdbcTemplate.update(sql.toString());
	 return insert;
}
public Users FindUserById(long id) {
	String sql = "select * from users AS u INNER JOIN role AS r on r.id = u.id_role WHERE u.id = '"+id+"'";
	Users user = _jdbcTemplate.queryForObject(sql, new MapperUsers());
	return user;
}
 
}
