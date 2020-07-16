<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<title>Sistema Examenes Virtuales</title>
</head>
<body>
       
<jsp:include page="intranetCabecera.jsp" />
<div class="container">&nbsp;<br>&nbsp;<br>&nbsp;<br>
<h3>Consulta Respuestas</h3>
</div>
 
<div class="container" >
 <div class="col-md-13" align="center"> 
			

		       <form accept-charset="UTF-8"  class="simple_form"  method="post">
					<div class="row">
						
						
						
						<div class="col-md-3">	
								<select id="id_pregunta" class='form-control'>
									<option value="-1">[Seleccione]</option>    
								</select>
						</div>
						
						<div class="col-md-3">
								<button type="button" onclick="filtrar();" class="btn btn-primary"  >FILTRA</button><br>&nbsp;<br>
						</div>
						
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="id_table" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Detalle</th>
												<th>Tipo</th>
											</tr>
										</thead>
										<tbody>
												   
												
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
 </div>

<script type="text/javascript">
function filtrar(){
	$("#id_table tbody").empty(); 

	
	var v_pregunta = $("#id_pregunta").val();
	
	$.getJSON("verRespuestas", {"pregunta.idPregunta":v_pregunta}, function(data){
		$.each(data, function(index,item){
			$("#id_table").append("<tr><td>"+item.idRespuesta+"</td><td>"+item.detalle+"</td><td>"+item.tipo+"</td><td>"+item.pregunta.enunciado+"</td></tr>");
		});
	});
}
</script>

<script type="text/javascript">
$.getJSON("listaPregunta", {}, function(data){
	$.each(data, function(index,item){
		$("#id_pregunta").append("<option value="+item.idPregunta +">"+ item.enunciado +"</option>");
	});
});
</script>

 		
</body>
</html>