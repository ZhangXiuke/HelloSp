<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
</head>
<body>
    <div>
        <h3 class="title"><span>图书管理</span></h3>       
        <table border="1" width="30%" class="tab">
            <tr>               
                <th>编号</th>
                <th>书名</th>                               
            </tr>
            <c:forEach var="u" items="${users}">
                <tr>                  
                    <td>${u.code}</td>
                    <td>${u.name}</td>                                   
                </tr>
            </c:forEach>
        </table>    
    </div>
</body>
</html>