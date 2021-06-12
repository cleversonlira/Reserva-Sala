<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<jsp:useBean id="dao" class="br.com.salareunioes.dao.ReuniaoDAO"/>
<table id="tabela" class="table table-striped" style="width:100%">
	<thead>
		<tr class="titulo-coluna">
			<th>Código</th>
			<th>Data</th>
			<th>Horario</th>						
			<th>Sala</th>
			<th>Titulo</th>		                
			<th>Editar</th>
			<th>Remover</th>
		</tr>
	</thead>			        
	<tbody>	
		<c:forEach var="reuniao" items="${dao.list()}">
			<tr>						
				<td>${reuniao.id}</td>
				<td>																							
					<fmt:parseDate value="${reuniao.data}" pattern="yyyy-MM-dd" var="dataConvertida" type="date"/>
					<fmt:formatDate value="${dataConvertida}" type="date" pattern="dd.MM.yyyy"/>					
				</td>
				<td>
					<c:out value="${fn:replace(reuniao.inicio,':00.0000000','')}"/>
					<c:out value="${fn:replace(reuniao.fim,':00.0000000','')}"/>
				</td>							
				<td>${reuniao.sala}</td>
				<td>${reuniao.titulo}</td>
				<td>
					<a href="/Reserva-Sala/reserva?action=edit&id=${reuniao.id}" class="btn btn-editar">
						<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
							 width="15" height="20" viewBox="0 0 528.899 528.899" style="enable-background:new 0 0 528.899 528.899;"
							 xml:space="preserve">
							<g>
								<path d="M328.883,89.125l107.59,107.589l-272.34,272.34L56.604,361.465L328.883,89.125z M518.113,63.177l-47.981-47.981
									c-18.543-18.543-48.653-18.543-67.259,0l-45.961,45.961l107.59,107.59l53.611-53.611
									C532.495,100.753,532.495,77.559,518.113,63.177z M0.3,512.69c-1.958,8.812,5.998,16.708,14.811,14.565l119.891-29.069
									L27.473,390.597L0.3,512.69z"/>
							</g>
						</svg>
					</a>
				</td>
				<td>
					<div class="">								
						<a href="#modal${reuniao.id}" class="btn btn-remover">
					        <svg height="25" width="15" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
					                viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
					            <g>
					                <path d="M92.205,150l26.568,320.735C120.678,493.865,140.38,512,163.598,512h184.805c23.218,0,42.92-18.135,44.824-41.265
					                        L419.795,150H92.205z M211,437c0,8.291-6.709,15-15,15s-15-6.709-15-15V195c0-8.291,6.709-15,15-15s15,6.709,15,15V437z M271,437
					                        c0,8.291-6.709,15-15,15c-8.291,0-15-6.709-15-15V195c0-8.291,6.709-15,15-15s15,6.709,15,15V437z M331,437
					                        c0,8.291-6.709,15-15,15c-8.291,0-15-6.709-15-15V195c0-8.291,6.709-15,15-15c8.291,0,15,6.709,15,15V437z"/>
					            </g>
					            <g>
					                <path d="M406,60h-75V45c0-24.814-20.186-45-45-45h-60c-24.814,0-45,20.186-45,45v15h-75c-24.853,0-45,20.147-45,45
					                    c0,8.284,6.716,15,15,15h360c8.284,0,15-6.716,15-15C451,80.147,430.853,60,406,60z M301,60h-90V45c0-8.276,6.724-15,15-15h60
					                    c8.276,0,15,6.724,15,15V60z"/>
					            </g>
					        </svg>
					    </a>
					    <div id="modal${reuniao.id}" class="message-confirm">
					        <div class="message-content-confirm">
					            <h2 class="message-title">Deletar permanentemente</h2>
					                <p modal-description>
					                   Tem certeza que deseja deletar esta reunião?
					                </p>
					                <a class="message-link yes" href="/Reserva-Sala/reserva?action=delete&id=${reuniao.id}">Sim</a>
					                <a class="message-link not" href="/Reserva-Sala/reserva?action=agendamento">Não</a>            
					        </div>
					    </div>
				    </div>
				</td>					
			</tr>
		</c:forEach>
	</tbody>
</table>