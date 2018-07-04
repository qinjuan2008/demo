package cn.yd.oa.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;


@Component(value="pc")
@RequestMapping("/product")//访问当前Controller的地址  /工程名/product
public class ProductController {
	///MVC Controller支持 request session application自动注入到Controller中
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private HttpSession session;
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
	public String delete(Integer id) {
		productService.delete(id);
		String keyword=(String) session.getAttribute("keyword");
		request.setAttribute("arraylist", productService.queryByName(keyword));
		return "forward:/query.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/query")
	public String queryByname(String keyword) {
		ArrayList<Product> arrayList=productService.queryByName(keyword);
		request.setAttribute("arraylist", arrayList);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
	}
	
	@RequestMapping("/getById")
	public String getById(Integer id) {
		Product product=productService.getById(id);
		request.setAttribute("product", product);
		///
		return "forward:/update.jsp";
	}

}
