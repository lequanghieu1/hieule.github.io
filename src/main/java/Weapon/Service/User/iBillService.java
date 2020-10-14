package Weapon.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Weapon.Dto.CartDto;
import Weapon.Entity.Bills;

@Service
public interface iBillService {
public int AddBills(Bills bill);
public void AddBillDetail(HashMap<Long, CartDto> carts);
}
