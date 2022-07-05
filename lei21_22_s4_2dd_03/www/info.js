
// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.



function refreshPlant(){
    var request = new XMLHttpRequest();
    var vBoard=document.getElementById("plant");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";
        setTimeout(refreshPlant, reloadTime);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshPlant, reloadTime);
    };

    request.onerror = function() {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshPlant, reloadTime);
    };

    request.open("GET", "/plant", true);
    request.timeout = reloadTime;
    request.send();
}


function refreshAgvs() {
	var request = new XMLHttpRequest();
        var vBoard=document.getElementById("agvs");
        
        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color="black";
            setTimeout(refreshAgvs, reloadTime);
            };
            
        request.ontimeout = function() {
            vBoard.innerHTML = "Server timeout, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshAgvs, reloadTime);
        };
        
        request.onerror = function() { 
            vBoard.innerHTML = "No server reply, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshAgvs, reloadTime);
        };
        
  	request.open("GET", "/agvs", true);
	request.timeout = reloadTime;
  	request.send();
	}




const reloadTime =3000;;