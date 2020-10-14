package Weapon.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.Entity.Users;
@Service
public interface iUserManaService {
	public List<Users> GetAllUser();
	public List<Users> getUserMana(int start,int totalPage);
	public int AddUser(Users user);
	public int EditUser(Users user, long id);
	public int DeleteUser(long id);
	public Users FindUserById(long id);
}
