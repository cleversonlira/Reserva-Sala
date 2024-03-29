<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/agendamento.css">
    <link rel="stylesheet" href="css/messages.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Agendamento</title>
</head>
<body class="container">    
<c:choose>
	
	<c:when test="${sessionScope.userLogged != null}">	
		<c:import var="headerContainer" url="header.jsp"/>
		${headerContainer}
		
	    <section class="agendamento margin-top">
	    	<c:choose>
		        <c:when test="${(not empty requestScope.id) and (requestScope.id != null)}">
		        	<c:set var="h1" value="Alterar Reserva"/>
		        	<c:set var="value" value="Aplicar Alterações"/>
		        	<c:set var="action" value="ApplyEditing"/>
		        </c:when>
		        <c:otherwise>
		        	<c:set var="h1" value="Reservar Sala"/>
		        	<c:set var="value" value="Agendar"/>
		        	<c:set var="action" value="Agendar"/>
		        </c:otherwise>
	        </c:choose>
	        <h1 class="titulo-agendamento">${h1}</h1>
	        <c:import var="formAgendamento" url="formAgendamento.jsp"/>
	        <form action="reserva" method="post">
	        	${formAgendamento}<!-- Importando o arquivo formAgendamento com os inputs -->
		        <input type="hidden" name="action" id="action" value="${action}">
		        <input class="enviar" type="submit" value="${value}">
			</form>
	    </section>
	    
	    
	    
	    <section class="agendados margin-top">
			<h1 class="text-center">Reservas Realizadas</h1>
	    	<c:import var="listReunioes" url="listReunioes.jsp"/>
			${listReunioes}<!-- Importando o arquivo listReunioes com a tabela de reunioes -->
		</section>
		<c:import var="message" url="messages.jsp"/>
		${message}<!-- Logica de mensagens para o usuário -->
		<script src="js/functions.js"></script>
	</c:when>
	
	<c:otherwise>
		<c:redirect url="reserva?action=LoginForm"/>
	</c:otherwise>
</c:choose>
</body>
</html>