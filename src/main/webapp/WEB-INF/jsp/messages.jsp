<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Mensage de sucesso após realizar alteração de registro (update) -->
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
			}, 1355);
		</script>
	</c:when>
	<c:when test="${requestScope.updated == false}">	
		<div id="message-update-error" class="message">
			<div class="message-content-error">
				<h4 class="message-title">Ocorreu um erro ao tentar alterar esta reserva.</h4>
			</div>
		</div>
		<a id="agendamento" href="agendamento.jsp"></a>
		<script>
			setTimeout( function () {
				document.getElementById("message-update-error").style.visibility = "hidden";		
			}, 3000);
			setTimeout( function () {
				document.getElementById("agendamento").click();
			}, 3150);
		</script>
	</c:when>
</c:choose>

<!-- Mensage de sucesso após realizar cadastro (Create/Insert) -->
<%-- <c:if test="${requestScope.updated == true requestScope.updated == false}">
	<div id="message-update-sucess" class="message">
		<div class="message-content">
			<h4 class="message-title">Reserva alterada com sucesso.</h4>
		</div>
	</div>
	<script>
		var fechaModal = setTimeout( function () {
			document.getElementById("message-update-sucess").style.visibility = "hidden";		
		}, 1350);
	</script>
</c:if> --%>