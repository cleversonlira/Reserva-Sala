<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/agendamento.css">
    <link rel="stylesheet" href="css/modal.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Agendamento</title>
</head>
<body class="container">    
    <section class="agendamento margin-top">
        <h1>Reservar Sala</h1>
        <c:import var="formAgendamento" url="WEB-INF/jsp/formAgendamento.jsp"/>
        <form action="agendamento" method="post">
        	${formAgendamento}<!-- Importando o arquivo formAgendamento com os inputs -->
	        <input class="enviar" type="submit" value="Agendar">
		</form>
    </section>
    <section class="agendados margin-top">
		<h1 class="text-center">Reservas Realizadas</h1>
    	<c:import var="listReunioes" url="WEB-INF/jsp/listReunioes.jsp"/>
		${listReunioes}<!-- Importando o arquivo listReunioes com a tabela de reunioes -->
	</section>
</body>
</html>