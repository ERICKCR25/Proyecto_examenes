<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />
<script src="https://kit.fontawesome.com/2e81971293.js"crossorigin="anonymous"></script>


<title>Agrega Preguntas a examen</title>
</head>
<body>
<jsp:include page="intranetCabecera.jsp" />
<div class="container">
<br>&nbsp;<br>
<br>&nbsp;<br>
	<div class="page-header ">
		<div class="text-center">
  			<h1>${Examen} </h1>
  		</div>
	</div>
	<form id="formCabecera" action="cargaExamen"  method="post" >
		<input type="hidden" id="idex" name="idex" value="${idExamen}" >
	</form>	
	<form id="idFormElimina" action="eliminaPregunta"  method="post">
				<input type="hidden" id="elimina_pregunta" name="elimina_pregunta">
			</form>
	
			<input type="hidden" id="cantPreguntas" name="cantPreguntas" value="${cantPreguntas}">
	
			<div class="panel-group" id="steps">
				<div class="panel panel-default">
					<div class="panel-heading">Datos de Examen</div>
						<div class="panel-body">
							<div class="form-group  col-md-12 " >
								<div class="col-md-5 col-sm-12 text-left" id="detalleExamenCab" name="detalleExamenCab" >
									<strong>Detalle: </strong><p>${descripcion}</p>									
								</div>
								<div class="col-md-7 col-sm-12 text-right" id="idExamenCab" name="idExamenCab">
									<strong>Id: </strong><p>${idExamen} </p>
								</div>
								<div class="col-md-5 col-sm-12 text-left" id="valorAprobatorioCab" name="valorAprobatorioCab" >
									<strong>Valor Aprobatorio:</strong><p>${porAprobacion}</p>	
								</div>
								<div class="col-md-7 col-sm-12 text-right" id="valorTotalCab" name="valorTotalCab">
									
									<strong>Puntaje Max:</strong> <p> ${valorTotal}</p>	
								</div>
							</div>
							
					</div>
				</div>
				
				
				<div class="panel panel-default">
					<div class="panel-heading">Agregue Pregunta</div>
						<div class="panel-body">
						<form id="idFormAgrega" action="agregaPreguntasEnEx"  method="post">
							<div class="form-group  col-md-12 text-center"  >
									<div id="numPreg" class="col-md-12 ">
										<div class=" hidden">
								  			<input type="text" class="form-control" id="numeroPregunta" name="nPregunta"  >
								  		</div>
									</div>
									<div class="form-group  col-md-12" >
										<div class="col-md-12 ">
										  <textarea type="text" class="form-control" name="enunciado" id="enunciado"  placeholder="Ingrese enunciado de pregunta" ></textarea>
										</div>
										
									</div>
							</div>
							
							
							<div class="form-group  col-md-12 text-center" >
								<div class="text-center">
									<div class="col-md-6 ">
									  <select  class="form-control " id="id_Materia" name="materia.idMateria">
									  	<option>Seleccione Materia</option>
									  </select>
									</div>
									<div class="col-md-6">
									  <select  class="form-control " id="id_TipoPregunta" name="tipoPregunta.idTipoPregunta" onChange="muestraTipo()">
									  	<option>Seleccione tipo de Pregunta</option>
									  </select>
									</div>
								</div>
							</div>
							<div class=" hidden">
								  	<input type="text" class="form-control" id="id_ex" name="id_ex" value="${idExamen}" >
							</div>
							
						</form>	
						
						<div id="tipoNormal" class="container hidden">
							<br>
							<form>
								<div class="form-row align-items-center">
									<div class="col-md-12">					
				  						<textarea class="form-control" id="respuestaNormal"placeholder="Ingresa Respuesta"></textarea>
									</div>					
								</div>
							</form>
							<br>
						</div>
				
							<div id="tipoVoF" class="container hidden">
								<br>
								<form id="formularioDeRespuestas">
								<div class="form-row align-items-center">
									<div class="col-md-12 ">
										<div class="custom-control custom-radio mr-sm-2">
												<input class="form-check-input" type="radio" name="radioPregunta" id="radioPregunta">
												<label class="form-check-label" for="gridRadios1">
					           					 Verdadero
					          					</label>
										</div>
										<div class="form-control custom-radio mr-sm-2">
												<input class="form-check-input" type="radio" name="radioPregunta" id="radioPregunta" >
												<label class="form-check-label" for="gridRadios1">
					           					 Falso
					          					</label>
										</div>
									</div>							
								</div>
								</form>
								<br>
							</div>
						</div>
						<div id="tipoSeleccionMultiple" class="container hidden">
							<br>
							<form id="formularioDeRespuestasMultiples">			
								<div class="form-row items-center " id="listaRespuestas">
									<ol id="listaordenada" class="col-md-12">
									<li><div class="col-md-12" id="divPregunta">
										<div class="input-group ">
											<div class="form-control custom-radio my-auto">
												<input class="form-check-input" type="radio" name="radioPregunta" id="nuevo_li">
											</div>
												<input type="text" class="form-control" id="inlineFormInputName"placeholder="Ingrese Respuesta">
											<div class="col-xs-2  ml-2 text-right ">
												<button type="button" class="btn btn-primary" onclick="return add_li()" value="añadir li"><i class="fas fa-plus-circle"></i></button>
												<button type="button" class="btn btn-primary"><i class="fas fa-minus-circle"></i></button>
											</div>
										</div>
										</div><br></li>
										
									</ol>
									
									
									
								</div>
							</form>
							<br>
							<div class="col-md-12">
									<div class="text-center">
										<button type="button" id="id_btnAgregar"  class="btn btn-primary" onclick="agregaPregunta();">AGREGA PREGUNTA</button>
									</div>
							</div>
		</div>
			</div>
			<div class="panel panel-default">
					<div class="panel-heading">Detalle De Examen</div>
						<div class="panel-body">
							<c:forEach items="${preguntas}" var="x">
							<div class="list-group">
							  <a href="#" class="list-group-item" onmouseenter="muestraBotones('${x.nPregunta}');" onmouseleave="ocultaBotones('${x.nPregunta}');">
							  <div class="row">
							  <div class="col-lg-6 col-md-6 col-sm-3">
							  <strong >Pregunta ${x.nPregunta}</strong>
							  <h5>${x.enunciado}</h5>
							  </div>
							  
							 <div class="col-lg-6 col-md-auto col-sm-auto">
							  	<div class="text-right hidden" id="${x.nPregunta}">
								  	<button type="button" class="btn btn-success" onclick="editarPregunta('${x.idPregunta}','${x.nPregunta}','${x.enunciado}','${x.materia.idMateria}');">
										<img src='images/edit.gif' width='auto' height='auto' />
									</button>
									<button type="button" class="btn btn-danger"  onclick="eliminarPregunta('${x.idPregunta}');">
										<img src='images/delete.gif' width='auto' height='auto' />
									</button>
								</div>
							  </div>
							  </div>
							 </a>
							  </c:forEach>
							</div>					
							<div class="col-md-12">
									<div class="text-center">
									<button type="button" id="id_btnAgregar" class="btn btn-warning">GUARDAR EXAMEN</button>
									</div>
							</div>
					</div>
					
					
				</div>
				
	<div class="modal fade" id="idModalActualiza">
			<div class="modal-dialog" style="width: 60%">
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Actualiza
							Pregunta
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							action="actualizaPregunta" class="form-horizontal" method="get">
							<div class="panel-group" id="steps">
								<!-- Step 1 -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos del Pregunta</a>
										</h5>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_ID">ID</label>
												<div class="col-lg-5">
													<input class="form-control" id="id_ID" readonly="readonly"
														name="idPregunta" type="text" maxlength="100" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_nPregunta">Nombre de la Pregunta</label>
												<div class="col-lg-5">
													<input class="form-control" id="id_act_nPregunta"
														name="nPregunta" placeholder="Ingrese el nPregunta" type="text"
														maxlength="500" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label"
													for="id_act_enunciado">Enunciado</label>
												<div class="col-lg-5">
													<input class="form-control" id="id_act_enunciado"
														name="enunciado"
														placeholder="Ingrese el enunciado" type="text"
														maxlength="500" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label"
													for="id_act_idMateria">Id Materia</label>
												<div class="col-lg-5">
													<select type="text" class="form-control" id="id_act_materia" name="materia.idMateria">
													  	<option>Seleccione</option>
													 </select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-3">
													<button type="submit" class="btn btn-primary">ACTUALIZA</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</form>

					</div>
				</div>
			</div>

		</div>

<!-- El formulario de busqueda de Producto (Modal) -->

  	 <div class="modal fade" id="idBuscaProducto" >
			<div class="modal-dialog" style="width: 60%">

				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Busqueda de Producto</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						    <div class="panel-group" id="steps">
		                        <div class="panel panel-default">
											<div class="form-group">
													<label class="col-lg-3 control-label">
														Producto 
													</label>   
													<div class="col-lg-5">
														<input id="id_txtProducto" class="form-control" name="producto" type="text" />
													</div>
											</div>
											<div class="form-group">
												<div class="col-lg-12">
												<table id="id_table_producto" class="table table-striped table-bordered" >
														<thead>
															<tr>
																<th style="width: 15%">Id</th>
																<th style="width: 45%">Nombre</th>
																<th style="width: 15%">Precio</th>
																<th style="width: 15%">Stock</th>
																<th style="width: 10%"></th>
															</tr>
														</thead>
														<tbody>

														</tbody>				
												</table>
												</div>
											</div>
		                        </div>
		                    </div>
				</div>
			</div>
			</div>
		</div>
		
		
	<!-- Modal Mensaje -->	
		  <div class="modal fade" id="idMensaje" >
			<div class="modal-dialog" style="width: 60%">

				<div class="modal-content">
				<div class="modal-header" style="padding: 20px 20px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Mensaje</h4>
				</div>
				<div  id="idMensajeTexto" class="modal-body" style="padding: 30px 30px;align-content: center;">
					
			    </div>
			</div>
			</div>
		</div>
		

</div>
<script type="text/javascript">
	$(document).ready(function() {	
		$.getJSON("cargaMateria",{}, function (data){
			$.each(data, function(index, item){
				$('#id_Materia').append("<option value='" +item.idMateria + "'>" + item.nombre + "</option>" );     
				$('#id_act_materia').append("<option value='" +item.idMateria + "'>" + item.nombre + "</option>" );                     
			});
		});
		
	});	
</script >	

<script type="text/javascript">
$(document).ready(function() {	
	$.getJSON("cargaTipoPregunta",{}, function (data){
		$.each(data, function(index, item){
			$('#id_TipoPregunta').append("<option value='" + item.idTipoPregunta + "'>" + item.nombre + "</option>" );     
			                   
		});
	});
	
});	
</script>

<script type="text/javascript">
function muestraBotones(id) {
	var idDiv="#"+id;
	$(idDiv).removeClass("hidden");
	
}
function ocultaBotones(id) {
	var idDiv="#"+id;
	$(idDiv).addClass("hidden");
	
}
function editarPregunta(id, nPregunta, enunciado, idMateria ) {
	$('input[id=id_ID]').val(id);
	$('input[id=id_act_nPregunta]').val(nPregunta);
	$('input[id=id_act_enunciado]').val(enunciado);
	$('select[id=id_act_materia]').val(idMateria);
	$('#idModalActualiza').modal("show");
}
function eliminarPregunta(id) {
	$('input[id=elimina_pregunta]').val(id);
	$('#idFormElimina').submit();
}

function agregaPregunta(id) {	
	$('#idFormAgrega').submit();
}




function muestraTipo() {
	var sel = parseInt(document.getElementById('id_TipoPregunta').value);
	switch (sel) {
	case 1:
		$("#tipoVoF").removeClass("hidden");
		$("#tipoSeleccionMultiple").addClass("hidden");

		break;
	case 2:
		$("#tipoVoF").addClass("hidden");		
		$("#tipoSeleccionMultiple").removeClass("hidden");
		break;
	
	default:	
		
		$("#tipoVoF").addClass("hidden");
		$("#tipoSeleccionMultiple").addClass("hidden");
	}
}

</script>

<script type="text/javascript">
	$(document).ready(function() {	
		var cantidad = parseInt($('input[id=cantPreguntas]').val());
		$('input[id=numeroPregunta]').val((cantidad+1));	
		$('#numPreg').append("<strong># Pregunta : " + (cantidad+1) + "</strong>" ); 
		
	});	
</script >

<script>
		function add_li() {

			var nuevoLi = document.getElementById("nuevo_li").value;

			if (nuevoLi.length > 0) {

				if (find_li(nuevoLi)) {

					var li = document.createElement('li');

					li.id = nuevoLi;

					li.innerHTML = "<div class='col-md-12'><div class='input-group'><div class='custom-control custom-radio my-auto'><input class='form-check-input' type='radio' name='radioPregunta' id='radioPregunta'></div><input type='text' class='form-control' id='inlineFormInputName'placeholder='Ingrese Respuesta'><div class='col-xs-4  ml-2 text-right'><button type='button' class='btn btn-primary' onclick='return add_li()' value='añadir li'><i class='fas fa-plus-circle'></i></button>&nbsp;<button type='button' class='btn btn-primary' onclick='eliminar(this)'><i class='fas fa-minus-circle'></i></button></div></div></div><br>";

					
					document.getElementById("listaordenada").appendChild(li);

				}

			}

			return false;

		}

		/**

		 * Funcion que busca si existe ya el <li> dentrol del <ul>

		 * Devuelve true si no existe.

		 */

		function find_li(contenido) {

			var el = document.getElementById("listaordenada").getElementsByTagName("li");

			for (var i = 0; i < el.length; i++) {

				if (el[i].innerHTML == contenido)

					return false;
			}

			return true;

		}

		/**

		 * Funcion para eliminar los elementos

		 * Tiene que recibir el elemento pulsado

		 */

		function eliminar(elemento) {

			var id = elemento.parentNode.getAttribute("id");

			node = document.getElementById(id);

			node.parentNode.removeChild(node);

		}
	</script>
	
	
	
	
</body>
</html>