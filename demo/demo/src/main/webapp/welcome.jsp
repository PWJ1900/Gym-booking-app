<%--
  Created by IntelliJ IDEA.
  User: 潘文杰
  Date: 2020/3/27
  Time: 22:06
  To change this template use File | Settings | File Templates.
  这个页面用来连接数据库
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>


</head>
<body background="/image/background6.jpg" style="text-align:center;background-repeat: no-repeat;background-size:100% 100%;background-attachment: fixed">
<font size=6>信息修改页面</font><br><br>
<form action="/jsp/jstdo" method="post">
    <font size=4>请输入姓名：</font>
    <input type="text" name="name" value="${Name}">
    <input type="submit" value="查询"><br>
    <table align="center" valign="middle">
        <tr><td>序列号：</td><td><input type="text" name="id" value=${id}  ></td></tr>
        <tr><td>姓名：</td><td><input type="text" name="Name"  value=${Name}  ></td></tr>
        <tr><td>性别：</td><td><input type="text" name="Gender" value=${Gender} ></td></tr>
        <tr><td> 预约违规值：</td><td><input type="text" name="Number" value=${Number}  ></td></tr>
        <tr><td>密码：</td><td><input type="text" name="Password" value=${Password}  ></td></tr>
        <tr><td>预约场地：</td><td><input type="text" name="appointedplace" value=${appointedplace} >
        <tr><td>预约到达时间：</td><td><input type="text" name="appointedtime" value=${appointedtime}  >
        <tr><td>提交时日期：</td><td><input type="text" name="date" value=${date}  ></td></tr>
        <tr><td>账号：</td><td><input type="text" name="IDcard" value=${IDcard}  ></td></tr>
        <tr><td>手机号：</td><td><input type="text" name="phonenumber" value=${phonenumber}  ></td></tr>
    </table>

    <button type="submit" formaction="/jsp/updateSQL">提交修改</button><br><br>
    <button type="submit" formaction="/jsp/deleteit">取消预约</button>


</form>


</body>
</html>
