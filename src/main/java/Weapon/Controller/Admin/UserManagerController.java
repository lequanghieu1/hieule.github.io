package Weapon.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Controller.User.BaseController;
import Weapon.Dao.CategoriesDao;
import Weapon.Dto.PaginatesDto;
import Weapon.Entity.Users;
import Weapon.Service.Admin.UserManaServiceimpl;
import Weapon.Service.User.PaginateServiceimpl;

@Controller
public class UserManagerController extends BaseController{
	@Autowired
	private PaginateServiceimpl pagi;
	@Autowired
	private UserManaServiceimpl _UserService;
	@Autowired
	private CategoriesDao cate;
	int totalUser = 5;
	@RequestMapping(value = { "/admin/user-manager" })
	public ModelAndView main() {
		int totalData = _UserService.GetAllUser().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalUser, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/user/user-list");
		_mvshare.addObject("ManagerPagi",
				_UserService.getUserMana(paginateInfo.getStart(), totalUser));
		_mvshare.addObject("listRole", cate.GetDataRole());
		return _mvshare;
	}

	@RequestMapping(value = "/admin/user-manager/{currentPage}")
	public ModelAndView User(@PathVariable String currentPage) {
		_mvshare.setViewName("admin/user/user-list");
		int totalData = _UserService.GetAllUser().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalUser, Integer.parseInt(currentPage));
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.addObject("ManagerPagi",
				_UserService.getUserMana(paginateInfo.getStart(), totalUser));
		return _mvshare;
	}

	@RequestMapping(value = "/admin/user-manager/add", method = RequestMethod.GET)
	public ModelAndView addUserNew() {
		_mvshare.addObject("user", new Users());
		_mvshare.addObject("listRole", cate.GetDataRole());
		_mvshare.setViewName("admin/user/user-form");
		return _mvshare;
	}

	@RequestMapping(value = "/admin/user-manager/save", method = RequestMethod.POST)
	public ModelAndView saveUserNew(@ModelAttribute("user") Users user) {
		if(user.getId() == 0) {
			_UserService.AddUser(user);
		}else {
			_UserService.EditUser(user, user.getId());
		}
		_mvshare.addObject("user",user);
		_mvshare.addObject("listRole", cate.GetDataRole());
		_mvshare.setViewName("admin/user/user-form");
		return _mvshare;
	}

	@RequestMapping(value = "/admin/user-manager/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserNew(@PathVariable("id") long id) {
        Users p = _UserService.FindUserById(id);
        _mvshare.addObject("user", p);
		_mvshare.addObject("listRole", cate.GetDataRole());
		_mvshare.setViewName("admin/user/user-form");
		return _mvshare;
	}
	@RequestMapping(value = "/admin/user-manager/remove/{id}", method = RequestMethod.GET)
    public ModelAndView RemoveUser(@PathVariable("id") long id) {
		Users p = _UserService.FindUserById(id);
        if (p != null) {     	
        		_UserService.DeleteUser(id);
        }
        int totalData = _UserService.GetAllUser().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalUser, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/user/user-list");
		_mvshare.addObject("ManagerPagi",
				_UserService.getUserMana(paginateInfo.getStart(), totalUser));
		_mvshare.addObject("listRole", cate.GetDataRole());
		return _mvshare;
    }
}
