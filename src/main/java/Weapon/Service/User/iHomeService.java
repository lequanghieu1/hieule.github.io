package Weapon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Weapon.Dto.ProductsDto;
import Weapon.Entity.Categories;
import Weapon.Entity.Menus;
import Weapon.Entity.Slides;
@Service
public interface iHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Categories> GetDataCate();
	public List<Menus> GetDataMenu();
	public List<ProductsDto> GetDataProduct();
	}

