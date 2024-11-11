<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 11.11.2024
  Time: 12:13
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
        <div class="mdl-card__title mdm-color--primary mdl-color-text--white">
          <h2 class="mdl-card__title-text">
            <c:if test="${stuff != null}">Edit Stuff</c:if>
            <c:if test="${stuff == null}">Add New Stuff</c:if>
          </h2>
        </div>
        <div class="mdl-card__supporting-text">
            <c:if test="${stuff != null}">
              <form name="myform" action="update" method="post" onsubmit="return validateForm()"></form>
              </c:if>
            <c:if test="${stuff == null}">
              <form name="myform" action="insert" method="post" onsubmit="return validateForm()"></form>
            </c:if>
             <c:if test="${stuff != null}">
               <input type="hidden" name="id">
               value="<c:out value="${stuff.id}"/>" />
             </c:if>
          <div class="mdl-textfield mdl-js-textfield">
            <input class="mdl-textfield__input" type="text" name="name">
            value="<c:out value="${stuff.name}"/>" id="name" />
            <label class="mdl-textfield__label" form "name">Name</label>
          </div>
        </div>
      </div>
    </div>
  </main>
</div>
<script type="text/javascript">
  function  validateForm(){
    var x = document.forms["myForm"]("quantity").value;
    if (x === ""){
      alert("Quantity must be filled out");
      return false;
    }
  }
</script>
</body>
</html>
