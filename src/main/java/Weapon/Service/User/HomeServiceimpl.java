package Weapon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.CategoriesDao;
import Weapon.Dao.MenusDao;
import Weapon.Dao.ProductsDao;
import Weapon.Dao.SlidesDao;
import Weapon.Dto.ProductsDto;
import Weapon.Entity.Categories;
import Weapon.Entity.Menus;
import Weapon.Entity.Slides;
@Service
public class HomeServiceimpl implements iHomeService { 
	@Autowired
	private SlidesDao slidedao;
	@Autowired
	private CategoriesDao categorydao;
	@Autowired
	private MenusDao menudao;
	@Autowired
	private ProductsDao productdao;
	public List<Slides> GetDataSlide() {
		
		return slidedao.GetDataSlide();
	}
	public List<Categories> GetDataCate() {
		
		return categorydao.GetDataCate();
	}
	public List<Menus> GetDataMenu() {
		return menudao.GetDataMenu();
	}
	public List<ProductsDto> GetDataProduct() {
		List<ProductsDto> listPro = productdao.GetDataProduct();
		return listPro;
	}
	
 
}
