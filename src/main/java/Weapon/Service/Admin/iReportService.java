package Weapon.Service.Admin;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.bean.MyItem;

@Service
public interface iReportService {
	public List<MyItem> reportReceipt(Date date, int limit);
	public List<MyItem> reportValue(Date date, int limit);
	
}
