<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Mensage de sucesso ap�s realizar altera��o de registro (update) -->
<c:choose>
	<c:when test="${requestScope.updated == true}">	
		<div id="message-update-sucess" class="message">
			<div class="message-content-sucess">
				<h4 class="message-title">Reserva alterada com sucesso.</h4>
			</div>
		</div>
		<a id="agendamento" href="agendamento.jsp"></a>
		<script>
			setTimeout( function () {
				document.getElementById("message-update-sucess").style.visibility = "hidden";		
			}, 1350);
			setTimeout( function () {
				document.getElementById("agendamento").click();
			}, 1800);
		</script>
	</c:when>
	<c:when test="${requestScope.updated == false}">	
		<div id="message-update-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao alterar esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="agendamento.jsp"></a>
		<script>
			setTimeout( function () {
				document.getElementById("message-update-error").style.visibility = "hidden";		
			}, 1500);
			setTimeout( function () {
				document.getElementById("agendamento").click();
			}, 1800);
		</script>	
	</c:when>
</c:choose>

<!-- Mensage de sucesso ap�s realizar cadastro (Create/Insert) -->
<c:choose>
	<c:when test="${requestScope.created == true}">	
		<div id="message-update-sucess" class="message">
			<div class="message-content-sucess">
				<h4 class="message-title">Reserva criada com sucesso.</h4>
			</div>
		</div>
		<a id="agendamento" href="agendamento.jsp"></a>
		<script>
			setTimeout( function () {
				document.getElementById("message-created-sucess").style.visibility = "hidden";		
			}, 1350);
			setTimeout( function () {
				document.getElementById("agendamento").click();
			}, 1800);
		</script>
	</c:when>
	<c:when test="${requestScope.created == false}">	
		<div id="message-created-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao criar esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="agendamento.jsp"></a>
		<script>
			setTimeout( function () {
				document.getElementById("message-created-error").style.visibility = "hidden";		
			}, 1500);
			setTimeout( function () {
				document.getElementById("agendamento").click();
			}, 1800);
		</script>	
	</c:when>
</c:choose>