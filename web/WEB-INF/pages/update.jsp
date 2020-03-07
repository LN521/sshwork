<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=path%>/car/updatecar" enctype="multipart/form-data" method="post">

    车辆名称:<input type="text" name="name" value="${c.name}">

    车辆类型:<select name="type">
    <option value="-1">请选择</option>
    <option value="1" <c:if test="${c.type ==1}">selected="selected"</c:if>>越野车</option>
    <option value="2" <c:if test="${c.type ==2}">selected="selected"</c:if>>轿车</option>
    <option value="3" <c:if test="${c.type ==3}">selected="selected"</c:if>>客车</option>
</select>
    车辆图片:
    <img src="<%=path%>/car/upload?filename=${c.img}">
    <input type="file" name="myFile">
    <input type="hidden" value="${c.img}">
    车辆制作时间:<input type="date" name="date" value="<fmt:formatDate value="${c.date}" pattern="yyyy-MM-dd"/> ">

   <input type="submit" value="修改">

</form>
</body>
</html>
