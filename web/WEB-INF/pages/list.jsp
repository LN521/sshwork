<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
       function toadd() {
           location.href="<%=path%>/car/toadd";
       }
       function change1() {
           var  boxs=$("[name=box]")

           $(boxs).each(function (index,element) {

               var  b=$(element).prop("checked");

               $(element).prop("checked",!b);
           })
       }

       function  deletebyids() {
           var  boxs=$("[name=box]");
           var  path="";
           $(boxs).each(function (index,element) {
                if ($(element).prop("checked")){
                    path+=","+$(element).val();
                }

           })
           path=path.substring(1,path.length);
           location.href="<%=path%>/car/deletebyids?ids="+path;
       }
    </script>
</head>
 <body>
    <form action="<%=path%>/car/findinfo" method="post">
        车名：<input type="text" name="name" value="${car.name}">
        车类型：<select name="type">
                  <option value="-1">请选择</option>
                  <option value="1" <c:if test="${car.type==1}">selected="selected"</c:if>>越野车</option>
                  <option value="2" <c:if test="${car.type==2}">selected="selected"</c:if>>轿车</option>
                  <option value="3" <c:if test="${car.type==3}">selected="selected"</c:if>>客车</option>
    </select>

        创建日期初始范围 <input type="date" name="starttime" value="<fmt:formatDate value="${car.starttime }" pattern="yyyy-MM-dd"/>">
        商品创建日期最大范围<input type="date" name="endtime" value="<fmt:formatDate value="${car.endtime }" pattern="yyyy-MM-dd"/>" >

        <input type="submit" value="搜索">
    </form>

    <table border="1" width="100%">
        <tr>
             <td><input type="button" value="增加" onclick="toadd()"></td>
            <td><input type="button" value="多选删除" onclick="deletebyids()"> </td>
        </tr>
        <tr>
            <th><input type="checkbox" onchange="change1()"></th>
            <th>车辆名称</th>
            <th>车辆分类</th>
            <th>车辆图片</th>
            <th>车辆制作日期</th>
            <th>操作</th>
        </tr>
        <c:if test="${not empty pb.result}">
            <c:forEach items="${pb.result}" var="c">

                <tr>
                    <td><input type="checkbox" name="box" value="${c.id}"> </td>
                    <td>${c.name}</td>
                    <td>${c.type}
                        <c:if test="${c.type==1}">越野车</c:if>
                        <c:if test="${c.type==2}">轿车车</c:if>
                        <c:if test="${c.type==3}">客车</c:if>
                    </td>
                    <td>
                        <img src="<%=path%>/car/upload?filename=${c.img}">
                    </td>
                    <td>${c.date}</td>
                    <td>
                        <a href="<%=path%>/car/findone?id=${c.id}">修改</a>
                        <a href="<%=path%>/car/deleteone?id=${c.id}">删除</a>
                    </td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="5">
                    <c:if test="${pb.pageNumber >1}">
                        <a href="<%=request.getContextPath()%>/car/findinfo?type=${car.type}&name=${car.name}&endtime=<fmt:formatDate value="${car.endtime }" pattern="yyyy-MM-dd"/>&starttime=<fmt:formatDate value="${car.starttime}" pattern="yyyy-MM-dd" />&pageNumber=${pb.pageNumber-1}">上一页</a>
                    </c:if>

                    <c:forEach begin="1" end="${pb.pageNumber}" var="i">
                        <a href="<%=request.getContextPath()%>/car/findinfo?type=${car.type}&name=${car.name}&endtime=<fmt:formatDate value="${car.endtime }" pattern="yyyy-MM-dd"/>&starttime=<fmt:formatDate value="${car.starttime}" pattern="yyyy-MM-dd" />&pageNumber=${i}">${i}</a>
                    </c:forEach>

                    <c:if test="${pb.totalPage < pb.pageNumber }">
                        <a href="<%=request.getContextPath()%>/car/findinfo?type=${car.type}&name=${car.name}&endtime=<fmt:formatDate value="${car.endtime }" pattern="yyyy-MM-dd"/>&starttime=<fmt:formatDate value="${car.starttime}" pattern="yyyy-MM-dd" />&pageNumber=${pb.pageNumber+ 1}">下一页</a>
                    </c:if>
                </td>


            </tr>


        </c:if>




    </table>
</body>
</html>
