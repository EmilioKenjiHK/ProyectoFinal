const updateFeature = async(h,o,n) => {
    let request = await fetch("/api/v1/users", {
        method: "PUT",
        body: h+","+o+","+n,
        credentials: "same-origin",
        headers: {
            "Content-Type": "application/json", // formato String
        },
        dataType: "json",
    });

    if(request.status == 200) {
        alert("Se ha actualizado la informacion. Se resetea el login");
        window.location = "login.html";
    }
}

function changeFeature(event) {
    const button = event.target;
    //console.log(button.id.split('0')[0]);
    let item = document.getElementById(button.id.split('0')[0]);
    //console.log(item.value);

    updateFeature(item.id,item.placeholder,item.value);
  }


window.onload = async() => {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;

    //console.log(params);
    let u = params[0].split('=')[1];
    let p = params[1].split('=')[1];

    let request = await fetch("/api/v1/users/check?" + new URLSearchParams({
        u_username: u,
        u_password: p,
    }))

    if(request.status == 200) {
        const div = document.getElementById("info");
        const fin = document.getElementById("final");
        let dato = await request.json();

        const name = document.createElement("div");
        const pass = document.createElement("div");
        const mail = document.createElement("div");

        name.className = "text-center";
        pass.className = "text-center";
        mail.className = "text-center";


        // Username

        const u = document.createTextNode("Nombre: " + dato[0].u_username + "\n");
        const a0 = document.createElement("input");
        a0.type = "text";
        a0.id = "u_username";
        a0.size = "100";
        a0.maxlength = "100";
        a0.placeholder = dato[0].u_username;
        const btn0 = document.createElement("button");
        btn0.className = "item-button btn btn-primary";
        btn0.id = "u_username0";
        btn0.appendChild(document.createTextNode("Cambiar"));
        btn0.addEventListener('click', changeFeature);

        name.appendChild(u);
        name.appendChild(a0);
        name.appendChild(btn0);


        // Password
        const p = document.createTextNode("Apellido: " + dato[0].u_password + "\n");
        const a1 = document.createElement("input");
        a1.type = "text";
        a1.id = "u_password";
        a1.size = "100";
        a1.maxlength = "100";
        a1.placeholder = dato[0].u_password;
        const btn1 = document.createElement("button");
        btn1.className = "item-button btn btn-primary";
        btn1.id = "u_password0"
        btn1.appendChild(document.createTextNode("Cambiar"));
        btn1.addEventListener('click', changeFeature);

        pass.appendChild(p);
        pass.appendChild(a1);
        pass.appendChild(btn1);

        // E-mail
        const e = document.createTextNode("Correo: " + dato[0].u_email + "\n");
        const a2 = document.createElement("input");
        a2.type = "text";
        a2.id = "u_email";
        a2.size = "100";
        a2.maxlength = "100";
        a2.placeholder = dato[0].u_email;
        const btn2 = document.createElement("button");
        btn2.className = "item-button btn btn-primary";
        btn2.id = "u_email0";
        btn2.appendChild(document.createTextNode("Cambiar"));
        btn2.addEventListener('click', changeFeature);

        mail.appendChild(e);
        mail.appendChild(a2);
        mail.appendChild(btn2);

        div.insertBefore(name,fin);
        div.insertBefore(pass,fin);
        div.insertBefore(mail,fin);
    }
    
    //console.log(u);
    //console.log(p);

    const w = document.getElementById('welcome');
    //console.log(w);
    w.appendChild(document.createTextNode("MODIFICACION PERFIL: " + u));

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

