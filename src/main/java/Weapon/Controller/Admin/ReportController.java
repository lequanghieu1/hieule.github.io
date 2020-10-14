package Weapon.Controller.Admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Controller.User.BaseController;
import Weapon.Service.Admin.ReportServiceimpl;
import Weapon.bean.MyItem;

@Controller
public class ReportController extends BaseController{
	@Autowired
    private ReportServiceimpl reportService;
	@RequestMapping(value = { "/admin/report" })
	public ModelAndView mv(){
		Date date = new Date();
		List<MyItem> listItem = reportService.reportReceipt(date, 10);
		List<MyItem> listValue = reportService.reportValue(date, 10);
		_mvshare.addObject("listReceipt", listItem);
		_mvshare.addObject("listValue", listValue);
		_mvshare.setViewName("admin/report/report");
		return _mvshare;
	}
}
