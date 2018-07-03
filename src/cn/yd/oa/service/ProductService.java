package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

////ʵ��ҵ���߼�
public class ProductService {
	//ҵ���߼�����ɹ���֮�����ݽ���⣬��˽�����DAO��
	private ProductDao productDao=null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao=productDao;
	}
	
	public void save(Product product) {
		productDao.save(product);
		//�����־
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
