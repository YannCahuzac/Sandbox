<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

	<form:form id="formTestController1" method="post" action="action/testController1">
		<input type="submit" value="testController1">
	</form:form>

	<form:form id="formTestController2" method="post" action="action/testController2">
		<input type="submit" value="testController2">
	</form:form>

	<a href="/yca-war/angular/indexOk.html">Vers AngularJS Simple</a>
	<br>
	<br>
	<a href="/yca-war/angular/index.html">Vers AngularJS Router</a>

</body>
</html>