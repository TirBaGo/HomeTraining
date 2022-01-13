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

//Recuperamos valor del usuari
const usuario = JSON.parse(localStorage.getItem('login'));

const nom = document.getElementById('nom');
const cognom1 = document.getElementById('cognom1');
const cognom2 = document.getElementById('cognom2');
const email = document.getElementById('email');
const telefon = document.getElementById('telefon');
const adreca = document.getElementById('adreca');
const cp = document.getElementById('cp');
const poblacio = document.getElementById('poblacio');
const provincia = document.getElementById('provincia');
const password = document.getElementById('password');
const passwordRep = document.getElementById('passwordRep');

const inputs = document.querySelectorAll('#form input'); //captura tots els input del formulari i el guarda en un array
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id
let datos = document.getElementById('datos');
const logout = document.getElementById('logout');


let usuariContrasenya = "";

const expresions = {
	
	text: /^[a-zA-ZÀ-ÿ\s]{2,40}$/, // Permet lletres i espais fins un màxim de 40 caràcters
	password: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/, // Ha de tener uno o más números, una letra mayúscula, una letra minúscula y 8 o más caracteres.
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Ha de ser una combinació de lletres o nombres + l'arroba + més text en llebres o nombres + un punt + més text
	telefon: /[0-9]{9}/, // Ha de contenir 9 nombres separats de 3 en 3 per un guió.
    codpost: /0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}/, // Ha de ser un nombre comprès entre 01000 i 52999
    adreca: /^[a-zA-Z0-9À-ÿ\s0-9\/\-\.]{3,40}$/ // Letras, numeros, guion, punto y barra
}
const camps = {
	nom: false,
	cognom1: false,
	cognom2: false,
	email: false,
	dni: false,
	telefon: false,
	adreca: false,
	poblacio: false,
	provincia: false,
	password: false,
	isEntrenador: false,
	active: true,
	username: false,
	data_alta: false
}

const campsValorNueva = {
    id_usuari: "",
	nom: "",
	cognom1: "",
	cognom2: "",
	email: "",
	dni: "",
	telefon: "",
	adreca: "",
	poblacio: "",
	provincia: "",
	password: "",
	isEntrenador: "",
	active: true,
}

const campsValorOriginal = {
    id_usuari: "",
	nom: "",
	cognom1: "",
	cognom2: "",
	email: "",
	dni: "",
	telefon: "",
	adreca: "",
	poblacio: "",
	provincia: "",
	password: "",
	isEntrenador: "",
	active: true,
	data_alta: ""
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
		camps[camp] = true;
		campsValorNueva[camp] = input.value;
	} else {
        document.getElementById(`${camp}`).classList.add('formulari__grup-incorrecto');
		document.getElementById(`${camp}`).classList.remove('formulari__grup-correcto');
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
 * @returns {boolean)} Retorna un valor true o false en camps.dni i inserta el valor del dni en campsValorNueva
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
		camps['dni'] = true;
		campsValorNueva['dni'] = dni;
    } else {
		camps['dni'] = false;
    }
}
/** 
 * @function validarPassword2 
 * @returns {boolean} Retorna un valor true o false en camps.password i inserta el valor del password en campsValorNueva
*/
const validarPassword2 = () => {
	const inputPassword1 = document.getElementById('password');
	const inputPassword2 = document.getElementById('passwordRep');

	if(inputPassword1.value !== inputPassword2.value){
		camps['password'] = false;
	} else {
		camps['password'] = true;
		campsValorNueva['password'] = inputPassword1.value;
	}
}
validarPassword2()
//Recorrem els inputs per veure en quin moment s'aplica un event
inputs.forEach((input) => {
	input.addEventListener('keyup', validarformulari);
	input.addEventListener('blur', validarformulari);
});

formulario.addEventListener('submit', (e) => {
	e.preventDefault();
	console.log(camps)
	if(camps.password){
		//convertim en valor numeric els camps de telefon i codi postal
		let valorStringTelefon = campsValorNueva.telefon;
		let valorInt = parseInt(valorStringTelefon);
		campsValorNueva.telefon = valorInt;

		//Cridem diferents funcions per enviar les dades a la taula usuaris i login 
        modifiquemValor('nom');
        modifiquemValor('cognom1');
        modifiquemValor('cognom2');
        modifiquemValor('email');
        modifiquemValor('adreca');
        modifiquemValor('active');
        modifiquemValor('dni');
        modifiquemValor('isEntrenador');
        modifiquemValor('password');
        modifiquemValor('poblacio');
        modifiquemValor('provincia');
        modifiquemValor('telefon');

		console.log(campsValorOriginal)

		SendDataChange(campsValorOriginal);
        // window.location.replace('../web-pages/entrenador.html')

	} else {
		alert('LAS CONTRASEÑAS NO COINCIDEN')
	}
});

function modifiquemValor (camp){
    if(campsValorOriginal[camp] !== campsValorNueva[camp]){
        if (campsValorNueva[camp] !== ""){
            campsValorOriginal[camp]=campsValorNueva[camp]
        }
    }
	console.log(campsValorNueva)
	console.log(campsValorOriginal)
}


//Cridem les dades d'usuari
async function consultaDadesUsuaris(){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";
	console.log(camps);
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;

		const dniUsuari = usuario.dni;
		
		SendLocalitzaLogin(campsValorOriginal)

        for (let i = 0 ; i < json.length ; i++){
            if ((json[i].dni == dniUsuari)){
				console.log(json[i])
				const dades = json[i];
				datos.innerHTML = dades.nom + " " + dades.cognom1;
                campsValorOriginal['dni'] = dniUsuari;
                console.log('USUARI TROBAT');
                nom.value = json[i].nom;
                campsValorOriginal['nom'] = nom.value;
                cognom1.value = json[i].cognom1;
                campsValorOriginal['cognom1'] = cognom1.value;
                cognom2.value = json[i].cognom2;
                campsValorOriginal['cognom2'] = cognom2.value;
                email.value = json[i].email;
                campsValorOriginal['email'] = email.value;
                telefon.value = json[i].telefon;
                campsValorOriginal['telefon'] = telefon.value;
                adreca.value = json[i].adreca;
                campsValorOriginal['adreca'] = adreca.value;
                poblacio.value = json[i].poblacio;
                campsValorOriginal['poblacio'] = poblacio.value;
                provincia.value = json[i].provincia;
                campsValorOriginal['provincia'] = provincia.value;
                campsValorOriginal['data_alta'] = json[i].data_alta;
                campsValorOriginal['isEntrenador'] = json[i].isEntrenador;
                campsValorOriginal['id_usuari'] = json[i].id_usuari;
				console.log(json[i])
                }
            }
			SendPrintLogin(campsValorOriginal)
		} catch (err) {
        location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function SendDataChange(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/modifyUsuari";
	try {
		let options = {
          	method: "PUT",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;
        alert('CANVI REALITZAT!');

		SendDataLogin(campsValorOriginal)

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro registro";
        console.log(err)
		console.log('Error' + ': ' + err);
      }
}

async function SendPrintLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/getLogin";
	
	camps.username=camps.email;
	let username = camps.username;
	let passwordloc = camps.password;
	let dni = camps.dni;

	let campsLogin={
		"username": username,
		"password": passwordloc,
		"dni": dni
	}
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

			  data: campsLogin,
		
        },
		res = await axios(URL, options),
		json = await res.data;
		

		for(let i=0; i<json.length; i++){
			if(json[i].username == username){
				campsValorOriginal['password']=json[i].password;
				password.value = json[i].password;
				passwordRep.value = json[i].password;

			}
		}


    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}

async function SendLocalitzaLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/getLogin";
	
	camps.username=camps.email;
	let username = camps.username;
	let password = camps.password;
	let dni = camps.dni;

	let campsLogin={
		"username": username,
		"password": password,
		"dni": dni
	}
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

			  data: campsLogin,
		
        },
		res = await axios(URL, options),
		json = await res.data;
		

		for(let i=0; i<json.length; i++){
			if(json[i].username == username){
				SendEsborraLogin(json[i]);
			} 
		}

    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}

async function SendEsborraLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/deleteLogin";
	try {
		let options = {
          	method: "DELETE",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro registro";
        console.log(err)
		console.log('Error' + ': ' + err);
      }
}

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
	
	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        	data: JSON.stringify(campsLogin)
		
        },
		res = await axios(URL, options),
		json = await res.data;
		localStorage.setItem('login', JSON.stringify(campsLogin));



    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        location.reload();
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}

logout.addEventListener('click', function sortirApp(){
    datos.innerHTML = ("Datos");
    localStorage.clear();
});

consultaDadesUsuaris();