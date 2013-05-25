<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="%{error!=null}">

	<div class="alert alert-error">
	  <button data-dismiss="alert" class="close" type="button">&times;</button>
	  <strong>ERROR!</strong> <s:property value="error"/>
	</div>

</s:if>

<s:form action="login" name="" method="post" theme="simple" cssClass="well form-horizontal span3 offset4">
	
	Nombre Usuario:<br>
	<s:textfield theme="simple"  cssClass="span3" autocomplete="off" name="usr_name" id="usr_name" value="wmoreira" />
	<br><br>
	
	Contrase&ntilde;a:<br>
	<s:password theme="simple" cssClass="span3" autocomplete="off" name="usr_psw" id="usr_psw" />
	<br><br>
	<div align="center">
		<s:submit value="Entrar" cssClass="btn" />
		<br><br>
	</div>

</s:form>

<div class="modal hide fade" id="myModal">
	<div class="modal-header">
	<button data-dismiss="modal" class="close" type="button">&times;</button>
		<div id="tituloModal"><h3>Atenci&oacute;n</h3></div>
	</div>
	<div class="modal-body">
	    <div id="msgModal">
	    	<b>UPS!..</b> Esta aplicaci&oacute;n est&aacute; dise&ntilde;ada para funcionar en Mozilla Firefox y Chrome<br>
	    	
	    	<div class="span5">
		    	<ul class="thumbnails">
			    	<li class="span3">
			    		<img src="assets/img/icon_firefox.png" class="thumbnail" width="64px" height="64px">
			    	</li>
			    	<li class="span2">
			    		<img src="assets/img/icon_chrome.png" class="thumbnail" width="64px" height="64px">
			    	</li>
		    	</ul>
	    	</div> 
	    </div>          
	</div> 
	<div class="modal-footer">
		<a data-dismiss="modal" class="btn" href="#">Cerrar</a>
	</div>
</div>

 
 


<script>

	document.getElementById('usr_name').setAttribute('required','required');
	document.getElementById('usr_psw').setAttribute('required','required');
	document.getElementById('usr_psw').setAttribute('value','ABCabc12');
	
</script>