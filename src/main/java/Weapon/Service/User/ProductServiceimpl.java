package Weapon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.ProductsDao;
import Weapon.Dto.ProductsDto;
@Service
public class ProductServiceimpl implements iProductService{
	@Autowired
	ProductsDao productDao = new ProductsDao();
	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}
	public List<ProductsDto> GetProductByIDCate(int id) {
		
		return productDao.GetAllProductById(id);
	}
}
