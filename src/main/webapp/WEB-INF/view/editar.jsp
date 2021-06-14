<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>-->

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
    <title>Editar</title>
</head>
<body class="container">
<c:choose>

	<c:when test="${sessionScope.userLogged != null}">	
		<c:import var="headerContainer" url="../view/header.jsp"/>
		${headerContainer} 
	    <section class="agendamento margin-top">
	        <h1>Reservar Sala</h1>
	        <c:import var="formAgendamento" url="../view/formAgendamento.jsp"/>
	        <form action="reserva" method="post">
	        	${formAgendamento}<!-- Importando o arquivo formAgendamento com os inputs -->
	        	<input type="hidden" name="action" id="action" value="ApplyEditing">
	        	<input class="enviar" type="submit" value="Aplicar Alterações">
			</form>
	    </section>
	    
	    <section class="agendados margin-top">
			<h1 class="text-center">Reservas Realizadas</h1>
			<c:import var="listReunioes" url="../view/listReunioes.jsp"/>
			${listReunioes}<!-- Importando o arquivo listReunioes com a tabela de reunioes -->	
		</section>
		<c:import var="message" url="../view/messages.jsp"/>
		${message}<!-- Logica de mensagens para o usuário -->
	</c:when>
	
	<c:otherwise>
		<c:redirect url="/reserva?action=LoginForm"></c:redirect>
	</c:otherwise>
	
</c:choose>
</body>
</html>