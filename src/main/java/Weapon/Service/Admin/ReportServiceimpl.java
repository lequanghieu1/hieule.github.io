package Weapon.Service.Admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.ReportDao;
import Weapon.bean.MyItem;

@Service
public class ReportServiceimpl implements iReportService{
@Autowired
private ReportDao reportdao;
	public List<MyItem> reportReceipt(Date date, int limit) {
		return reportdao.reportReceipt(date, limit);
	}
	public List<MyItem> reportValue(Date date, int limit) {
		return reportdao.reportValue(date, limit);
	}

}
