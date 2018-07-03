package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

public class ProductDao extends BaseDao{
	//
	public void save(Product product) {
		String sql="insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark()});
		
	}
	public void save2(Product product) {
		String sql="insert into product (name,price,remark,date) values (?,?,?,?)";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getDate()});
		
	}
	
	public void update(Product product) {
		//?是占位符
		String sql="update product set name=?,price=?,remark=? where id=?";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
		
	}
	
	public void delete(Integer id) {
		
		//?是占位符
		String sql="delete from product where id=?";		
		super.executeUpdate(sql, new Object[] {id});
		
	}
	
	public Product getById(Integer id) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = jdbcUtils.getConnection();
		String sql="select * from product where id=?";
		PreparedStatement pStatement;
		Product product=null;
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet resultSet=pStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRemark(resultSet.getString("remark"));
				product.setDate(resultSet.getDate("date"));
			}
			return product;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	
	}
	
	public ArrayList<Product> queryByName(String name){
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = jdbcUtils.getConnection();
		String sql="select * from product where name like ? ";
		PreparedStatement pStatement;
		ArrayList<Product> arrayList=new ArrayList<Product>();
		try {
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, "%"+name+"%");
			System.out.println(pStatement.toString());
			ResultSet resultSet=pStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setRemark(resultSet.getString("remark"));
				product.setDate(resultSet.getDate("date"));
				arrayList.add(product);
			}
			return arrayList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	

	}

}
