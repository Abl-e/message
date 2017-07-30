<%--
  User: 唐国翔
  Date: 2017/7/28
  Time: 20:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
    <a style="text-align: center" href="<%=basePath%>list">列表</a>
</body>
</html>
