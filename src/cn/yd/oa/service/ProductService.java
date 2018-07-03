package cn.yd.oa.service;

import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

////实现业务逻辑
public class ProductService {
	//业务逻辑层完成功能之后数据将入库，因此将依赖DAO层
	private ProductDao productDao=new ProductDao();
	
	public void save(Product product) {
		productDao.save(product);
	}
	
	public ArrayList<Product> queryByName(String keyword){
		return productDao.queryByName(keyword);
	}
	
	public void delete(Integer id) {
		productDao.delete(id);
	}
}
