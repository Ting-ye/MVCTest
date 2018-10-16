<%--
  Created by IntelliJ IDEA.
  User: p13
  Date: 18/10/15
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="demo7" method="post">
    <%--<input type="text" name="username" />--%>
    <%--<input type="text" name="age" />--%>
    <%--<input type="checkbox" name="hover" value="吃饭"/>--%>
    <%--<input type="checkbox" name="hover" value="睡觉"/>--%>
    <%--<input type="checkbox" name="hover" value="快活"/>--%>
    <%--<input type="checkbox" name="hover" value="lol"/>--%>
      <input type="text" name="peo[0].name" />
      <input type="text" name="peo[0].age" />
      <input type="text" name="peo[1].name" />
      <input type="text" name="peo[1].age" />
      <input type="submit" value="提交" />
    <a href="demo8/在控制器中可以随意取名restful传值方式/111">提交</a>
  </form>

  <%--可以缺省前面的作用域--%>
  request:${requestScope.request}<br/>
  application:${applicationScope.application}<br/>
  session:${sessionScope.session}<br/>
  sessionParam:${sessionScope.sessionParam}<br/><hr/>
  map:${requestScope.map}<br/><hr/>
  model:${requestScope.model}<br/><hr/>
  mav:${mav}<br/><hr/>
  <a href="download?filename=a.txt">下载</a><br/><hr/>
  <form action="upload" enctype="multipart/form-data" method="post">
    姓名:<input type="text" name="name"/>
    上传文件:<input type="file" name="fileName"/>
    <input type="submit" value="提  交"/>
  </form>
  </body>
</html>
