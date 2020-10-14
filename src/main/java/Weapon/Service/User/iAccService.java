package Weapon.Service.User;

import org.springframework.stereotype.Service;

import Weapon.Entity.Users;
@Service
public interface iAccService {
	public int AddAcc(Users user);
	public Users CheckAcc(Users user);
}
