<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>发布商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="js/kit.js"></script>
<!--[if IE]>
		<script src="js/ieFix.js"></script>
		<![endif]-->
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-30210234-1' ]);
	_gaq.push([ '_trackPageview' ]);
	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
<script src="js/dom.js"></script>
<script src="js/form.js"></script>
<link rel="stylesheet" href="css/css.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/validator.css" />
<!--validator-->
<script src="js/validator.js"></script>
<script src="js/autowired.validator.js"></script>
<style>
table td {
	font-size: 19px;
}

label {
	cursor: pointer;
	margin-right: 1em;
}
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<h1>请发布商品</h1>
	<div id="regist-main">
		<form id="registForm" action="servlet/AddGoodsServlet" method="post">
			<ol>
				<li><label for="gname">标题： <span
						class="kitjs-validator" for="@uname"
						rules="[{notNull:true, message:'用户名不能为空'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="gname"
					data-valmsg-replace="true"></span> <input id="gname" name="gname"
					type="text" value=""></li>


				<li><label for="number">数量： <span
						class="kitjs-validator" for="@number"
						rules="[{notNull:true, message:'数量不能为零'},{,message'数量不能为零'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="number"
					data-valmsg-replace="true"></span> <input id="number" name="number"
					type="text" value=""></li>

				<li><label for="photo">图片URL： <span
						class="kitjs-validator" for="@photo"
						rules="[{notNull:true, message:'url不能为空'},{,mesnumber'url不能为空}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="photo"
					data-valmsg-replace="true"></span> <input id="photo" name="photo"
					type="text" value=""></li>
					
				<li><label for="price">价格： <span
						class="kitjs-validator" for="@price"
						rules="[{notNull:true, message:'密码不能为空'},{minLength:'6',message:'密码长度最短为6位'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="price"
					data-valmsg-replace="true"></span> <input id="price" name="price"
					type="text"></li>
					
					
				<li><label for="described">正文： <span
						class="kitjs-validator" for="@described"
						rules="[{notNull:true, message:'密码不能为空'},{minLength:'6',message:'密码长度最短为6位'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="described"
					data-valmsg-replace="true"></span> <input id="described" name="described"
					type="text"></li>
				
			</ol>
			<div class="registError"></div>
			<input type="submit" value="发布" class="btn-submit">
		</form>
	</div>
</body>
</html>