<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello btn");
                $.ajax({
                    //编写json格式
                    url:"user/testAjax",
                    contentType:"application/json;character=utf-8",
                    data:'{"username":"hehe","password":"123","age":"26"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data是服务器响应的json的数据，可进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>

    <br/>
    <a href="user/testVoid">testVoid</a>

    <br/>
    <a href="user/testModelAndView">testModelAndView</a>
    <br/>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br/>

    <button id="btn">发送Ajax请求</button>
</body>
</html>
