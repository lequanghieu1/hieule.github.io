package Weapon.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.BillsDao;
import Weapon.Dto.CartDto;
import Weapon.Entity.BillDetail;
import Weapon.Entity.Bills;

@Service
public class BillsServiceimpl implements iBillService{
@Autowired
private BillsDao billsDao;
	public int AddBills(Bills bill) {
		return billsDao.AddBills(bill);
	}

	public void AddBillDetail(HashMap<Long, CartDto> carts) {
		long idBills = billsDao.GetIDLastBills();
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}
		
	}

}
