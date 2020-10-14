package Weapon.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Service.User.HomeServiceimpl;
@Controller
public class BaseController {
	@Autowired
	HomeServiceimpl _homeService;
	public ModelAndView _mvshare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
		_mvshare.addObject("menus", _homeService.GetDataMenu());
		return _mvshare; 
	}
		
	
}
