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
@RequestMapping("/product")//���ʵ�ǰController�ĵ�ַ  /������/product
public class ProductController {
	///MVC Controller֧�� request session application�Զ�ע�뵽Controller��
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private HttpSession session;
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
