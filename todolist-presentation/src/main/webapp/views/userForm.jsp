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
<title>User Form</title>
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
  
  <section>
    <form action="" method="post">
        <section class="valign-wrapper row">

            <label class="valign col s6 offset-s3">
                <em>Utilisateur</em>

                <select class="browser-default valign " name="userId" required>
                    <option value="0" disabled selected>Choix utilisateur</option>
                    <c:forEach items="${users}" var="user">
                        <option value="${user.id}">${user.name}</option>
                    </c:forEach>
                </select>
            </label>

        </section>

        <section class="row">

            <div class="col s3 offset-s3">
                <label>
                    Date de début
                    <input type="date" name="beginningIntervalDate" class="datepicker" required>
                </label>
            </div>
            <div class="col s3">
                <label>
                    Date de fin
                    <input type="date" name="endingIntervalDate" class="datepicker" required>
                </label>
            </div>
        </section>

        <div class="row">
            <div class="col s3 offset-s3">            
			  <button class="btn waves-effect waves-light" type="submit" val>Rechercher
			    <i class="material-icons right">send</i>
			  </button>
            </div>
        </div>
    </form>
    	<div class="row">
    		<div class="col offset-s3">
    			<p> Veuillez sélectionner un interval de temps pour les dates prévisionnelles de fin.</p>
    		</div>
    	</div>
</section>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>

<script>
  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
</script>
	</body>
</html>