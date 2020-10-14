package Weapon.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {		
		_mvshare.addObject("slides", _homeService.GetDataSlide());
		_mvshare.addObject("categories", _homeService.GetDataCate());
		_mvshare.addObject("products", _homeService.GetDataProduct());
		_mvshare.setViewName("user/index");
		return _mvshare;
	}
	
}
