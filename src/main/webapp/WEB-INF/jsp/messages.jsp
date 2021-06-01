<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.updated == true}">
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
</c:if>