package Weapon.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.Entity.BillDetail;
import Weapon.Entity.Bills;

@Service
public interface iOrderManaService {
	public List<Bills> GetAllBill();
	public List<Bills> getBillMana(int start,int totalPage);
	public List<BillDetail> FindBillById(long id);
}
