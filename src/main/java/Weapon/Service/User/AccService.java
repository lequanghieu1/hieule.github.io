package Weapon.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.UsersDao;
import Weapon.Entity.Users;

@Service
public class AccService implements iAccService{
@Autowired
UsersDao userDao = new UsersDao();
public int AddAcc(Users user) {
	user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );
	return userDao.AddAcc(user);
}
public Users CheckAcc(Users user) {
	String pass = user.getPassword();
	 user=userDao.GetUserAcc(user);
	 if(user != null) {
		 if(BCrypt.checkpw(pass, user.getPassword())) {
			 return user;
		 }
		 return null;
	 }
	 return null;
}
}
