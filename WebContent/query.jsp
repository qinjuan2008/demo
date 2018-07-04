<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/product/query.mvc" method="get">
		搜索关键字:<input type="text" name="keyword" value="iphone"/><br /> 
		<input type="submit" value="给我搜" />
	</form>
	<table border=1>
	<tr>
	<th>编号</th>
	<th>名称</th>
	<th>价格</th>
	<th>备注</th>
	<th>日期</th>
	</tr>
	<c:forEach items="${requestScope.arraylist}" var="p">
	<tr>
	<td>${p.id}</td>
	<td>${p.name}</td>
	<td>${p.price}</td>
	<td>${p.remark}</td>
	<td>${p.date}</td>
	<td><a href="${pageContext.request.contextPath}/product/getById.mvc?id=${p.id}">更新|<a href="${pageContext.request.contextPath}/product/delete.mvc?id=${p.id}">删除</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>