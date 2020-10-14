package Weapon.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dao.ProductsDao;
import Weapon.Dto.ProductsDto;

@Service
public class ProManaServiceimpl implements iProManaService{
	@Autowired
	ProductsDao productDao = new ProductsDao();
	public List<ProductsDto> GetAllProduct() {
		return productDao.GetAllProduct();
	}
	public List<ProductsDto> GetProductManager(int start, int totalPage) {
		return productDao.GetProductManager(start, totalPage);
	}
	public int AddPro(ProductsDto pro) {
		return productDao.AddPro(pro);
	}
	public int EditPro(ProductsDto pro, long l) {
		return productDao.EditPro(pro, l);
	}
	public ProductsDto FindProductByID(long id) {
		return productDao.FindProductByID(id);
	}
	public int DeletePro(long id) {
		return productDao.DeletePro(id);
	}

}
