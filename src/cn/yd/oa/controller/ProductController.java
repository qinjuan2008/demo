package cn.yd.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;


@Component(value="pc")
@RequestMapping("/product")//���ʵ�ǰController�ĵ�ַ  /������/product
public class ProductController {
	//�������ע��ķ�ʽ,����ҪЩSET����
	@Resource(name="ps")
	private ProductService productService;
	
	//JSP--> Controller --> service--> productDao --> jdbcTemplate --> dataSource --> db
	//servletֻ�ṩ��doGet,doPost����ControllerΪÿ������ָ������
	//mvc֧���Զ���ֵ��ǰ����ǰ���ı���name���Ե�ֵ��Product����ƥ��
	//<input type="text" name="price"/>==>Product��Price
	@RequestMapping("/save")  // /������/product/save.mvc  (mvc��web.xml�����е�Լ��)
	public String save(Product product) {
		productService.save(product);
		return "redirect:/query.jsp";//��MVC��������ת�������ض���Ĭ������˹�����
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		
	}

}
