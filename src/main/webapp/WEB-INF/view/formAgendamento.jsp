<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="sala" class="br.com.salareunioes.dao.SalaDAO"/>

	<input type="hidden" name="id" id="id" readonly value="${requestScope.id}">
	
	<label for="titulo">Titulo:</label>
	<input type="text" name="titulo" value="${requestScope.titulo}" required>
	
	<label for="solicitante">Solicitante:</label>
	<input type="text" name="solicitante" required value="${requestScope.solicitante}">
	<div class="grid">
	    <div>
	        <label for="inicio">Inicio:</label>
	        <input class="padding" type="time" name="inicio" value="${requestScope.inicio}">                                    
	    </div>
	    <div>
	        <label for="fim">Fim:</label>
	        <input class="padding" type="time" name="fim" value="${requestScope.fim}">
	    </div>
	</div>
	<label for="data">Data:</label>
	<input class="padding" type="date" name="data" value="${requestScope.data}">
	
	<label for="sala">Sala:</label>
	<select name="sala" id="sala" required>
		<c:if test="${requestScope.sala > 0}">
			<option hidden value ="${requestScope.sala}" selected>Sala ${requestScope.sala}</option>
		</c:if>
	   <!-- Logica para colocar "Sala "+numero da sala, se for uma edicao. Se não for, coloca "Escolha a sala" -->	    
		<option hidden selected value="${requestScope.sala}">
			<c:choose>
				<c:when test="${requestScope.sala gt 0}">
					<c:out value="Sala ${requestScope.sala}"/>
				</c:when>
				<c:otherwise>
					Escolha a sala
				</c:otherwise>
			</c:choose>
		</option>
		<c:forEach var="sala" items="${sala.listar().entrySet()}">
			<option value="${sala.key}">
				${sala.value}
			</option>
		</c:forEach>
	</select>
	
	<label for="observacoes">Observações:</label>
	<textarea name="observacoes" id="observacoes" maxlength="255" cols="30" rows="10">${requestScope.observacoes}</textarea>