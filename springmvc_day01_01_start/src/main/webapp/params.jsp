<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/7
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--  请求参数绑定
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a> --%>
    <%--  将表单数据封装到bean
            get请求不会发生中文乱码，但post请求会发生中文乱码,解决方法是request.setCharacter,但每次都写很麻烦
            所以使用过滤器拦截请求并做处理，过滤器在web.xml声明

    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交" />
    </form>--%>
    <%--  将表单数据封装到Account类，类中存在List和map的集合
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="list[0].uname" /><br/>
        用户年龄：<input type="text" name="list[0].age" /><br/>
        用户姓名：<input type="text" name="map['one'].uname" /><br/>
        用户年龄：<input type="text" name="map['one'].age" /><br/>
        <input type="submit" value="提交" />
    </form> --%>

    <%--  自定义类型转换器
    <form action="param/saveUser" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        用户生日：<input type="text" name="date" /><br/>
        <input type="submit" value="提交" />
    </form>
    --%>
    <a href="param/testServlet">Servlet原生的API</a>

</body>
</html>
