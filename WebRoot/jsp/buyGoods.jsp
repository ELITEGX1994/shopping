<%@page import="netease.gx.factory.DAOFactory"%>
<%@page import="netease.gx.dao.ShoppingCartDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String uid = String.valueOf(session.getAttribute("uid"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>支付商品</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
	<%		
		ShoppingCartDao scDao = DAOFactory.getShoppingCartServiceInstance();
		if(uid==null){
			out.print("uid为空");
		}else{
			if (scDao.payAllGoods(Integer.parseInt(uid))) {
			//	if (scDao.payAllGoods(6)) {
				response.sendRedirect("alreadyBuy.jsp");
			} else {
		%>
		支付失败，请重试。
		<%
			}
		}
	%>
</body>
</html>