<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/materialize.min.css"/>"
	type="text/css" rel="stylesheet" media="screen,projection">
<link href="<c:url value="/resources/css/style.css"/>"
	type="text/css" rel="stylesheet" media="screen,projection">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>End Tasks</title>
</head>
<body>
	<nav>
    <div class="nav-wrapper">
      <a href="../tasks" class="brand-logo">Todolist</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
        <li><a href="<c:url value="/categories"/>">Categories</a></li>
        <li><a href="<c:url value="/tasks"/>">Tâches</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="<c:url value="/categories"/>">Categories</a></li>
        <li><a href="<c:url value="/tasks"/>">Tâches</a></li>
      </ul>
    </div>
  </nav>
  <h1>Tâches de ${user.name}</h1>
    <c:forEach items="${tasks}" var="task">
        <div class="card-panel col s12 m8 l3">
	            <h2>${task.label}</h2>
	            <div class="row">
	                <span class="col s6 m4 l2">
	                   Début : ${task.getShortBeginningDate()}
	                </span>
	                <span class="col s6   m4 offset-m2 l3 offset-l2">
	                   Fin estimée :    ${task.getShortPrevisionalEndingDate()}
	                </span>
	                <span class="col s6   m4 offset-m2 l3 offset-l2">
	                   Description : A venir
	                </span>
	            </div>
        </div>
    </c:forEach>

<c:if test="${tasks != null && ! tasks.isEmpty()}">
    <section class="row">
        <div class="col s2 m2 l2">
            <form action="endTasks/${userId}" method="post">
				 <input type="button" class="btn waves-effect waves-light" onclick="submitForm(this.form)" value="Finir toutes les tâches de ${user.name}">
            </form>
        </div>
    </section>
</c:if>
<c:if test="${tasks.isEmpty()}">
Il n'y a pas de tâches à terminer dans cette période.
</c:if>
<section class="row">
    <div class="col s2 m2 l2">
        <a class="waves-effect waves-light btn" href="findTasks">Retour</a>
    </div>
</section>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
	</body>
</html>