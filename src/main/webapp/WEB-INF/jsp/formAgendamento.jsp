<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/agendamento.css">

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
	   	<optgroup label="Com Videoconferencia">
	        <option value="1">Sala 1</option>                    
	        <option value="3">Sala 3</option>
	        <option value="4">Sala 4</option>
	        <option value="5">Sala 5</option>
	        <option value="8">Sala 8</option>
	    </optgroup>
	    <optgroup label="Sem Videoconferencia">
	        <option value="2">Sala 2</option>            
	        <option value="6">Sala 6</option>
	        <option value="7">Sala 7</option>
	    </optgroup>
	</select>
	
	<label for="observacoes">Observações:</label>
	<textarea name="observacoes" id="observacoes" cols="30" rows="10">${requestScope.observacoes}</textarea>