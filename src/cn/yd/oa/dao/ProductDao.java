package cn.yd.oa.dao;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.yd.oa.model.Product;

public class ProductDao {
	//依赖比继承相对灵活一些,应该通过set方法赋值
	private JdbcTemplate jdbcTemplate=null;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//
	public void save(Product product) {
		String sql="insert into product (name,price,remark) values (?,?,?)";
		jdbcTemplate.update(sql,new Object[] {product.getName(),product.getPrice(),product.getRemark()});
	}
	public void save2(Product product) {
		String sql="insert into product (name,price,remark,date) values (?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getDate()});
	}
	
	public void update(Product product) {
		//?是占位符
		String sql="update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(sql,new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
	}
	
	public void delete(Integer id) {
		//?是占位符
		String sql="delete from product where id=?";
		jdbcTemplate.update(sql,new Object[] {id});
	}
	
	/*Spring提供的工具类BeanPropertyRowMapper，Bean和某一行有映射关系，这种映射关系通过指定Product.class完成。
	 * Product.class:E:\tomcat9\webapps\demo\WEB-INF\classes\cn\yd\oa\model\Product.class
	 * <Product>代表该对象待会儿返回Product类型。	 * 
	 */
	public Product getById(Integer id) {
		String sql="select * from product where id=?";
		return (Product) jdbcTemplate.queryForObject(sql, new Object[] {id},
				new BeanPropertyRowMapper<Product>(Product.class));
	}
	
	public List<Product> queryByName(String name){
		String sql="select * from product where name like ? ";
		return jdbcTemplate.query(sql, new Object[] {"%"+name+"%"}, 
				new BeanPropertyRowMapper<Product>(Product.class));
	}

}
