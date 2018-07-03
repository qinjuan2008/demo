package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

//@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    //JSP->Servlet->Service->Dao->DB
	private ProductService productService=new ProductService();
	
	//����Method=get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	//����Method=post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("save")) {
			Product product=new Product();
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setRemark(request.getParameter("remark"));		
			productService.save(product);
			response.sendRedirect(request.getContextPath()+"/query.jsp");//�µ�����(������+��ת)
		}else if (type.equals("query")) {
			String keyword=request.getParameter("keyword");
			HttpSession session=request.getSession();
			session.setAttribute("keyword", keyword);
			ArrayList<Product> arrayList=productService.queryByName(keyword);
			System.out.println(session.getAttribute("keyword"));
			request.setAttribute("arraylist", arrayList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}else if (type.equals("delete")) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			productService.delete(id);
			HttpSession session=request.getSession();
			String keyword=(String)session.getAttribute("keyword");
			//if(keyword==null) keyword="";
			System.out.println("keyword:"+keyword);
			//session.setAttribute("keyword", keyword);
			ArrayList<Product> arrayList=productService.queryByName(keyword);
			//System.out.println(arrayList.size());
			request.setAttribute("arraylist", arrayList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}else if (type.equals("update")) {
			System.out.println("�˹��ܺ���ʵ�֡�����");
		}
		//1:��ȡǰ������
		//2:����ҵ���߼�
		//3:���ؽ��ҳ��(���ؿͻ��˵���Ӧ:reponse)
		//��ת����ѯҳ��,��java���������е���Դ���ʶ�Ҫ�ӹ�������ʼ(query.jsp)
		
	}

}
