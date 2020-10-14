package Weapon.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.BillsDao;
import Weapon.Entity.BillDetail;
import Weapon.Entity.Bills;

@Service
public class OrderManaServiceimpl implements iOrderManaService{
	@Autowired
	BillsDao billDao = new BillsDao();
	public List<Bills> GetAllBill() {
		return billDao.GetAllBill();
	}
	public List<Bills> getBillMana(int start, int totalPage) {
		return billDao.getBillMana(start, totalPage);
	}
public List<BillDetail> FindBillById(long id) {
		return billDao.FindBillById(id);
	}

}
