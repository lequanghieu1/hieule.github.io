package Weapon.Dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Weapon.Dto.ProductsDto;
import Weapon.Dto.ProductsDtoMapper;
@Repository
public class ProductsDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("* ");
		sql.append("from ");
		sql.append("product ");
		return sql;
	}
	
	private String SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (highLight) {
			sql.append("AND highlight = true ");
		}
		if (newProduct) {
			sql.append("AND new_product = true ");
		}
		sql.append("ORDER BY RAND() ");
		if (highLight) {
			sql.append("LIMIT 9 ");
		}
		if (newProduct) {
			sql.append("LIMIT 12 ");
		}
		return sql.toString();
	}
	private StringBuffer SqlProductsById(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_categories = "+id+" ");
		return sql;
	}
	private String SqlManagerPaginate(int start,int totalPage) {
		StringBuffer sql = SqlString();
		sql.append("LIMIT "+(start-1)+", "+totalPage);
		return sql.toString();
	}
	private String SqlProductsPaginate(int id,int start,int totalPage) {
		StringBuffer sql = SqlProductsById(id);
		sql.append("LIMIT "+(start-1)+", "+totalPage);
		return sql.toString();
	}
	public List<ProductsDto> GetDataProduct() {
		String sql = SqlProducts(NO, YES);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	public List<ProductsDto> GetProductManager(int start,int totalPage) {
		String sql = SqlManagerPaginate(start,totalPage);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	public List<ProductsDto> GetAllProductById(int id) {
		
		String sql = SqlProductsById(id).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
	public List<ProductsDto> GetDataProductsPaginates(int id,int start,int totalPage) {
		StringBuffer sqlGetDataById=SqlProductsById(id);
		List<ProductsDto> listProductsById = _jdbcTemplate.query(sqlGetDataById.toString(), new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if(listProductsById.size()>0) {
			String sql = SqlProductsPaginate(id,start,totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		
		
		return listProducts;
	}
	private String SqlProductById(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id = "+id+" LIMIT 1");
		return sql.toString();
	}
	public int AddPro(ProductsDto pro) {
		 StringBuffer sql = new StringBuffer();
			sql.append("insert into product(id_categories,name,price,sale,title,highlight,new_product,details,img,creat_at,update_at) values('"+pro.getId_categories()+"','"+pro.getName()+"','"+pro.getPrice()+"','0','"+pro.getTitle()+"','0',"
					+ "'1','Sản phẩm mới','"+pro.getImg()+"','2020-09-28 14:08:17','2020-09-28 14:08:17')");
		 
		 int insert = _jdbcTemplate.update(sql.toString());
		 return insert;
	 }
	public int EditPro(ProductsDto pro, long id) {
		StringBuffer sql = new StringBuffer();
		sql.append("update product set id_categories='"+pro.getId_categories()+"',name='"+pro.getName()+"',price='"+pro.getPrice()+"',title='"+pro.getTitle()+"',"
				+ "img='"+pro.getImg()+" ' where id='"+id+"'");
		int insert = _jdbcTemplate.update(sql.toString());
		 return insert;
	}
	public int DeletePro(long id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from product where id='"+id+"'");
		int insert = _jdbcTemplate.update(sql.toString());
		 return insert;
	}

	public List<ProductsDto> GetProductByID(long id) {
		String sql = SqlProductById(id);
		List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}
	public ProductsDto FindProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append(" where id = "+id+" ");
		ProductsDto product = _jdbcTemplate.queryForObject(sql.toString(), new ProductsDtoMapper());
		return product;
	}
	public List<ProductsDto> GetAllProduct() {
		String sql = "select * from product";
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

}
