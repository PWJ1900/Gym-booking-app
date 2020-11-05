<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/27
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Title</title>

</head>
<body background="/image/background6.jpg" style="text-align:center;background-repeat: no-repeat;background-size:100% 100%;background-attachment: fixed" >
<form action="/jsp/register" method="post">
<%--<input type="text" name="name">--%>
<%--<input type="text" name="Same">--%>
          <input style="height: 30px;width: 200px;background: aqua;text-decoration-color: burlywood" type = "submit" value="刷新"><br><br>
    <font size="20" color="#5f9ea0">查看预约信息</font>
    <font size="20" color="#5f9ea0">健身房预约情况</font><br><br>
    <img src="/image/yujia.jpg" alt="瑜伽房" style="height: 300px;width: 600px"><br>

    <font size=5> 瑜伽房预约数： ${瑜伽房}</font><br><br>
    <img src="/image/swim.jpg" alt="瑜伽房" style="height: 300px;width: 600px"><br>
    <font size=5>游泳馆预约数： ${游泳馆}</font><br><br>
    <img src="/image/bsb.jpg" alt="瑜伽房" style="height: 300px;width: 600px"><br>
    <font size=5>篮球场预约数： ${篮球场}</font><br><br>
    <img src="/image/qicai.jpg" alt="瑜伽房" style="height: 300px;width: 600px"><br>
    <font size=5>器材室预约数： ${器材室}</font><br><br>

</form>
<form action="/signin" method="post">
    <font size=4>用户打卡</font><br>

    <Script Language="JavaScript">

        function borderColor(){
            if(self['oText'].style.borderColor=='red'){
                self['oText'].style.borderColor = 'yellow';
            }else{
                self['oText'].style.borderColor = 'red';
            }
            oTime = setTimeout('borderColor()',400);
        }

    </Script>
    <input type="text" name="arrive" value="" style="width: 350px;border: 5px dotted blue;color:burlywood" onfocus="borderColor(this);"><br><br>
    <input style="height: 30px;width: 200px;background: aqua;text-decoration-color: burlywood"type="submit" value = "点击打卡"><br>
    ${打卡}<br>
<%--    <%  String abc = "";--%>
<%--        if(request.getParameter("arrive")==null)--%>
<%--            abc = "";--%>
<%--        else if("你好".equals(request.getParameter("arrive"))){//此处写查询到数据库的姓名值--%>
<%--            abc = "打卡成功！";}--%>
<%--        else--%>
<%--            abc = "打开失败";--%>
<%--              %>--%>
<%--    <%=abc%><br>--%>

</form>
<form action="/welcome" method="post">
    <input style="height: 30px;width: 200px;background: aqua;text-decoration-color: burlywood"type="submit" name="" value="点击修改用户信息">



</form>
</body>
</html>
