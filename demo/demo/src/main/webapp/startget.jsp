<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/9
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body background="/image/background6.jpg" style="text-align:center;background-repeat: no-repeat;background-size:100% 100%;background-attachment: fixed">

<form action="/adminlogin" method="post">
<font size=6>管理员登录页面</font><br><br>
<font size=3>账号:</font><input type="text" name="account"><br>
<font size=3>密码:</font><input type="text" name="password"><br>

<input type="submit"  value="登录"><br></form>
${display}

</body>
</html>
