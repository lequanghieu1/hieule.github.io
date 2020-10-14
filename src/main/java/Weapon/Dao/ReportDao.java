package Weapon.Dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.bean.MyItem;

@Repository
public class ReportDao extends BaseDao{
	public List<MyItem> reportReceipt(Date date, int limit) {
        List<MyItem> list = new ArrayList<MyItem>();
        for (int i = limit - 1; i >= 0; i--) {
            Date d = subDays(date, i);
            MyItem myItem = new MyItem();
            myItem.setTime(covertD2S(d));
            myItem.setValue(count(d));
            list.add(myItem);
        }
        return list;
    }
	public List<MyItem> reportValue(Date date, int limit) {
        List<MyItem> list = new ArrayList<MyItem>();
        for (int i = limit - 1; i >= 0; i--) {
            Date d = subDays(date, i);
            MyItem myItem = new MyItem();
            myItem.setTime(covertD2S(d));
            myItem.setValue(value(d));
            list.add(myItem);
        }
        return list;
    }
	public int count(Date date) {
		StringBuffer sql = new StringBuffer();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
		sql.append("select count(*) from bills where date = '"+strDate+"'");
		int count = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return count;
	}
	public int value(Date date) {
		StringBuffer sql = new StringBuffer();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
		sql.append("select sum(total) from bills WHERE date= '"+strDate+"'");
		int count = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return count;
	}
	
	public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date subDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }

    private String covertD2S(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

}
