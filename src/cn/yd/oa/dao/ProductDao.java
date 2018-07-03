package cn.yd.oa.dao;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.yd.oa.model.Product;

public class ProductDao {
	//�����ȼ̳�������һЩ,Ӧ��ͨ��set������ֵ
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
		//?��ռλ��
		String sql="update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(sql,new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
	}
	
	public void delete(Integer id) {
		//?��ռλ��
		String sql="delete from product where id=?";
		jdbcTemplate.update(sql,new Object[] {id});
	}
	
	/*Spring�ṩ�Ĺ�����BeanPropertyRowMapper��Bean��ĳһ����ӳ���ϵ������ӳ���ϵͨ��ָ��Product.class��ɡ�
	 * Product.class:E:\tomcat9\webapps\demo\WEB-INF\classes\cn\yd\oa\model\Product.class
	 * <Product>����ö�����������Product���͡�	 * 
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
