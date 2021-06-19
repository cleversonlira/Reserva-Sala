<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:useBean id="dao" class="br.com.salareunioes.dao.ReuniaoDAO"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/agendamento.css">
    <link rel="stylesheet" href="css/messages.css">
    <link rel="stylesheet" href="css/panel.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Detalhes das Reuniões</title>
</head>
<body class="painel-container">
	 <section class="painel margin-top">
	 	<header>
		 	<a id="logo" href="reserva?action=Agendamento">
				<img alt="Logo" width="170" height="29" src="img/login-pic.png">
			</a>
			<h1 class="text-center">Painel de Eventos</h1>
	 	</header>
		<table id="tabela" class="table table-striped" style="width:100%">
			<thead>
				<tr class="painel-row titulo-linha">
					<th class="painel-meeting-room">Sala</th>
					<th class="painel-hour-init">Inicio</th>
					<th class="painel-hour-end">Fim</th>							
					<th class="painel-title">Titulo</th>
				</tr>
			</thead>			        
			<tbody>	
				<c:forEach var="reuniao" items="${dao.list()}">
					<tr class="painel-row">
						<td class="painel-hour">
							<c:out value="${fn:replace(reuniao.inicio,':00.0000000','')}"/>
						</td>
						<td>
							<c:out value="${fn:replace(reuniao.fim,':00.0000000','')}"/>
						</td>							
						<td class="painel-meeting-room">${reuniao.sala}</td>
						<td class="painel-title">${reuniao.titulo}</td>												
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>