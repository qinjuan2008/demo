<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- JAVA代码生命，在JSP有3大内置对象用来存储数据：request session application 
     存储到application对象中的数据与项目的生命周期相同，如果项目重启则app数据消失:-->
<%
//request.setAttribute("req", "request");
//session.setAttribute("ses", "session");
//application.setAttribute("app", "application");
%>
<!-- 发送的是一个HTTP请求，ProductService是不能够识别的，需要一个中间 -->
<!-- 在项目中所有的请求都要从工程名开始 -->
	<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
		商品名:<input type="text" name="name" value="iphone"/><br /> 
		价格:<input type="text" name="price" value="2001.00" /><br /> 
		备注:<input type="text" name="remark" value="new iphone" /><br />
		<input type="submit" value="提交" />
		<input type="hidden" name="type" value="save"/>
	</form>

</body>
</html>