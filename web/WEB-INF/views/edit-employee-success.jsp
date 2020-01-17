<%-- 
    Document   : edit-employee-success
    Created on : Jan 13, 2020, 12:35:06 PM
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
                border-collapse: collapse;
                padding: 5px;   
            }
        </style>
    </head>
    <body>

        <div>Edit Employee</div>
        <!--    <c:forEach var="e" items="$ {empListE}">
                $ {e.id}
        </c:forEach>-->
        <a href="index.html">Home</a>
        <h1>Employee List:</h1>


        <form method="POST" action="SaveEdit">        

            <table border="2" style="border-collapse: collapse; padding: 30px;">

                <c:forEach var="e" items="${empListE}">
                    <tbody>                   
                        <tr>
                            <td>Id</td>
                            <td><input type="hidden" name="id"  value="${e.id}" > </td>                           
                        </tr> 
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name" value="${e.name}"/></td>

                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="address" value="${e.address}"/></td>

                        </tr>
                        <tr>
                            <td>Age</td>
                            <td><input type="number" name="age" value="${e.age}"/></td>

                        </tr>
                        <tr>
                            <td>Contact Number</td>
                            <td><input type="text" name="conNumber" value="${e.conNumber}"/></td> 
                        </tr>
                    </tbody>
                </c:forEach>
            </table><br/>
            <input type="submit" value="Save"/>

        </form>
    </body>
</html>
