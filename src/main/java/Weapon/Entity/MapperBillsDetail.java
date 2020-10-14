package Weapon.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

	public class MapperBillsDetail implements RowMapper<BillDetail> { 
		public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			BillDetail billsde = new BillDetail();
			billsde.setId(rs.getInt("id"));
			billsde.setId_product(rs.getInt("id_product"));
			billsde.setId_bill(rs.getInt("id_bills"));
			billsde.setQuanty(rs.getInt("quanty"));
			billsde.setTotal(rs.getDouble("total"));
			return billsde;
		} 
}
