<%@page import="netease.gx.bean.AlreadyBuy"%>
<%@page import="netease.gx.dao.AlreadyBuyDao"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="netease.gx.dao.GoodsDao"%>
<%@ page import="netease.gx.bean.Goods"%>
<%@ page import="netease.gx.factory.DAOFactory"%>
<%@ page import="java.util.List"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	String uname = (String) session.getAttribute("uname");
	String uid = String.valueOf(session.getAttribute("uid"));
	int id;
	if(uid.equals(null)){id =15;}else{id = Integer.parseInt(uid);}
	
%>
<!DOCTYPE html>
<html>
<head>
<title>购物</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>
</head>
<body>
	<jsp:include page="jsp/head.jsp"></jsp:include>
	<!--content-->
	<div class="content">
		<div class="container">
			<div class="content-top">
				<%
				    AlreadyBuyDao alreadyBuyDao = DAOFactory.getAlreadyBuyServiceInstance();
					GoodsDao dao = DAOFactory.getGoodsServiceInstance();
					List<Goods> glist = dao.getAllGoods();
					//List<AlreadyBuy> alreadyBuyList = alreadyBuyDao.getAllBuyGoods(Integer.parseInt(uid));
					List<AlreadyBuy> alreadyBuyList = alreadyBuyDao.getAllBuyGoods(id);
					if (glist != null && glist.size() > 0) {
						for (int i = 0; i < glist.size(); i++) {
							if (i % 4 == 0) {
				%>
				<div class="content-top1">
					<%
						}
					%>
					
					<tr></tr>
					<tr></tr>
					<div class="col-md-3 col-md2">
						<div class="col-md1 simpleCart_shelfItem">
							<a
								href="jsp/goodsDescribed.jsp?gid=<%=glist.get(i).getGid()%>"
								target="_blank">
							 <%
							Goods goodNow = glist.get(i);
							int gid = goodNow.getGid();
							String name = goodNow.getGname();
 							String imgPath = "images/" + goodNow.getGname()+ "1.jpg";
 							float price = goodNow.getPrice();
 							//boolean flag = alreadyBuyDao.ifInAlreadyBuyList(gid,Integer.parseInt(uid));
 							boolean flag = alreadyBuyDao.ifInAlreadyBuyList(gid,id);
 							%>
 							 <img src=<%=imgPath%> height=208 weight = 208 alt="此图片无法显示" />
 							 <%if(flag&&uname!=null&&uid!=null){
 								 if(uname.equals("seller")){
 								 out.print("已售出");
 								 }else{
 									 out.print("已购买");
 								 }
 							 } %>
 							 
							</a>
							<h3>
								<a
									href="jsp/goodsDescribed.jsp?gid=<%=gid%>"
									target="_blank"><%=name%></a>
							</h3>
							<div class="price">
								<h5 class="item_price"><%=price%>元
								</h5>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<%
						if (i % 4 == 3) {
					%>
					<div class="clearfix"></div>
				</div>
				<%
					}
						}
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>