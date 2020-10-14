package Weapon.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Dto.CartDto;
import Weapon.Entity.Bills;
import Weapon.Entity.Users;
import Weapon.Service.User.BillsServiceimpl;
import Weapon.Service.User.CartServiceimpl;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceimpl cartSe = new CartServiceimpl();
	@Autowired
	private BillsServiceimpl billSe = new BillsServiceimpl();
	@RequestMapping(value="gio-hang")
	public ModelAndView Index() {		
		_mvshare.addObject("slides", _homeService.GetDataSlide());
		_mvshare.addObject("categories", _homeService.GetDataCate());
		_mvshare.addObject("products", _homeService.GetDataProduct());
		_mvshare.setViewName("user/cart/list_cart");
		return _mvshare;
	}
	
	@RequestMapping(value="AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session,@PathVariable long id) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
	    cart=cartSe.AddCart(id, cart);
		session.setAttribute("Cart",cart );
		session.setAttribute("TotalQuantyCart",cartSe.TotalQuanty(cart) );
		session.setAttribute("TotalPriceCart",cartSe.TotalPrice(cart) );
		return "redirect:"+request.getHeader("referer");
		
	}
	@RequestMapping(value="EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request,HttpSession session,@PathVariable long id,@PathVariable int quanty) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
	    cart=cartSe.EditCart(id, quanty, cart);
		session.setAttribute("Cart",cart );
		session.setAttribute("TotalQuantyCart",cartSe.TotalQuanty(cart) );
		session.setAttribute("TotalPriceCart",cartSe.TotalPrice(cart) );
		return "redirect:"+request.getHeader("referer");
		
	}
	@RequestMapping(value="DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session,@PathVariable long id) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
	    cart=cartSe.DeleteCart(id, cart);
		session.setAttribute("Cart",cart );
		session.setAttribute("TotalQuantyCart",cartSe.TotalQuanty(cart) );
		session.setAttribute("TotalPriceCart",cartSe.TotalPrice(cart) );
		return "redirect:"+request.getHeader("referer");
		
	}
	@RequestMapping(value="checkout",method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		_mvshare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplayname(loginInfo.getDisplayname());
			bills.setUser(loginInfo.getUser());
		}
		_mvshare.addObject("bills", bills);
		return _mvshare;
		
	}
	@RequestMapping(value="checkout",method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request,HttpSession session,@ModelAttribute("bills") Bills bill) {
		bill.setQuanty(Integer.parseInt(session.getAttribute("TotalQuantyCart").toString()));
		bill.setTotal(Double.parseDouble(session.getAttribute("TotalPriceCart").toString()));
		if(billSe.AddBills(bill)>0) {
			HashMap<Long, CartDto> carts =(HashMap<Long, CartDto>)session.getAttribute("Cart");
			billSe.AddBillDetail(carts);
		}
	session.removeAttribute("Cart");
	session.setAttribute("TotalQuantyCart", 0);
	session.setAttribute("TotalPriceCart",0);
	
	_mvshare.addObject("statuscheckout"," Thanh toán thành công,xin cảm ơn quý khách");
		return "redirect:gio-hang";
		
	}

}
