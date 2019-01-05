<%@page import="netease.gx.bean.AlreadyBuy"%>
<%@page import="netease.gx.dao.AlreadyBuyDao"%>
<%@page import="netease.gx.bean.Goods"%>
<%@page import="netease.gx.dao.GoodsDao"%>
<%@page import="netease.gx.service.GoodsService"%>
<%@page import="netease.gx.bean.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="netease.gx.factory.DAOFactory"%>
<%@page import="netease.gx.dao.ShoppingCartDao"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>账务</title>
<!--  
<style type="text/css">
	#text{
		width:200px;
		height:200px;
		background:url(imgPath);
		background-size:200px 200px;
	}
	img{
		width:199px;
		height:199px;
		border:1px solid red;
	}
</style>
-->
<style type="text/css">
	span{
		positon:absolute;
		left:200px;
		color:#fff;
		font:50px/350px;
	}
</style>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/memenu.js"></script>
<script type="text/javascript" src="js/simpleCart.min.js"></script>
<script type="text/javascript">
	function confirmBuy() {
		return confirm("是否支付订单吗？");
	}
</script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="check-out">
			<h1>购买历史</h1>
			<table>
				<tr>
					<th>标题</th>
					<th>图片</th>
					<th>购买时间</th>
					<th>价格</th>
					<th>数量</th>
				</tr>
				<%
					String strUid = (String) session.getAttribute("uid");
					int uid = 0;
					if (strUid != null) {
						uid = Integer.parseInt(strUid);
					}
					AlreadyBuyDao dao = DAOFactory.getAlreadyBuyServiceInstance();
					List<AlreadyBuy> abList = dao.getAllBuyGoods(uid);
					if (abList != null & abList.size() > 0) {
						GoodsDao goodsDao = DAOFactory.getGoodsServiceInstance();
						Goods goods;
						AlreadyBuy ab;
						int gid;
						int number;
						String buyTime;
						String imgPath;
						float price;
						float totalPrice;
						for (int i = 0; i < abList.size(); i++) {
							ab = abList.get(i);
							gid = ab.getGid();
							number = ab.getNumber();
							buyTime = ab.getBuyTime();
							goods = goodsDao.queryById(gid);
							imgPath = "images/" + goods.getPhoto().split("&")[0];
							price = goods.getPrice();
							totalPrice = number * price + goods.getCarriage();
				%>
				<tr>
				<td><%=goods.getGname()%></td>
				<!-- <td><div>
					<div style=""postion:relative">
					<img src=<%=imgPath%> width=100 height=100/>
					<div style="position:absolute;z-index:2;left:10px;top:10px">
					<span><b>已购买</b></span>
					</div>
				</div>
				</div></td> -->
				<!-- <td>
					<div style="background:url(<%=imgPath%>) repeat-no:width">
					已购买
					</div>
				</td> -->
				<td>
				<img src=<%=imgPath %> width=200;heigth=200>
				<span>asdasdasd</span>
				</td>
					
					<!-- <div class="clearfix"></div></td> -->
					<td><%=buyTime%></td>
					<td><%=price%>元</td>
					<td><%=number%></td>
					
					
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>