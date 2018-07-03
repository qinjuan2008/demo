package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

////实现业务逻辑
public class ProductService {
	//业务逻辑层完成功能之后数据将入库，因此将依赖DAO层
	private ProductDao productDao=null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao=productDao;
	}
	
	public void save(Product product) {
		productDao.save(product);
		//添加日志
		Integer.parseInt("abddfg");
		
	}
	
	public ArrayList<Product> queryByName(String keyword){
		return (ArrayList<Product>) productDao.queryByName(keyword);
	}
	public Product getById(Integer id) {
		return productDao.getById(id);
	}
	
	public void delete(Integer id) {
		productDao.delete(id);
	}
}
