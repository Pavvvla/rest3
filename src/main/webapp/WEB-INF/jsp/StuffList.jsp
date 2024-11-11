<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 11.11.2024
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<%@include file="head.jsp"%>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout__fixed-header">
    <%@include file="menu.jsp"%>
    <main class="mdl-layout__content">
        <div class="mdl-grid center-items">
            <div class="mdl-cell--4-col">
                <div>
                    <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                        <thead>
                        <tr>
                            <th class="mdl-data-table__cell--non-numeric">NO</th>
                            <th>NAME</th>
                            <th>ARTICLE</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="stuff" items="${listStuff}">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <tr>
                            <td class="mdl-data-table__cell--non-numeric">
                                <c:out value="${count}"</td>
                            <td><c:out value="${Article.article}"/></td>
                            <td><c:out value="${Article.name}"/></td>
                            <td><a href="" </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</main>
</div>
</body>
</html>
