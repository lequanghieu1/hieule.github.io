package Weapon.Service.Admin;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.UsersDao;
import Weapon.Entity.Users;
@Service
public class UserManaServiceimpl implements iUserManaService {
	@Autowired
	UsersDao userDao = new UsersDao();
	public List<Users> GetAllUser() {
		return userDao.GetAllUser();
	}
	public List<Users> getUserMana(int start, int totalPage) {
		return userDao.getUserMana(start, totalPage);
	}
	public int AddUser(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );
		return userDao.AddUser(user);
	}
	public int EditUser(Users user, long id) {
		return userDao.EditUser(user, id);
	}
	public int DeleteUser(long id) {
		return userDao.DeleteUser(id);
	}
	public Users FindUserById(long id) {
		return userDao.FindUserById(id);
	}

}
