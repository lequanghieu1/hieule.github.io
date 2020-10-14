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
import Weapon.Dto.ProductsDto;
import Weapon.Service.Admin.ProManaServiceimpl;
import Weapon.Service.User.PaginateServiceimpl;

@Controller
public class ProductManagerController extends BaseController {
	@Autowired
	private ProManaServiceimpl _productService;
	@Autowired
	private PaginateServiceimpl pagi;
	@Autowired
	private CategoriesDao cate;
	int totalProductsPage = 5;

	@RequestMapping(value = { "/admin/product-manager" })
	public ModelAndView Index() {
		int totalData = _productService.GetAllProduct().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/product/product-list");
		_mvshare.addObject("ManagerPagi",
				_productService.GetProductManager(paginateInfo.getStart(), totalProductsPage));
		_mvshare.addObject("listCategory", cate.GetDataCate());
		return _mvshare;
	}

	@RequestMapping(value = "/admin/product-manager/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		_mvshare.setViewName("admin/product/product-list");
		int totalData = _productService.GetAllProduct().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.addObject("ManagerPagi",
				_productService.GetProductManager(paginateInfo.getStart(), totalProductsPage));
		return _mvshare;
	}

	@RequestMapping(value = "/admin/product-manager/add", method = RequestMethod.GET)
	public ModelAndView addProductNew() {
		_mvshare.addObject("pro", new ProductsDto());
		_mvshare.addObject("listCategory", cate.GetDataCate());
		_mvshare.setViewName("admin/product/product");
		return _mvshare;
	}

	@RequestMapping(value = "/admin/product-manager/save", method = RequestMethod.POST)
	public ModelAndView CreatPro(@ModelAttribute("pro") ProductsDto pro) {
		if(pro.getId() == 0) {
			_productService.AddPro(pro);
		}else {
			_productService.EditPro(pro, pro.getId());
		}
		_mvshare.addObject("pro",pro);
		_mvshare.addObject("listCategory", cate.GetDataCate());
		_mvshare.setViewName("admin/product/product");
		return _mvshare;
	}

	@RequestMapping(value = "/admin/product-manager/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductNew(@PathVariable("id") long id) {
        ProductsDto p = _productService.FindProductByID(id);
        _mvshare.addObject("pro", p);
		_mvshare.addObject("listCategory", cate.GetDataCate());
		_mvshare.setViewName("admin/product/product");
		return _mvshare;
	}
	@RequestMapping(value = "/admin/product-manager/remove/{id}", method = RequestMethod.GET)
    public ModelAndView viewProductRemove(@PathVariable("id") long id) {
		ProductsDto p = _productService.FindProductByID(id);
        if (p != null) {     	
        		_productService.DeletePro(id);
        }
        int totalData = _productService.GetAllProduct().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/product/product-list");
		_mvshare.addObject("ManagerPagi",
				_productService.GetProductManager(paginateInfo.getStart(), totalProductsPage));
		_mvshare.addObject("listCategory", cate.GetDataCate());
		return _mvshare;
    }

	

}
