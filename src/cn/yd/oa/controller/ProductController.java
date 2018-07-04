package cn.yd.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;


@Component(value="pc")
@RequestMapping("/product")//访问当前Controller的地址  /工程名/product
public class ProductController {
	//如果采用注解的方式,则不需要些SET方法
	@Resource(name="ps")
	private ProductService productService;
	
	//JSP--> Controller --> service--> productDao --> jdbcTemplate --> dataSource --> db
	//servlet只提供了doGet,doPost，而Controller为每个请求都指定方法
	//mvc支持自动赋值，前提是前端文本框name属性的值和Product属性匹配
	//<input type="text" name="price"/>==>Product的Price
	@RequestMapping("/save")  // /工程名/product/save.mvc  (mvc在web.xml配置中的约定)
	public String save(Product product) {
		productService.save(product);
		return "redirect:/query.jsp";//在MVC中无论是转发还是重定向都默认添加了工程名
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		
	}

}
