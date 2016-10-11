<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
<%
	Vector rows=(Vector)request.getAttribute("product");
%>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
			
		<div id="left_column">
			<jsp:include page="left_column.jsp" />  
		</div>
			
		<div id="center_column">		
			<div class="divBorder">
				<img src="images/all_fans.gif" /><br>
			
			<%
				for(int i=0;i<rows.size();i++){
					Vector row=(Vector)rows.get(i); //读取一条记录 
					%>
					<div id='sort_product'>
						<ul>
							<li><p class='gpic'><a href='HandleItem?pid=<%=row.get(0) %>'><img width='205' height='154' src="<%=row.get(3) %>"></a></p></li> 
							<li><p class='gbt'><a href='HandleItem?pid=<%=row.get(0) %>'>品名：<%=row.get(1) %> </a></p></li>
							<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥18元</p></li>
							<li><p class='gsale'>已售出：<span style='font-weight:bold;'>86</span>&nbsp;笔</p></li>
						</ul>
					</div>					
					<%
				}			
			%>
				
				<!-- <div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='item.jsp'><img width='205' height='154' src="Picture/1.jpg"></a></p></li> 
						<li><p class='gbt'><a href='item.jsp'>品名：油漆边双色龙骨扇_粉色 </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥18元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'>86</span>&nbsp;笔</p></li>
					</ul>
				</div>
				<div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='item.jsp'><img width='205' height='154' src="Picture/2.jpg"></a></p></li> 
						<li><p class='gbt'><a href='item.jsp'>品名：油漆边双色龙骨扇_红色 </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥18元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'>14</span>&nbsp;笔</p></li>
					</ul>
				</div>
				<div id='sort_product'>	
					<ul>
						<li><p class='gpic'><a href='item.jsp'><img width='205' height='154' src="Picture/3.jpg"></a></p></li> 
						<li><p class='gbt'><a href='item.jsp'>品名：油漆边双色龙骨扇_蓝色 </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥18元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'>87</span>&nbsp;笔</p></li>
					</ul>
				</div>
				<div id='sort_product'>
					<ul>
						<li><p class='gpic'><a href='item.jsp'><img width='205' height='154' src="Picture/4.jpg"></a></p></li> 
						<li><p class='gbt'><a href='item.jsp'>品名：油漆边双色龙骨扇_紫色 </a></p></li>
						<li><p class='gprice'>促销价：<span style="color:#FF6600;font-weight:bold;"></span>￥16元</p></li>
						<li><p class='gsale'>已售出：<span style='font-weight:bold;'>13</span>&nbsp;笔</p></li>
					</ul>
				</div> -->
				</div>	
				
				<div id='page_next'><a class="pageLink" href="">上一页</a>&nbsp;<a class="pageLink" href="">下一页</a>&nbsp;</div>   	
			</div>
					
		<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
		
	</div>
</body>
</html>