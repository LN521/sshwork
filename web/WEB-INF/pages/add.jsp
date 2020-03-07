<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="<%=path%>/car/addcar" enctype="multipart/form-data" method="post">

       车辆名称:<input type="text" name="name">

       车辆类型:<select name="type">
                <option value="-1">请选择</option>
                <option value="1">越野车</option>
                <option value="2">轿车</option>
                <option value="3">客车</option>
               </select>
       车辆图片:<input type="file" name="myFile">

       车辆制作时间:<input type="date" name="date">


       <input type="submit" value="增加">

   </form>
</body>
</html>
