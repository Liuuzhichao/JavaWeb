<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!-- 可以不加 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"><!-- 可以不加 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 直接操作与某些JSP对象绑定在一起的参数或者Java对象。--%>
	<%
		pageContext.setAttribute("userName", "A",
				pageContext.APPLICATION_SCOPE);
		pageContext
				.setAttribute("userName", "B", pageContext.SESSION_SCOPE);
		pageContext
				.setAttribute("userName", "C", pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("userName", "D", pageContext.PAGE_SCOPE);

		out.println(pageContext.getAttribute("userName",
				pageContext.APPLICATION_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.SESSION_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.REQUEST_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.PAGE_SCOPE) + "<br/><br/>");

		out.println("<hr/>");

		out.println(application.getAttribute("userName") + "<br/>");
		out.println(session.getAttribute("userName") + "<br/>");
		out.println(request.getAttribute("userName") + "<br/>");
		out.println(pageContext.getAttribute("userName") + "<br/>");
		out.println("<br/>");

		/* 取最近范围的scope的值 */
		out.println(pageContext.getAttributesScope("userName")
				+ "<br/><br/>");

		/* 取最近范围的username的值 */
		out.println(pageContext.findAttribute("userName") + "<br/><br/>");

		pageContext.removeAttribute("userName",
				pageContext.APPLICATION_SCOPE);
		pageContext.removeAttribute("userName", pageContext.SESSION_SCOPE);

		out.println(pageContext.getAttribute("userName",
				pageContext.APPLICATION_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.SESSION_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.REQUEST_SCOPE) + "<br/>");
		out.println(pageContext.getAttribute("userName",
				pageContext.PAGE_SCOPE) + "<br/><br/>");

		pageContext.setAttribute("password", "123",
				pageContext.REQUEST_SCOPE);
		request.setAttribute("age", 23);
		Enumeration<String> em = null;
		em = pageContext
				.getAttributeNamesInScope(pageContext.REQUEST_SCOPE);

		while (em.hasMoreElements()) {
			String name = em.nextElement();
			out.println("name--->" + name + "<br/>");
			out.println("value--->" + request.getAttribute(name) + "<br/>");
		}
		// pageContext.release();
	%>

</body>
</html>