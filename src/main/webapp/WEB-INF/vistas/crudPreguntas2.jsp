<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />
<title>Respuesta</title>
</head>
<body>
<jsp:include page="intranetCabecera.jsp" />
	<div class="container">
		&nbsp;<br>&nbsp;<br>&nbsp;<br>
		<h3>Registro Pregunta</h3>
	</div>



	<div class="container">
		<div class="col-md-12">


			<c:if test="${sessionScope.MENSAJE != null}">
				<div class="alert alert-success fade in" id="success-alert">
					<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>${sessionScope.MENSAJE}</strong>
				</div>
			</c:if>
			<c:remove var="MENSAJE" />

			<form action="registraPregunta" id="id_form" method="post">
				<input type="hidden" name="metodo" value="registra">
				
				<div class="form-group">
					<label class="control-label" for="id_numero">Numero</label> <input
						class="form-control" type="text" id="id_numero"
						style="width: 300px" name="nPregunta"
						placeholder="Ingrese numero" maxlength="500">
				</div>
				
				<div class="form-group">
					<label class="control-label" for="id_enunciado">Enunciado</label> <input
						class="form-control" type="text" id="id_enunciado"
						style="width: 300px" name="enunciado"
						placeholder="Ingrese enunciado" maxlength="500">
				</div>
				
				
				<div class="form-group">
					<label class="control-label" for="id_materia">Materia</label> <select
						id="id_materia" name="materia.idMateria" style="width: 300px"
						class='form-control'>
						<option value=" ">[Seleccione]</option>
					</select>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_tipoPregunta">Tipo de Pregunta</label> <select
						id="id_tipoPregunta" name="tipoPregunta.idTipoPregunta" style="width: 300px"
						class='form-control'>
						<option value=" ">[Seleccione]</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Crea
						Pregunta</button>
				</div>
			</form>


		</div>
	</div>

	<script type="text/javascript">
		$.getJSON("listaMateria", {}, function(data) {
			$.each(data, function(index, item) {
				$("#id_materia").append(
						"<option value="+item.idMateria 
								+ ">" + item.nombre 
								+ "</option>");
			});
		});
	</script>
	
	<script type="text/javascript">
		$.getJSON("listaTipoPregunta", {}, function(data) {
			$.each(data, function(index, item) {
				$("#id_tipoPregunta").append(
						"<option value="+item.idTipoPregunta 
								+ ">" + item.nombre 
								+ "</option>");
			});
		});
	</script>

	<script type="text/javascript">
		$("#success-alert").fadeTo(1000, 500).slideUp(500, function() {
			$("#success-alert").slideUp(500);
		});
	</script>




	<script type="text/javascript">
		$('#id_form')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								enunciado : {
									selector : '#id_enunciado',
									validators : {
										notEmpty : {
											message : 'El enunciado es un campo obligatorio'
										},
										stringLength : {
											message : 'El enunciado es de 2 a 500 caracteres',
											min : 2,
											max : 500
										}
									}
								},
								apellidos : {
									selector : '#id_apellidos',
									validators : {
										notEmpty : {
											message : 'El apellido es un campo obligatorio'
										},
										stringLength : {
											message : 'El apellido es de 2 a 500 caracteres',
											min : 2,
											max : 500
										}
									}
								},
								numero : {
									selector : '#id_numero',
									validators : {
										notEmpty : {
											message : 'El numero es un campo obligatorio'
										},
										regexp : {
											regexp : /^[0-9]$/,
											message : 'El numero es  entero con 1 caracter'
										}
									}
								},
								correo : {
									selector : '#id_correo',
									validators : {
										notEmpty : {
											message : 'El correo es un campo obligatorio'
										},
										regexp : {
											regexp : /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/,
											message : 'El correo contiene @'
										}
									}
								},
								fechaRegistro : {
									selector : '#id_fechaRegistro',
									validators : {
										notEmpty : {
											message : 'Fecha Registro es un campo obligatorio'
										},
										regexp : {
											regexp : /^\d{4}([\-/.])(0?[1-9]|1[1-2])\1(3[01]|[12][0-9]|0?[1-9])$/,
											message : 'Fecha es aa-mm-dd'
										}
									}
								},
								pregunta : {
									selector : '#id_pregunt',
									validators : {
										notEmpty : {
											message : 'La pregunta es un campo obligatorio'
										},
										stringLength : {
											message : 'La pregunta es un campo oblogatorio',
											min : 2,
											max : 500
										}
									}
								},
								password : {
									selector : '#id_password',
									validators : {
										notEmpty : {
											message : 'El password es un campo obligatorio'
										},
										stringLength : {
											message : 'El password es de 2 a 50 caracteres',
											min : 2,
											max : 50
										}
									}
								},
								direccion : {
									selector : '#id_direccion',
									validators : {
										notEmpty : {
											message : 'El direccion es un campo obligatorio'
										},
										stringLength : {
											message : 'El direccion es de 2 a 200 caracteres',
											min : 2,
											max : 200
										}
									}
								},
								estado : {
									selector : '#id_estado',
									validators : {
										notEmpty : {
											message : 'El estado es un campo obligatorio'
										},
										stringLength : {
											message : 'El estado es de 2 a 10 caracteres',
											min : 2,
											max : 10
										}
									}
								},
								ubigeo : {
									selector : '#id_ubigeo',
									validators : {
										notEmpty : {
											message : 'El ubigeo es un campo obligatorio'
										},
										stringLength : {
											message : 'El ubigeo es de 2 a 500 caracteres',
											min : 2,
											max : 500
										}
									}
								},
								
							}
						});
	</script>

</body>
</html>