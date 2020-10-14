package Weapon.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Weapon.Controller.User.BaseController;
import Weapon.Dao.ProductsDao;
import Weapon.Dto.PaginatesDto;
import Weapon.Entity.BillDetail;
import Weapon.Entity.Bills;
import Weapon.Service.Admin.OrderManaServiceimpl;
import Weapon.Service.User.PaginateServiceimpl;

@Controller
public class OrderManagerController extends BaseController{
	@Autowired
	private OrderManaServiceimpl _oderService;
	@Autowired
	private PaginateServiceimpl pagi;
	@Autowired
	private ProductsDao pro;
	int totalBills = 5;
	@RequestMapping(value = { "/admin/order-manager" })
	public ModelAndView Index() {
		int totalData = _oderService.GetAllBill().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalBills, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/order/order-list");
		_mvshare.addObject("ManagerPagi",
				_oderService.getBillMana(paginateInfo.getStart(), totalBills));
		return _mvshare;
	}

	@RequestMapping(value = "/admin/order-manager/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		_mvshare.setViewName("admin/order/order-list");
		int totalData = _oderService.GetAllBill().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalBills, Integer.parseInt(currentPage));
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.addObject("ManagerPagi",
				_oderService.getBillMana(paginateInfo.getStart(), totalBills));
		return _mvshare;
	}
/*
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
			_oderService.AddPro(pro);
		}else {
			_oderService.EditPro(pro, pro.getId());
		}
		_mvshare.addObject("pro",pro);
		_mvshare.addObject("listCategory", cate.GetDataCate());
		_mvshare.setViewName("admin/product/product");
		return _mvshare;
	}
*/
	@RequestMapping(value = "/admin/order-manager/details/{id}")
	public ModelAndView viewdetail(@PathVariable("id") long id) {
		List<BillDetail> p = _oderService.FindBillById(id);
		List<Bills> b = _oderService.GetAllBill();
        _mvshare.addObject("bill", p);
        _mvshare.addObject("bills", b);
        _mvshare.addObject("listProduct",pro.GetAllProduct());
		_mvshare.setViewName("admin/order/billdetail");
		return _mvshare;
	}
	/*
	@RequestMapping(value = "/admin/product-manager/remove/{id}", method = RequestMethod.GET)
    public ModelAndView viewProductRemove(@PathVariable("id") long id) {
		ProductsDto p = _oderService.FindProductByID(id);
        if (p != null) {     	
        		_oderService.DeletePro(id);
        }
        int totalData = _oderService.GetAllProduct().size();
		PaginatesDto paginateInfo = pagi.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvshare.addObject("paginateInfo", paginateInfo);
		_mvshare.setViewName("admin/product/product-list");
		_mvshare.addObject("ManagerPagi",
				_oderService.GetProductManager(paginateInfo.getStart(), totalProductsPage));
		_mvshare.addObject("listCategory", cate.GetDataCate());
		return _mvshare;
    }*/
}
