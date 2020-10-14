package Weapon.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController extends BaseController {
	@RequestMapping(value = { "/contact" })
	public ModelAndView Index() {
		_mvshare.setViewName("user/contact/contact");
		return _mvshare;
	}
}
