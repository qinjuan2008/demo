package cn.yd.oa.service;

import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

////ʵ��ҵ���߼�
public class ProductService {
	//ҵ���߼�����ɹ���֮�����ݽ���⣬��˽�����DAO��
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
