<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 2018/4/28
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>子书少卿之家</title>
    <meta charset="UTF-8">
    <style>
        body{background-color: #2D2D2D}
    </style>
</head>
<body>

    <form action="userLogin" method="post">
        <table>
            <tr>
                <td>登入名：</td>
                <td><input type="text" id="loginNameId" name="loginName" /> </td>
            </tr>
            <tr>
                <td>登入密码：</td>
                <td><input type="password" id="loginPassWordId" name="loginPassWord" /> </td>
            </tr>
            <tr>
                <td><input type="submit" value="登入" /></td>

            </tr>
        </table>

    </form>



</body>
</html>
