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

const OPINION_REQUIRED = "No puede dejar la opinión en blanco";

const sendData = async(n,ln,g,o) => {

    //console.log(n);
    //console.log(ln);
    //console.log(g);
    //console.log(o);

    let request = await fetch("/cuestionario", {
        method: "POST",
        body: JSON.stringify({
            name: n,
            lname: ln,
            genero: g,
            opinion: o,
        }),
        credentials: "same-origin",
        headers: {
            "Content-Type": "application/json", // formato JSON
        },
        dataType: "json",
    });

    if(request.status == 200) {
        alert("Cuestionario Enviado, Si gustaria acceder las respuestas de otros, pulsa el boton: 'Respuestas Previas'");
    }
}

$("#submit").on("click", () => {
    let opinion = document.getElementById("opinion");
    let opinionValid = hasValue(opinion, OPINION_REQUIRED);

    // Para id de Opinion
    let request = await fetch("/api/v1/opinions");
    if(request.status == 200) {
        let dato = request.json();
        console.log(data.length);
    }
    
    if(opinionValid)
    {
        //sendData(opinion.value);
    }
});