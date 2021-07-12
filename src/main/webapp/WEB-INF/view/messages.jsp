<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Mensagem após tentar fazer login (ControllerServlet.login(req, resp)) -->
<c:choose>
	<c:when test="${(requestScope.valid == false)}">	
		<div id="message-login-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">E-mail ou Senha inválidos.</h4>
			</div>
		</div>	
		<a id="login" href="/Reserva-Sala/reserva?action=Logout"></a>
	</c:when>
</c:choose>

<!-- Mensagem após alterar registro (update) -->
<c:choose>
	<c:when test="${requestScope.updated == true}">	
		<div id="message-update-sucess" class="message">
			<div class="message-content-sucess">
				<h4 class="message-title">Reserva alterada com sucesso.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>
	</c:when>
	<c:when test="${requestScope.updated == false}">	
		<div id="message-update-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao alterar esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>
	</c:when>
</c:choose>

<!-- Mensagem após realizar cadastro (Create/Insert) -->
<c:choose>
	<c:when test="${requestScope.created == true}">	
		<div id="message-created-sucess" class="message">
			<div class="message-content-sucess">
				<h4 class="message-title">Reservado com sucesso.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>
	</c:when>
	<c:when test="${requestScope.created == false}">	
		<div id="message-created-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao criar esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>
	</c:when>
</c:choose>

<!-- Mensagem após Deletar (delete) -->
<c:choose>
	<c:when test="${requestScope.deleted == true}">	
		<div id="message-delete-sucess" class="message">
			<div class="message-content-sucess">
				<h4 class="message-title">Removido com sucesso.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>
	</c:when>
	<c:when test="${requestScope.deleted == false}">	
		<div id="message-delete-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao remover esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="/Reserva-Sala/reserva?action=Agendamento"></a>	
	</c:when>
</c:choose>
<script src="js/functions.js"></script>