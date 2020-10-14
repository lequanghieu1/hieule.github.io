package Weapon.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.Dto.ProductsDto;

@Service
public interface iProManaService {
	public List<ProductsDto> GetAllProduct();
	public List<ProductsDto> GetProductManager(int start,int totalPage);
	public int AddPro(ProductsDto pro);
	public int EditPro(ProductsDto tv, long id);
	public ProductsDto FindProductByID(long id);
	public int DeletePro(long id);
}
