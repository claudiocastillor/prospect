<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- POPUP votacion de candidato por estamento para junta calificadora -->
<s:if test="%{lstCandidatosVotacion.size > 0}">
	<div class="modal hide fade" id="myModal" style="width: 750px;">
		<form action="juntaCalificadoraGrabaVoto" method="post">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button">&times;</button>
				<div id="tituloModal"><h4>Sistema de Votaci&oacute;n</h4></div>
			</div>
			<div class="modal-body">
			
				<table class="table table-bordered table-condensed table-striped">
					<tr class="success">
						<td colspan="3"><div align="center"><strong>Candidatos para representar al estamento <s:property value="#session.usuario.getEstamento().getTitulo()"/></strong></div></td>
					</tr>
					<tr class="success">
						<td><div align="center"><i class="icon icon-thumbs-up"></i></div></td>
						<td><strong>Nombre:</strong></td>
						<td><strong>Unidad</strong><input type="hidden" name="idProceso" value="<s:property value="%{idProceso}"/>" ></td>
					</tr>
					<s:iterator value="lstCandidatosVotacion" status="ln" step="1">
					<tr>
						<td>
							<input type="radio" value="<s:property value="idUsuario"/>" name="votoIdCandidato" id="votoIdCandidato">
						</td>
						<td><s:property value="funcionario.getNombre()"/> <s:property value="funcionario.getApellidoPaterno()"/> <s:property value="funcionario.getApellidoMaterno()"/></td>
						<td><s:property value="funcionario.getUnidad().getTitulo()"/></td>
					</tr>		
					</s:iterator>
					
				</table>
			</div> 
			<div class="modal-footer">
				<div align="center">
					<button type="button" class="btn btn-success" onclick="validaVotacion(this.form)">Votar&nbsp;<i class="icon icon-white icon-thumbs-up"></i></button>
					<button data-dismiss="modal" class="btn" id="cerrarModal">Cerrar</button>
				</div>	
			</div>
		</form>
	</div>
</s:if>
<!-- FIN POPUP votacion de candidato por estamento para junta calificadora -->




<div class="alert alert-success">
	<h4>Bienvenido(a) <s:property value="#session.usuario.getNombre() + \" \" +  #session.usuario.getApellidoPaterno()"  /> al Sistema de evaluaci&oacute;n</h4>
</div>

<!-- timeline -->

<s:if test="lstEtapas.size() > 0">

	<div id="timeline" class="">
		<ul id="dates">
		<s:iterator value="lstEtapas" status="ln" step="1">
			<li><a href="#<s:property value="orden" />">Etapa <s:property value="#ln.index+1" /></a></li>
			
			<%-- <s:if test="(etapaVigente != null) && (etapaVigente.getId() == id)">
				
					<li><a href="#<s:property value="orden" />">Etapa <s:property value="#ln.index+1" /> <i class="icon-certificate icon-gray"></i></a></li>
				
			</s:if>	
			<s:else>
				<li><a href="#<s:property value="orden" />">Etapa <s:property value="#ln.index+1" /></a></li>
			</s:else> --%>
			
		</s:iterator>
		</ul>
		<ul id="issues">
			<s:iterator value="lstEtapas" status="ln" step="1">
				<li id="<s:property value="orden" />">
					<h5><s:property value="etapa.getTitulo()" /></h5>
					<p><b>Desde <s:date name="FechaInicio" format="dd/MM/yyyy" /> Hasta <s:date name="FechaTermino" format="dd/MM/yyyy" /></b></p>
					<p><s:property value="etapa.getDescripcion()" /></p>
				</li>
			</s:iterator> 
		
		</ul>
		<div id="grad_left"></div>
		<div id="grad_right"></div>
		<a href="#" id="next">+</a>
		<a href="#" id="prev">-</a>
	</div> 
</s:if>
<!-- fin timeline -->

<div class="row" id="graficos_estadisticas" align="center">

	<s:if test="xml != null">
	
		<s:hidden id="xml" name="xml" />
		<%-- <strong>Estadisticas de Compromisos</strong> --%>
			<!-- <div id="graphPane" style="width: 450px; height: 450px; margin-left: auto;margin-right: auto;" align="center"> -->
			<div id="graphPane" class="span6 thumbnail">
				
				<script type="text/javascript">
					var xmlCompromisos = document.getElementById("xml").value;
					
					var myChart = new FusionCharts("assets/FusionCharts/Column3D.swf?ChartNoDataText= No hay información para mostrar","myChartId", "350", "250", "0", "0");
					myChart.setXMLData(xmlCompromisos);
					myChart.render("graphPane");
				</script> 
				
			</div> 
	 
	</s:if>
	
	<s:if test="xmlVotaciones != null">
		<s:hidden id="xmlVotaciones" name="xmlVotaciones" />
		
			<div id="graphPaneVotaciones" class="span6 thumbnail">
				
				<script type="text/javascript">
					var xmlVotaciones = document.getElementById("xmlVotaciones").value;
					var myChart = new FusionCharts("assets/FusionCharts/Column3D.swf?ChartNoDataText= No hay información para mostrar","myChartId2", "350", "250", "0", "0");
					myChart.setXMLData(xmlVotaciones);
					myChart.render("graphPaneVotaciones");
				</script> 
				<s:if test="%{lstCandidatosVotacion.size > 0}">
					<div class="caption">
						<a href="#myModal" class="btn btn-mini" role="button" data-toggle="modal">Votar&nbsp;<i class="icon icon-thumbs-up"></i></a>
					</div>
				</s:if>
			</div> 
	 
	</s:if>
</div>


<div class="modal hide fade" id="alerta">
	<div class="modal-header">
	<button data-dismiss="modal" class="close" type="button">&times;</button>
		<div id="tituloModal"><h3>Atenci&oacute;n</h3></div>
	</div>
	<div class="modal-body">
	    <div id="msgModal" class="alert alert-error">
			
	    </div>          
	</div> 
	<div class="modal-footer" id="footerModal">
		
	</div>
</div>


<script>
var formGlobal = "";
function validaVotacion(form){
	flg = false;
	lg = form.length;
	formGlobal = form;
	
	
	for(var i = 0; i < lg; i++){
		if( (form[i].type == 'radio') && (form[i].checked)	){
			flg = true;
		}
	}
	
	if(flg){
		$('#msgModal').html("<strong>ATENCION!</strong> ¿Est&aacute; seguro de querer enviar este voto?<br>Este proceso es irreversible y no podr&aacute; cambiar su voto posterior al envio de este.");
		$('#footerModal').html("<button type='button' class='btn btn-success' onclick='enviarVoto()'>Votar&nbsp;<i class='icon icon-white icon-thumbs-up'></i></button> <a data-dismiss='modal' class='btn' href='#'>cancelar</a>");
		$('#alerta').modal('show');
	}else{
		$('#msgModal').html("<strong>ATENCION!</strong> Debe seleccionar un candidato para votar.");
		$('#footerModal').html("<a data-dismiss='modal' class='btn' href='#'>Cerrar</a>");
		$('#alerta').modal('show');
	}
	
}

function enviarVoto(){
	formGlobal.submit();
}

</script>