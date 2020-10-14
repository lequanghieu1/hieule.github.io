package Weapon.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController extends BaseController{
	@RequestMapping(value = { "/error" })
	public ModelAndView Index() {
		_mvshare.addObject("statusAuthorLogin","Please login to continue");
		_mvshare.addObject("statusAuthor","you are not competent enough");

		_mvshare.setViewName("layouts/error");
		return _mvshare;
	}
}
