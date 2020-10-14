package Weapon.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Entity.Users;
import Weapon.Service.User.AccService;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccService accservice = new AccService();
@RequestMapping(value = "/dang-ky",method=RequestMethod.GET)
public ModelAndView Register() {
	_mvshare.setViewName("user/account/register");
	_mvshare.addObject("user",new Users());
	return _mvshare;
}
@RequestMapping(value = "/dang-ky",method=RequestMethod.POST)
public ModelAndView CreatAccount(@ModelAttribute("user") Users user) {
	int count = accservice.AddAcc(user);
	if(count > 0) {
		_mvshare.addObject("status","Đăng ký tài khoản thành công");
	}else {
	_mvshare.addObject("status","Đăng ký tài khoản thất bại");
	}
	_mvshare.setViewName("user/account/register");
	return _mvshare;
}
@RequestMapping(value = "/dang-nhap",method=RequestMethod.GET)
public ModelAndView Login() {
	_mvshare.setViewName("user/account/login");
	_mvshare.addObject("user",new Users());
	
	return _mvshare;
}
@RequestMapping(value = "/dang-nhap",method=RequestMethod.POST)
public ModelAndView Login(HttpServletRequest request,HttpSession session,  @ModelAttribute("user") Users user) {
	user = accservice.CheckAcc(user);
	if(user!=null) {
		if(user.getRole().getName().equals("user")) {
		_mvshare.setViewName("redirect:trang-chu");
		session.setAttribute("LoginInfo",user);
		session.setAttribute("TotalQuantyCart", 0);
		session.setAttribute("TotalPriceCart",0);
		}
		else if(user.getRole().getName().equals("admin")) {
			_mvshare.setViewName("redirect:admin");
			session.setAttribute("LoginInfo",user);
		}
	}else {
	_mvshare.addObject("statusLogin","Sai tên đăng nhập hoặc mật khẩu");
	
	_mvshare.setViewName("redirect:/dang-nhap");
	}
	return _mvshare;
}
@RequestMapping(value = "/dang-xuat",method=RequestMethod.GET)
public String Logout(HttpSession session,HttpServletRequest request) {
	session.removeAttribute("LoginInfo");
	session.setAttribute("TotalQuantyCart", 0);
	session.setAttribute("TotalPriceCart",0);
	return "redirect:/dang-nhap";
}
}
