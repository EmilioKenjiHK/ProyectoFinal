const form = document.querySelector("#signup");

// show a message with a type of the input
const showMessage = (input, message, type) => {
	// get the small element and set the message
	const msg = input.parentNode.querySelector("small");
	msg.innerText = message;
	// update the class for the input
	input.className = type ? "success" : "error";
	return type;
}

const showError = (input, message) => {
	return showMessage(input, message, false);
}

const showSuccess = (input) => {
	return showMessage(input, "", true);
}

const hasValue = (input, message) => {
	if (input.value.trim() === "") {
		return showError(input, message);
	}
	return showSuccess(input);
}

const USERNAME_REQUIRED = "No puede dejar este campo en blanco";

const getPassword = async(u) => {
    let request = await fetch("/api/v1/users/backup?" + new URLSearchParams({
        u_username: u,
    }))

    if(request.status == 200) {
      let dato = await request.json();
      if(dato.length == 0)
      {
        alert("Error: No ha puesto bien el Nombre del Usuario.");
      }
      else {
        alert("Contraseña: " + dato[0]);
      }
    }
}


$("#submit").on("click", async () => {
    let username = form.elements["username"];

    let usernameValid = hasValue(username, USERNAME_REQUIRED);
    
    if(usernameValid)
    {
        await getPassword(username.value);
        //console.log(number);
    }
});

$("#back").on("click", async () => {
    window.location = "login.html";
});