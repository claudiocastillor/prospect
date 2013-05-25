/*
 * Emilio Gonzalez 
 * 04-11-2012
 * 
 * Para imprimir ventanas de dialogo Bootstrap Modal
 * 
 * Requiere de: boostrap-modal-print.css
 * 
 * ej: imprimir Modal simple sin llaamr una url  : id="btnPrint" name="btnPrint" 
 * 
 * 		<div id="printThis">
 * 			xxxx
 * 		</div>
 * 
 * 		<a id="btnPrint" name="btnPrint" class="btn btn-small btn-primary" href="#" title="Imprimir ficha" ><i class="icon-print icon-white"></i></a>
 * 
 * ej: imprimir Modal al ser llamado por url (bootstrap-modal-url.js) : onclick="btnImprimir()" 
 * 
 * 
 * 		<div id="printThis">
 * 			xxxxx
 * 		</div>
 * 
 * 		<a onclick="btnImprimir()" id="btnPrint" name="btnPrint" class="btn btn-small btn-primary" href="#" title="Imprimir ficha" ><i class="icon-print icon-white"></i></a>
 * 
 * 
 */

//$(document).ready(function() {
	
	$('#btnPrint').on('click', function(e){
		preparaInformeImpresion();
	    printElement(document.getElementById("printThis"));
	    window.print();
	    location.href = "miEvaluacion";
	});

	function btnImprimir(){
		printElement(document.getElementById("printThis"));
		preparaInformeImpresion();
		window.print();
	};
	
	function printElement(elem, append, delimiter) {
	    var domClone = elem.cloneNode(true);
	    var $printSection = document.getElementById("printSection");

	    if (!$printSection) {
	        var $printSection = document.createElement("div");
	        $printSection.id = "printSection";
	        document.body.appendChild($printSection);
	    }

	    if (append !== true) {
	        $printSection.innerHTML = "";
	    }

	    else if (append === true) {
	        if (typeof(delimiter) === "string") {
	            $printSection.innerHTML += delimiter;
	        } else if (typeof(delimiter) === "object") {
	            $printSection.appendChlid(delimiter);
	        }
	    }

	    $printSection.appendChild(domClone);
	};
	
//});