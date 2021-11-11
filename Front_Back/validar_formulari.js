

// variables de només lectura
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id
const inputs = document.querySelectorAll('#form input'); //captura tots els input del formulari i el guarda en un array

const expresions = {
	
	text: /^[a-zA-ZÀ-ÿ\s]{2,40}$/, // Permet lletres i espais fins un màxim de 40 caràcters
	password: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/, // Ha de tener uno o más números, una letra mayúscula, una letra minúscula y 8 o más caracteres.
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Ha de ser una combinació de lletres o nombres + l'arroba + més text en llebres o nombres + un punt + més text
	telefon: /[0-9]{3}-[0-9]{3}-[0-9]{3}/, // Ha de contenir 9 nombres separats de 3 en 3 per un guió.
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
	codpost: false,
	poblacio: false,
	provincia: false,
	password: false,
	isentrenador: false,
	active: false
}

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
	isentrenador: "",
	active: false

}

//Comrpovem en quin imput està per aplicar la funció de validació
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
//Validem el DNI
function validarDNI(dni){
        var dni = document.getElementById('dni');
        return comprovarDni(dni.value);
    }
    
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
//Validem la confirmació del password
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

	const aceptarTerminos = document.getElementById('customCheck1');
	if(camps.nom && camps.cognom1 && camps.cognom2 && camps.email && camps.dni && camps.telefon && camps.adreca && camps.codpost && camps.poblacio && camps.provincia && camps.telefon && aceptarTerminos.checked ){
        console.log(campsValor);

		const esEntrenador = document.getElementById('isentrenador');
		if (esEntrenador.checked){
			campsValor['isentrenador']=true;
		} else {
			campsValor['isentrenador']=false;
		}

		SendDataRegister(campsValor);

        formulario.reset();
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

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function SendDataRegister(camps){
	
    // console.log(camps);
    const URL = "https://Localhost:8080/ProvaProjecteDAW/api/"
    try {
        
        let options = {
          method: "POST",
          headers: {
            "Content-type": "application/json; charset=utf-8"
          },
          data: JSON.stringify({
            camps
          })
        },
          res = await axios(URL, options),
          json = await res.data;
          console.log(json);

        location.reload();
      } catch (err) {
        let message = err.statusText || "Ocurrió un error en el registro";
        alert('Error' + ': ' + message);
      }
}

