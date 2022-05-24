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

const OPINION_REQUIRED = "No puede dejar la opinión en blanco";

const idOpinion = async() => {
    let request = await fetch("/api/v1/opinions");
    if(request.status == 200) {
        let dato = await request.json();
        //console.log(dato);
        let counter = 1;
        for(i = 0; i<dato.length; i++)
        {
            counter++;
        }
        return counter;

    }
}

const sendData = async(n,o) => {

    //console.log(n);
    //console.log(o);

    let request = await fetch("/api/v1/opinions", {
        method: "POST",
        body: JSON.stringify({
            op_id: n,
            op_text: o,
        }),
        credentials: "same-origin",
        headers: {
            "Content-Type": "application/json", // formato JSON
        },
        dataType: "json",
    });

    if(request.status == 200) {
        alert("Muchas gracias por tu opinion!!");
    }
}

$("#submit").on("click", async () => {
    let opinion = form.elements["opinion"];

    let opinionValid = hasValue(opinion, OPINION_REQUIRED);
    
    if(opinionValid)
    {
        let number = await idOpinion();
        //console.log(number);
        sendData(number,opinion.value);
    }
});