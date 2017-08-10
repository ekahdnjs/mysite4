<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<% pageContext.setAttribute( "newLine", "\n" ); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<title>방명록</title>
</head>
<body>

<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">

					<form action="${pageContext.request.contextPath }/guestbook/add"
						method="post">
						<input type="hidden" name="a" value="add">
						<table border="1" width="500">
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>
					</form>
					<ul>

						<c:forEach items="${list }" var="vo">
							<li>
								<table border="1" width="500">
									<tr>
										<td>[${vo.no }]</td>
										<td>${vo.name }</td>
										<td>${vo.regDate }</td>
										<td><a href="${pageContext.request.contextPath }/guestbook/deleteform?no=${vo.no }">삭제</a></td>
									</tr>
									<tr>
										<td colspan=4>${fn:replace(vo.content, newLine, "<br>")}</td>
									</tr>
								</table> <br>
							</li>
						</c:forEach>
					</ul>

				</div>
				<!-- /guestbook -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div><!-- /container -->
		
</body>
</html>