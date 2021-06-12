<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${(requestScope.valid == false) and (requestScope.valid != null)}">
		<a href="reserva?action=logout">Sair</a>
	</c:when>
	<c:otherwise>
		<a href="reserva?action=logout">Sair</a>
	</c:otherwise>
</c:choose>