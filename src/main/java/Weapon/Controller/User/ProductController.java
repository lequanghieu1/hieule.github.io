package Weapon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Service.User.iProductService;

@Controller
public class ProductController extends BaseController{

	@Autowired
	private iProductService _productService;

	@RequestMapping(value = { "product-details/{id}" })
	public ModelAndView Index(@PathVariable long id) {
		_mvshare.setViewName("user/product/product");
		_mvshare.addObject("product", _productService.GetProductByID(id));
		_mvshare.addObject("productByIdCate", _productService.GetProductByIDCate(_productService.GetProductByID(id).getId_categories()));
		return _mvshare;
	}
}
