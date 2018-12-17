try{
    xmlhttp = new XMLHttpRequest();
} catch(ee) {
    try{
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch(e){
        try{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch(E){
            xmlhttp = false;
        }
    }
}

var servico = document.getElementById('idServico');
servico.addEventListener("blur", preenchePreco);

function preenchePreco() {
	var url = "/barbershop/PreenchePreco?servico=" + servico.value;
	xmlhttp.open('GET', url, true);
	 	xmlhttp.onreadystatechange = function() {
	        if (xmlhttp.readyState == 4) {
	        	if (xmlhttp.status == 200) {
	        		var preco = xmlhttp.responseText;
	        		document.getElementById('total-pagar').value = preco;   		
	        	}
	        }
	    }
	    xmlhttp.send(null);
}


function cadastro() {
	var url = "/barbershop/CadastroAgendamento";
	console.log(url);
	xmlhttp.open('POST', url, true);
	 	xmlhttp.onreadystatechange = function() {
	        if (xmlhttp.readyState == 4) {
	        	if (xmlhttp.status == 200) {
	        		var resposta = xmlhttp.responseText;
	        		console.log(resposta);
	        		if (resposta) {
	        			alert("Serviço agendado com sucesso!");
	        		}
	        	}
	        }
	    }
	    xmlhttp.send(null);
	
}

function verificarLogin() {
	var url = "/barbershop/Login?profissional="+"'" + profissional.value + "'";
	console.log(url);
	xmlhttp.open('GET', url, true);
	 	xmlhttp.onreadystatechange = function() {
	        if (xmlhttp.readyState == 4) {
	        	if (xmlhttp.status == 200) {
					if (xmlhttp.responseText) {
						
					}
	        	}
	        }
	    }
	    xmlhttp.send(null);
}


