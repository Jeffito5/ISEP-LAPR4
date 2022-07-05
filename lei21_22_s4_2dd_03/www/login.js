function loginAction() {

    const username = document.getElementById("uname").value;
    const password = document.getElementById("psw").value;
    const request = new XMLHttpRequest();
    var vBoard = document.getElementById("result");
    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";

    };

    request.open("GET", "/login/"+username+"-"+password, true, username, password);
    request.send();
}

function next() {
    location.replace("WarehouseInfo.html");
}