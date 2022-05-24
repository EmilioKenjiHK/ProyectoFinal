window.onload = async() => {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;

    //console.log(params);
    let u = params[0].split('=')[1];
    //let p = params[1].split('=')[1];
    
    const w = document.getElementById('welcome');
    //console.log(w);
    w.appendChild(document.createTextNode("OBJETOS: " + u));

    let request = await fetch("/api/v1/objects/list");

    if(request.status == 200)
    {
        const div = document.getElementById("info");
        const fin = document.getElementById("final");
        let dato = await request.json();
        for(i = 0; i<dato.length; i++)
        {
            const para = document.createElement("div");

            const name = document.createTextNode("Nombre: " + dato[i].name + "\n");
            const desc = document.createTextNode("Descripcion: " + dato[i].desc + "\n");
            const price = document.createTextNode("Precio: " + dato[i].price + "\n");
            const quantity = document.createTextNode("Cantidad: " + dato[i].quantity);

            para.appendChild(name);
            para.appendChild(desc);
            para.appendChild(price);
            para.appendChild(quantity);

            div.insertBefore(para,fin);
        }
        
    }
}

const keepUser = async(u,p) => {
    let request = await fetch("/api/v1/users/check?" + new URLSearchParams({
        u_username: u,
        u_password: p,
    }))

    if(request.status == 200) {
      let dato = await request.json();
      window.location = "admin.html?u_username=" + encodeURIComponent(dato[0].u_username) + "&u_password=" + encodeURIComponent(dato[0].u_password);
    }
}


$("#atras").on("click", async () => {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;

    let username = params[0].split('=')[1];
    let password = params[1].split('=')[1];

    await keepUser(username,password);

});