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
const PASSWORD_REQUIRED = "No puede dejar este campo en blanco";

const checkUser = async(u,p) => {
    let request = await fetch("/api/v1/users/check?" + new URLSearchParams({
        u_username: u,
        u_password: p,
    }))

    if(request.status == 200) {
      let dato = await request.json();
      if(dato.length == 0)
      {
          alert("Error: Se ha equivocado en el login");
      }
      else {
            window.location = "admin.html?u_username=" + encodeURIComponent(dato[0].u_username) + "&u_password=" + encodeURIComponent(dato[0].u_password);
      }
    }
}


$("#submit").on("click", async () => {
    let username = form.elements["username"];
    let password = form.elements["password"];

    let usernameValid = hasValue(username, USERNAME_REQUIRED);
    let passwordValid = hasValue(password, PASSWORD_REQUIRED);
    
    if(usernameValid && passwordValid)
    {
        await checkUser(username.value,password.value);
        //console.log(number);
    }
});

$("#backup").on("click", async () => {
    window.location = "backup.html";
});