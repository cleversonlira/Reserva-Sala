<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<div>
		<a id="logo" href="reserva?action=Agendamento">
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
			<li><a href="reserva?action=Logout">Sair</a></li>
		</ul>
	</nav>
</header>