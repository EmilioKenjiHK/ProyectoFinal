window.onload = function () {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    
    let u = params[0].split('=')[1];
    let p = params[1].split('=')[1];
    
    //console.log(u);
    //console.log(p);

    const w = document.getElementById('welcome');
    //console.log(w);
    w.appendChild(document.createTextNode("BIENVENIDO " + u));

}

const keepUser = async(u,p,s) => {
    let request = await fetch("/api/v1/users/check?" + new URLSearchParams({
        u_username: u,
        u_password: p,
    }));

    if(request.status == 200) {
      let dato = await request.json();
      window.location = s+".html?u_username=" + encodeURIComponent(dato[0].u_username) + "&u_password=" + encodeURIComponent(dato[0].u_password);
    }
}


$("#perfil").on("click", async () => {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    
    let username = params[0].split('=')[1];
    let password = params[1].split('=')[1];

    await keepUser(username,password,"profile");

});

$("#objetos").on("click", async () => {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    
    let username = params[0].split('=')[1];
    let password = params[1].split('=')[1];

    await keepUser(username,password,"objects");

});

