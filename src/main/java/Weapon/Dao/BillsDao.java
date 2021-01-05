package Weapon.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Entity.BillDetail;
import Weapon.Entity.Bills;
import Weapon.Entity.MapperBills;
import Weapon.Entity.MapperBillsDetail;

@Repository
public class BillsDao extends BaseDao {
	public int AddBills(Bills bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bills (  `user`,`phone`,`displayname`,`address`,`total`,`quanty`,`note`,`date`  ) values ( ");
		sql.append("    '" + bill.getUser() + "', ");
		sql.append("    '" + bill.getPhone() + "', ");
		sql.append("    '" + bill.getDisplayname() + "', ");
		sql.append("    '" + bill.getAddress() + "', ");
		sql.append("    '" + bill.getTotal() + "', ");
		sql.append("    '" + bill.getQuanty() + "', ");
		sql.append("    '" + bill.getNote() + "', ");
		sql.append("    '" + LocalDate.now() + "' ");
		sql.append("); ");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};

	public long GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("select max(id) from bills;");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	};

	public int AddBillsDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into billdetail (  id_product,id_bills,quanty,total  ) values ( ");
		sql.append("    '" + billDetail.getId_product() + "', ");
		sql.append("    '" + billDetail.getId_bill() + "', ");
		sql.append("    '" + billDetail.getQuanty()+ "', ");
		sql.append("    '" + billDetail.getTotal() + "' ");
		sql.append(") ");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};
	public List<Bills> GetAllBill() {
		String sql = "select * from bills";
		List<Bills> listBills = _jdbcTemplate.query(sql, new MapperBills());
		return listBills;
	}
	 public List<Bills> getBillMana(int start,int totalPage) {
			String sql = "select * from bills LIMIT "+(start -1)+","+totalPage;
			List<Bills> listbill = _jdbcTemplate.query(sql, new MapperBills());
			return listbill;
		}
	 public List<BillDetail> FindBillById(long id) {
			String sql = "select * from billdetail where id_bills='"+id+"'";
			List<BillDetail> bill = _jdbcTemplate.query(sql, new MapperBillsDetail());
			return bill;
		}

}
