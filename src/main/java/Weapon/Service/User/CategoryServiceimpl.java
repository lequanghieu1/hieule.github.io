package Weapon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.ProductsDao;
import Weapon.Dto.ProductsDto;
@Service
public class CategoryServiceimpl implements iCategoryService{

	@Autowired
	public ProductsDao productsDao;
	public List<ProductsDto> getAllProductsByid(int id) {
		return productsDao.GetAllProductById(id);
	}
	public List<ProductsDto> GetDataProductsPaginates(int id,int start, int totalPage) {
		return productsDao.GetDataProductsPaginates(id,start, totalPage);
		 
	}
	
}
