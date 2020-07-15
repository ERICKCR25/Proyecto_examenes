<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
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
<script src="https://kit.fontawesome.com/2e81971293.js"
	crossorigin="anonymous"></script>
<title>Resuelve Examen</title>
</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />
	<div class="container">
		<br>&nbsp;<br> <br>&nbsp;<br>
		<div class="page-header ">
			<div class="text-center">
				<h1>${Examen}</h1>
				<h3>${descripcion}</h3>
				
				<br>
				<h2>Duracion ${tiempo} minutos</h2>
			</div>
		</div>

		<!--<c:forEach items="${preguntas}" var="x">
			<div class="row">
				<div class="col-lg-10">
					<strong>Pregunta ${x.nPregunta} :</strong>
					<h3>${x.enunciado}</h3>
					<div class="input-group">
						<span class="input-group-addon"> <input type="radio"></span>
						<input type="text" class="form-control">
					</div>
				</div>
			</div>
		</c:forEach>-->
		
		
		<c:forEach items="${preguntas}" var="x">
		<div class="panel panel-primary">
			<div class="panel-heading">
			<h3 class="panel-title">Pregunta ${x.nPregunta} :</h3>
			</div>			
			<div class="panel-body">
					<div class="text-center">
					<h3>${x.enunciado}</h3>
					</div>
					<div class="container text-justify">
						<form class="form-inline text-center">
							
								<c:forEach items="${respuestas}" var="r">
									<c:if test="${r.pregunta.idPregunta == x.idPregunta}">
										<!--  <input type="radio" value="${r.idRespuesta}">
										 <p>${r.detalle}</p>-->
										 <!--<span class="input-group-addon"> <input type="radio" value="${r.idRespuesta}" ></span>
										<input type="text" class="form-control onlyread" value="${r.detalle}" -->
										<div class="radio">
										  <label>
										    <input type="radio" class="form-control"name="optionsRadios" id="optionsRadios1" value="${r.idRespuesta}" >
										     &nbsp;
										    ${r.detalle} 
										    &nbsp; &nbsp; &nbsp;&nbsp;
										  </label>
										</div>

									</c:if> 
								</c:forEach>
							
						</form>
					</div>
			</div>
		</div>
		</c:forEach>
		
	</div>

</body>
</html>