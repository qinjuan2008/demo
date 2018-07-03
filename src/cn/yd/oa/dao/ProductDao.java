package cn.yd.oa.dao;

import java.util.ArrayList;

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
	
	public Product getById(Integer id) {
//		JdbcUtils jdbcUtils = new JdbcUtils();
//		Connection conn = jdbcUtils.getConnection();
//		String sql="select * from product where id=?";
//		PreparedStatement pStatement;
//		Product product=null;
//		try {
//			pStatement = conn.prepareStatement(sql);
//			pStatement.setInt(1, id);
//			ResultSet resultSet=pStatement.executeQuery();
//			if(resultSet.next()) {
//				product=new Product();
//				product.setId(resultSet.getInt("id"));
//				product.setName(resultSet.getString("name"));
//				product.setPrice(resultSet.getDouble("price"));
//				product.setRemark(resultSet.getString("remark"));
//				product.setDate(resultSet.getDate("date"));
//			}
//			return product;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}	finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}	
		return null;
	}
	
	public ArrayList<Product> queryByName(String name){
		
//		
//		JdbcUtils jdbcUtils = new JdbcUtils();
//		Connection conn = jdbcUtils.getConnection();
//		String sql="select * from product where name like ? ";
//		PreparedStatement pStatement;
//		ArrayList<Product> arrayList=new ArrayList<Product>();
//		try {
//			pStatement = conn.prepareStatement(sql);
//			pStatement.setString(1, "%"+name+"%");
//			System.out.println(pStatement.toString());
//			ResultSet resultSet=pStatement.executeQuery();
//			while(resultSet.next()) {
//				Product product=new Product();
//				product.setId(resultSet.getInt("id"));
//				product.setName(resultSet.getString("name"));
//				product.setPrice(resultSet.getDouble("price"));
//				product.setRemark(resultSet.getString("remark"));
//				product.setDate(resultSet.getDate("date"));
//				arrayList.add(product);
//			}
//			return arrayList;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}	finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}	
		return null;
	}

}
