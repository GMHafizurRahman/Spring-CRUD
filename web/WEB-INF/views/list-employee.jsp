<%-- 
    Document   : list-employee
    Created on : Jan 13, 2020, 12:35:44 PM
    Author     : Hafuzur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td{
                padding: 10px; color: blue;
            }
        </style>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Employee List:</h1>
        <table border="1" style="border-collapse: collapse; padding: 20px">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Age</th>
                    <th>Phone Number</th>                  
                    <th>Record Manipulation</th>                                   
                </tr>
            </thead>
            <c:forEach var="e" items="${empList}">
                <tbody style=" padding: 10px">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.address}</td>
                        <td>${e.age}</td>
                        <td>${e.conNumber}</td>
                        <td style=" text-align: center">
                            <a href="edit_employee?id=${e.id}">Edit</a>&nbsp; | &nbsp;
                            <a href="delete_employee?id=${e.id}">Delete</a>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </body>
</html>
