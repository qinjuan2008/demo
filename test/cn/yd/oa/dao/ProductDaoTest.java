package cn.yd.oa.dao;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

public class ProductDaoTest {

	private static ProductService productService;
	private static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前运行，通常用来初始化测试对象");
		//productDao=new ProductDao();
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-bean.xml");
		productService=context.getBean("ps",ProductService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("此方法在测试方法之后运行，通常用来释放资源");
		productService=null;
	}

	@Test
	public void testSave() {
		System.out.println("testSave...");
		Product product=new Product();
		product.setName("xiaomi");
		product.setPrice(3600.00);
		product.setRemark("huawei new...");
		productService.save(product);
	}

//	@Test
//	public void testUpdate() {
//		fail("dfsdf");
//		Product product2=new Product(1,"小米手机2",1600.0,"小米新款手机2");
//		productService.update(product2);
//	}

	@Test
	public void testDelete() {
		productService.delete(2);
	}
	
	@Test
	public void testGetById() {
		Product product=(Product) productService.getById(13);		
		System.out.println(product.toString());
	}
	
	@Test
	public void testQuerybyName() {
		ArrayList<Product> arrayList=(ArrayList<Product>)productService.queryByName("小米");
		for (Product product : arrayList) {
			System.out.println(product.toString());
		}
		
	}

	
}
