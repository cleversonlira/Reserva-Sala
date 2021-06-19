<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/agendamento.css">
    <link rel="stylesheet" href="css/messages.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Detalhes das Reuniões</title>
</head>
<body class="container">
<c:choose>	
	<c:when test="${sessionScope.userLogged != null}">
	<c:import var="headerContainer" url="header.jsp"/>
		${headerContainer}
		 <section class="detalhes margin-top">
			<h1 class="text-center">Detalhes das Reservas Realizadas</h1>
	    	<c:import var="listReunioesDetalhes" url="listReunioesDetalhes.jsp"/>
			${listReunioesDetalhes}<!-- Importando o arquivo listReunioes com a tabela de reunioes -->
		</section>
		${message}<!-- Logica de mensagens para o usuário -->
		<script src="js/functions.js"></script>
	</c:when>
	<c:otherwise>
		<c:redirect url="reserva?action=LoginForm"/>
	</c:otherwise>
</c:choose>
</body>
</html>