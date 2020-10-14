package Weapon.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Controller.User.BaseController;

@Controller
public class HomeAdminController extends BaseController{
	@RequestMapping(value = { "/admin" })
	public ModelAndView Index() {		
		_mvshare.setViewName("admin/indexad");
		//_mvshare.setViewName("admin/product/product-list");
		return _mvshare;
	}
	
}
