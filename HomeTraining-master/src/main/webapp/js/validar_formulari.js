/**
 * @fileoverview Arxiu que fa la validació i enviament de dades d'un formulari de registre d'usuari
 * @version 3.2
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v3.1 - S'incorpora l'enviament de dades a l'API de login d'usuari
 * v2.2 - Es fa la validació del formulari de Login
 * v2.1 - Es fa l'enviament de dades a l'API del registre d'usuari
 * v1.1. - Es fa la validació del formulari de registre
 */

// variables de només lectura
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id
const inputs = document.querySelectorAll('#form input'); //captura tots els input del formulari i el guarda en un array

const expresions = {
	
	text: /^[a-zA-ZÀ-ÿ\s]{2,40}$/, // Permet lletres i espais fins un màxim de 40 caràcters
	password: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/, // Ha de tener uno o más números, una letra mayúscula, una letra minúscula y 8 o más caracteres.
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Ha de ser una combinació de lletres o nombres + l'arroba + més text en llebres o nombres + un punt + més text
	telefon: /[0-9]{9}/, // Ha de contenir 9 nombres separats de 3 en 3 per un guió.
    codpost: /0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}/, // Ha de ser un nombre comprès entre 01000 i 52999
    adreca: /^[a-zA-Z0-9À-ÿ\s0-9\/\-\.]{3,40}$/ // Letras, numeros, guion, punto y barra
}
//objecte que conté tots els camps que s'enviaran al servidor
const camps = {
	nom: false,
	cognom1: false,
	cognom2: false,
	email: false,
	dni: false,
	telefon: false,
	adreca: false,
	codpost: false,
	poblacio: false,
	provincia: false,
	password: false,
	isEntrenador: false,
	active: false,
	username: false,
	data_alta: false
}
//valors dels camps
const campsValor = {
	nom: "",
	cognom1: "",
	cognom2: "",
	email: "",
	dni: "",
	telefon: "",
	adreca: "",
	codpost: "",
	poblacio: "",
	provincia: "",
	password: "",
	isEntrenador: "",
	username: "",
	active: true,
	data_alta: Date.now()
}

//Comprovem en quin imput està per aplicar la funció de validació
const validarformulari = (e) => {
	switch (e.target.name) {
		case "nom":
			validarCamp(expresions.text, e.target, 'nom');
		break;
		case "cognom1":
			validarCamp(expresions.text, e.target, 'cognom1');
		break;
		case "cognom2":
			validarCamp(expresions.text, e.target, 'cognom2');
		break;
		case "email":
			validarCamp(expresions.email, e.target, 'email');
		break;
		case "dni":
			validarCamp(expresions.text, e.target, 'dni');
			validarDNI(e.target.name);
		break;
		case "telefon":
			validarCamp(expresions.telefon, e.target, 'telefon');
		break;
		case "adreca":
			validarCamp(expresions.adreca, e.target, 'adreca');
		break;
		case "codpost":
			validarCamp(expresions.codpost, e.target, 'codpost');
		break;
		case "poblacio":
			validarCamp(expresions.text, e.target, 'poblacio');
		break;
		case "provincia":
			validarCamp(expresions.text, e.target, 'provincia');
		break;
		case "password":
			validarCamp(expresions.password, e.target, 'password');
			validarPassword2();
		break;
		case "passwordRep":
			validarPassword2();
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
}
/** 
 * @function validarDNI Validem el DNI i el seu valor
 * @param {string} la funció rep un valor de tipus string entrat per l'usuari en el formulari camp "dni"
 * @returns {function comprovarDNI(dni.value)} Crida a una nova function que fa les tasques de comprovació de dades
*/
function validarDNI(dni){
        var dni = document.getElementById('dni');
        return comprovarDni(dni.value);
    }

/** 
 * @function comprovarDNI Validem del DNI el seu valor
 * @param {string} la funció rep un valor de tipus string 
 * @returns {boolean)} Retorna un valor true o false en camps.dni i inserta el valor del dni en campsValor
*/
function comprovarDni(dni){
    var nombre,
        lletraIntroduida,
        lletraEsperada,
  
    nombre = dni.substr(0, dni.length-1); //Extraiem el nombre
    lletraIntroduida = dni.substr(dni.length-1, 1) //Extraiem la lletra
    nombre = nombre % 23;
    lletraEsperada = "TRWAGMYFPDXBNJZSQVHLCKET"; //Valors de la lletra ordenats per la posició corresponent
    lletraEsperada = lletraEsperada.substring(nombre, nombre+1);
  
    if (lletraEsperada === lletraIntroduida.toUpperCase()){
        document.getElementById(`dni`).classList.remove('formulari__grup-incorrecto');
		document.getElementById(`dni`).classList.add('formulari__grup-correcto');
		document.querySelector(`#dni + .formulari__input-error`).classList.remove('formulari__input-error-activo');
		camps['dni'] = true;
		campsValor['dni'] = dni;
    } else {
        document.getElementById(`dni`).classList.add('formulari__grup-incorrecto');
		document.getElementById(`dni`).classList.remove('formulari__grup-correcto');
		document.querySelector(`#dni + .formulari__input-error`).classList.add('formulari__input-error-activo');
		camps['dni'] = false;
    }
}
/** 
 * @function validarPassword2 
 * @returns {boolean} Retorna un valor true o false en camps.password i inserta el valor del password en campsValor
*/
const validarPassword2 = () => {
	const inputPassword1 = document.getElementById('password');
	const inputPassword2 = document.getElementById('passwordRep');

	if(inputPassword1.value !== inputPassword2.value){
		document.getElementById(`passwordRep`).classList.add('formulari__grup-incorrecto');
		document.getElementById(`passwordRep`).classList.remove('formulari__grup-correcto');
		document.querySelector(`#passwordRep + .formulari__input-error`).classList.add('formulari__input-error-activo');
		camps['password'] = false;
	} else {
		document.getElementById(`passwordRep`).classList.remove('formulari__grup-incorrecto');
		document.getElementById(`passwordRep`).classList.add('formulari__grup-correcto');
		document.querySelector(`#passwordRep + .formulari__input-error`).classList.remove('formulari__input-error-activo');
		camps['password'] = true;
		campsValor['password'] = inputPassword1.value;
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

	//si tots els camps del formulari han estat validats i està fet check en acceptar els termens, s'envia la informació
	const aceptarTerminos = document.getElementById('customCheck1');

	if(camps.nom && camps.cognom1 && camps.cognom2 && camps.email && camps.dni && camps.telefon && camps.adreca && camps.codpost && camps.poblacio && camps.provincia && camps.password && camps.telefon && aceptarTerminos.checked ){
		//Campturem del DOM l'id que conté la informació de si l'usuari que es registra és entrenador o no
		const esEntrenador = document.getElementById('isEntrenador');
		if (esEntrenador.checked){
			campsValor['isEntrenador']=true;
		} else {
			campsValor['isEntrenador']=false;
		}
		//convertim en valor numeric els camps de telefon i codi postal
		let valorStringTelefon = campsValor.telefon;
		let valorInt = parseInt(valorStringTelefon);
		campsValor.telefon = valorInt;

		let valorStringCodpost = campsValor.codpost;
		valorInt = parseInt(valorStringCodpost);
		campsValor.codpost = valorInt;

		campsValor.data_alta = Date.now();

		//Cridem diferents funcions per enviar les dades a la taula usuaris i login 
		SendDataRegister(campsValor);
		// SendDataLogin(campsValor);

        // Afegim una informació conforme el formulari ha estat omplert correctament
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

/** 
 * @function SendDataRegister Enviem de forma asincrona amb async await les dades de registre a la tabla Usuaris
 * @param {object} rep el json amb tots els valors dels diferents camps del formulari, un cop ja validats
 * @returns {void} Retorna una resposta 200 en cas d'exit en l'enviament de dades o altres errors que captura el catch i envia per pantalla
*/

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function SendDataRegister(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/addUsuari";

	
	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;
        console.log(json);
		
		SendDataLogin(campsValor);

    } catch (err) {
        location.reload();
		let message = err.statusText || "Ocurrió un error en el registro registro";
        console.log(err)
		alert('Error' + ': ' + err);
      }
}

/** 
 * @function SendDataLogin Enviem de forma asincrona amb async await les dades de registre a la tabla Login
 * @param {object} rep el json amb tots els valors dels diferents camps del login, un cop ja validats
 * @returns {void} Retorna una resposta 200 en cas d'exit en l'enviament de dades o altres errors que captura el catch i envia per pantalla
*/

async function SendDataLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/addLogin";
	
	camps.username=camps.email;
	let username = camps.username;
	let password = camps.password;
	let dni = camps.dni;

	let campsLogin={
		"username": username,
		"password": password,
		"dni": dni
	}
	console.log (campsLogin);
	
	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        	data: JSON.stringify(campsLogin,)
		
        },
		res = await axios(URL, options),
		json = await res.data;
		alert('Usuari registrat')
		window.location.replace("../web-pages/login.html")


    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        location.reload();
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}
