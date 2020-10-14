package Weapon.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.Dto.ProductsDto;

@Service

public interface iProductService {
	public ProductsDto GetProductByID(long id);
	public List<ProductsDto>  GetProductByIDCate(int id);
	
}
