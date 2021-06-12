<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<div>
		<a id="logo" href="#">
			<img alt="Logo" width="170" height="29" src="img/login-pic.png">
		</a>
		<p id="welcome">Bem vindo, ${userLogged.nome}</p>
	</div>
	<nav id="nav">	
	<button id="btn-mobile">Menu</button>
		<ul id="menu">					
			<li><a href="#">Detalhes das Reuniões</a></li>		
			<li><a href="#">Painel</a></li>
			<li><a href="#">Recursos</a></li>
			<li><a href="#">Salas</a></li>
			<li><a href="/Reserva-Sala/reserva?action=logout">Sair</a></li>
			<c:import url="logout-parcial.jsp" />
		</ul>
	</nav>
</header>