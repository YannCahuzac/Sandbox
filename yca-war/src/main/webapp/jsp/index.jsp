<html>
<body>
	<!-- 	Il semblerait qu'il faille rediriger vers notre page angular comme ci-dessous plutôt que de mettre notre page angular dans le welcome-file, car sinon rien ne va plus..  -->
	<%
		response.sendRedirect("/yca-war/angular/index.html");
	%>
</body>
</html>