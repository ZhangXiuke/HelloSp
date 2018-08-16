<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="format-detection" content="telephone=no" />
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-1.8.3.min.js"></script>
<title>猎鹰工品-首页</title>
</head>
<body>
<h2>Hello World!</h2>
<button id="js-export" type="button" class="btn btn-primary">导出Excel</button>

<script type="text/javascript">
		$("#js-export").click(function(){
			//alert("2222");
	    	window.location.href="<%=basePath%>Student/getStudents";
		});
</script>
<p>这是空间1的内容</p>
<p>这是空间2的内容</p>
<p>我希望是合并他们</p>
</body>
</html>
