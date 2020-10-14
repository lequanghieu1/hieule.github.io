package Weapon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Dto.PaginatesDto;
import Weapon.Service.User.CategoryServiceimpl;
import Weapon.Service.User.PaginateServiceimpl;

@Controller
public class CategoryController extends BaseController {
	@Autowired
	private CategoryServiceimpl cate;
	@Autowired
	private PaginateServiceimpl pagi;
	int totalProductsPage = 9;

	@RequestMapping(value = "/product/{id}")
	public ModelAndView Product(@PathVariable String id) {
		
		_mvshare.setViewName("user/product/category");
		int totalData = cate.getAllProductsByid(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvshare.addObject("idCategory", id);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.addObject("ProductsPaginate", cate.GetDataProductsPaginates(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		return _mvshare;
	}
	
	
	@RequestMapping(value = "/product/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		_mvshare.setViewName("user/product/category");
		int totalData = cate.getAllProductsByid(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvshare.addObject("idCategory", id);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.addObject("ProductsPaginate", cate.GetDataProductsPaginates(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		return _mvshare;
	}
}
