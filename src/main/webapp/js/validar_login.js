/**
 * @fileoverview Arxiu que fa la validació del Login d'usuari
 * @version 1.2
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la validació del formulari de login
 */

// variables de només lectura
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id
const inputs = document.querySelectorAll('#form input'); //captura tots els input del formulari i el guarda en un array
//Variable contador per valorar el nombre d'intents en els login
let contador = 2; //
let email = document.getElementById('email');

const expresions = {
	password: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/, // Ha de tener uno o más números, una letra mayúscula, una letra minúscula y 8 o más caracteres.
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Ha de ser una combinació de lletres o nombres + l'arroba + més text en llebres o nombres + un punt + més text
}

const camps = {
	email: false,
	password: false,
}

const campsValor = {
	email: "",
	password: "",
}

//Comprovem en quin imput està per aplicar la funció de validació
const validarformulari = (e) => {
	switch (e.target.name) {
		case "email":
			validarCamp(expresions.email, e.target, 'email');
		break;
		case "password":
			validarCamp(expresions.password, e.target, 'password');
		break;

	}
}

//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarCamp = (expresion, input, camp) => {
    
	if(expresion.test(input.value)){
     
		document.getElementById(`${camp}`).classList.remove('formulari__grup-incorrecto');
		document.getElementById(`${camp}`).classList.add('formulari__grup-correcto');
        document.querySelector(`#${camp} + .formulari__input-error`).classList.remove('formulari__input-error-activo');
		camps[camp] = true;
		campsValor[camp] = input.value;
	
	} else {
		document.getElementById(`${camp}`).classList.add('formulari__grup-incorrecto');
		document.getElementById(`${camp}`).classList.remove('formulari__grup-correcto');
		document.querySelector(`#${camp} + .formulari__input-error`).classList.add('formulari__input-error-activo');
		camps[camp] = false;
	}
	if ((camp=='email')&&(input.value=='admin')){
		camps[camp] = true;
		campsValor[camp] = input.value;
		email.setAttribute('type','text');
	} else if ((camp=='password')&&(input.value=='admin')){
		camps[camp] = true;
		campsValor[camp] = input.value;
	}
}

//Recorrem els inputs per veure en quin moment s'aplica un event
inputs.forEach((input) => {
	input.addEventListener('keyup', validarformulari);
	input.addEventListener('blur', validarformulari);
});

//Si es fa un submit s'envia la informació si tots els camps estan omplerts i acceptat els termes
formulario.addEventListener('submit', (e) => {
	e.preventDefault();

    if(camps.email && camps.password){

		//Si password i login correspon a l'administrador anem a la seva pagina
		if((campsValor.email=="admin")&&(campsValor.password=="admin")){
			window.location.replace("../web-pages/administrador.html");
		}

		//Cridem el login
		LoginAccept(campsValor);

        // formulario.reset();
		document.getElementById('formulari__mensaje-exito').classList.add('formulari__mensaje-exito-activo');
		setTimeout(() => {
			document.getElementById('formulari__mensaje-exito').classList.remove('formulari__mensaje-exito-activo');
		}, 5000);

		document.querySelectorAll('.formulari__grup-correcto').forEach((icono) => {
			icono.classList.remove('formulari__grup-correcto');
		});
	} else {
		document.getElementById('formulari__mensaje').classList.add('formulari__mensaje-activo');
	}
});

async function LoginAccept(name){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/getLogin";
    let userEmail = document.getElementById('email').value;
    let userPassword = document.getElementById('password').value;
    let comprovacio = true;

    let campsLoginOk ={
        "username": userEmail,
        "password": userPassword
    }

    
// Funciona pero es get
	try {
		let options = {
            method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
		  	},

        	body: campsLoginOk,
        },
		res = await axios(URL,options),
		json = await res.data;
        console.log(json);
        comprovacio=false;
;

        for (let i = 0 ; i < json.length ; i++){
            if ((json[i].username == userEmail) && (json[i].password == userPassword)){
                alert('USUARI REGISTRAT');
                comprovacio=true;
				localStorage.setItem('login', JSON.stringify(json[i]));
				window.location.replace("../web-pages/usuario.html");
			} 
		}

	console.log(comprovacio);

	if (comprovacio==false){
		// alert('DADES INCORRECTES');
		let texto ='Dadas inexistentes. Revisa usuario o contraseña';
		let nuevoIntento = confirm(texto);
		console.log(nuevoIntento)
	}

}     catch (err) {
	//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
	// location.reload();
	let message = err.statusText || "S'ha produit un error en el registre usuari";
	console.log(err);
}

}

