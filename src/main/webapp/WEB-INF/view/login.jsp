<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/messages.css">
	<link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
	<title>Login</title>
</head>
<body>
<section class="content">
	<div class="login-screen">
		<picture>
			<img class="logo" src="img/login-pic.png" alt="logo da empresa">
		</picture>
		<div class="access-data" id="access-data">
			<h1>Login</h1>
			<form action="reserva" method="post">
				<div>					
					<input class="input" type="email" name="email" placeholder="login@siqueiracastro.com.br" value="${requestScope.email}" required/>
					<input class="input" type="password" name="senha" placeholder="*********" required/>
					<input type="hidden" name="action" id="action" value="Login">
					
					<input class="inline input" type="checkbox" id="remember" name="remember" value="remember">
					
  					<label class="inline input" id="label" for="remember">Remember</label> 												
					<button class="input" id="submit" type="submit">Entrar</button>
					
					<a href="#">Esqueci minha senha</a>
				</div>				
			</form>
		</div>  	
	</div>
	<c:import var="message" url="messages.jsp"/>
	${message}<!-- Logica de mensagens para o usuário -->
	<footer class="footer" id="footer">
		<p>Desenvolvido por Cleverson Lira</p>
		<p>Todos os direitos reservados a &copy;Copyright</p>
	</footer>
</section>
</body>
</html>

