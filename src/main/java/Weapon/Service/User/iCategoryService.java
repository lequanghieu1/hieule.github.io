package Weapon.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Weapon.Dto.ProductsDto;
@Service
public interface iCategoryService {
public List<ProductsDto> getAllProductsByid(int id);

}
