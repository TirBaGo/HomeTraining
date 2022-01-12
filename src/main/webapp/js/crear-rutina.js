/**
 * @fileoverview Arxiu que recull les dades de selecció de rutina per l'usuari
 * @version 1.0
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la recollida de dades des de la selecció de rutina
 */

// variables de només lectura
const formulario = document.getElementById('form'); //captura les opcions de la rutina creada
const selects = document.querySelectorAll('#form select'); //captura tots els selects del formulari i el guarda en un array
const categoria = document.getElementById('categoria');
const accessori = document.getElementById('accessori');
const nivell = document.getElementById('nivell');
const duracio = document.getElementById('duracio');
const preu = document.getElementById('preu');
const video = document.getElementById('video');
const descripcio = document.getElementById('descripcio');
const imatge = document.getElementById('imatge');
const boton = document.getElementById('boton');

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";
//getUsuaris para catpar si es entrenador
const URLEntrenador = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";
//getModalitats para captar la modalitat
const URLModalitat = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/getModalitats";
//getAccessoris para captar los accessoris
const URLAccessoris = "http://localhost:8080/ProvaProjecteDAW/api/accessori/getAccessoris";

const login = JSON.parse(localStorage.getItem('login'));
let datos = document.getElementById('datos');
const logout = document.getElementById('logout');


// //objecte que conté tots els camps que conté la rutina buscada
const rutinaSeleccionada = {
    nom: true,
	nom_modalitat: false,
	dni_entrenador: true,
	nom_accessori: false,
	duracio: false,
	nivell: false,
    active: false,
    preu: false,
    descripcio: false,
    imatge: false,
    video: false,

}
// //valors dels camps
const rutinaValors = {
    nom: "",
	nom_modalitat: "",
	dni_entrenador: "",
	nom_accessori: "",
	duracio: "",
	nivell: "",
    preu: "",
    active: true,
    descripcio: null,
    imatge: "",
    video: "",
}

//Programacion de rellenado de los select
    let llistaEntrenadors=[];
    let llistaModalitats=[];
    let llistaAccessoris=[];
    let rutinaControl=[];
    let contador = 0;
    let compteOpcions=0;

    let selectModalitat = document.getElementById('categoria');
    let selectEntrenador = document.getElementById('entrenador');
    let selectAccessoris = document.getElementById('accessori');

window.onload = function (){
    ompleSelect();
}

const opcioEscollida = (e) => {
    let selectEscollit = e.target.id;
    	switch (selectEscollit) {
		case "categoria":
			validarSelect(e.target, 'nom_modalitat');
		break;
		case "accessori":
			validarSelect(e.target, 'nom_accessori');
		break;
		case "duracio":
			validarSelect(e.target, 'duracio');
		break;
		case "nivell":
			validarSelect(e.target, 'nivell');
		break;
        case "duracio":
			validarSelect(e.target, 'temps');
		break;
        case "preu":
			validarSelect(e.target, 'preu');
		break;
        case "video":
			validarSelect(e.target, 'video');
		break;
        case "imatge":
			validarSelect(e.target, 'imatge');
		break;

        }
	}


//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarSelect = (select, opcio) => {
    if(select.options.selectedIndex!==0){  
            rutinaSeleccionada[opcio] = true;
            if (descripcio.value !== ""){
                rutinaSeleccionada['descripcio'] = true;
                rutinaValors['descripcio'] = descripcio.value;
            }
            rutinaValors[opcio] = select.value;
        } else {
            rutinaSeleccionada[opcio] = false;
            rutinaValors[opcio] = "";
        }
        console.log(rutinaValors)
    escullSelect(rutinaValors); 
}
    
// Programa de pintar
async function ompleSelect(){
    //Capturar rutinas
    try {
        let options={
            method: "GET",
            headers: {
                "Content-type": "application/json; charset=utf-8",
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
            }                                
        },
        resRutina = await axios (URLRutinas, options),
        resEntrenador = await axios (URLEntrenador, options),
        resModalitat = await axios (URLModalitat, options),
        resAccessoris = await axios (URLAccessoris, options),

        jsonRutina = await resRutina.data;
        jsonEntrenador = await resEntrenador.data;
        jsonModalitat = await resModalitat.data;
        jsonAccessoris = await resAccessoris.data;

        //Modalitat
        for (let i = 0; i<jsonModalitat.length; i++){
            if (jsonModalitat[i].nom){
                llistaModalitats.push(jsonModalitat[i].nom);
            } 
        }

        let optModalitat="";

        for (let i=0; i<llistaModalitats.length; i++){
            optModalitat = document.createElement('option');
            optModalitat.value = llistaModalitats[i];
            optModalitat.innerHTML = llistaModalitats[i];
            selectModalitat.appendChild(optModalitat);
        }

        //Accessoris
        for (let i = 0; i<jsonAccessoris.length; i++){
            if (jsonAccessoris[i].nom){
                llistaAccessoris.push(jsonAccessoris[i].nom);
            } 
        }
        let optAccessoris="";

        for (let i=0; i<llistaAccessoris.length; i++){
            optAccessoris = document.createElement('option');
            optAccessoris.value = llistaAccessoris[i];
            optAccessoris.innerHTML = llistaAccessoris[i];
            selectAccessoris.appendChild(optAccessoris);
        }

        //Modificar nav amb nom de l'entrenador
        const dniUsuari = login.dni;

        for (let i = 0 ; i < jsonEntrenador.length ; i++){
            if (jsonEntrenador[i].dni == dniUsuari){
                const dades = jsonEntrenador[i];
                console.log(dades);
                localStorage.setItem('entrenador', JSON.stringify(dades));
                datos.innerHTML = dades.nom + " " + dades.cognom1;

            }
        }

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre: OmpleSelect";
        console.log(err);
    }
}

async function escullSelect(){
            //Capturar rutinas
    try {
        let options={
        method: "GET",
        headers: {
            "Content-type": "application/json; charset=utf-8",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
            }                                
        },
        resRutina = await axios (URLRutinas, options),
        resEntrenador = await axios (URLEntrenador, options),
        resModalitat = await axios (URLModalitat, options),
        resAccessoris = await axios (URLAccessoris, options),
 
        jsonRutina = await resRutina.data;
        jsonEntrenador = await resEntrenador.data;
        jsonModalitat = await resModalitat.data;
        jsonAccessoris = await resAccessoris.data;

        const dniUsuari = login.dni;

        for (let i = 0 ; i < jsonEntrenador.length ; i++){
            if (jsonEntrenador[i].dni == dniUsuari){
                const dades = jsonEntrenador[i];
                localStorage.setItem('entrenador', JSON.stringify(dades));
                rutinaValors['dni_entrenador']=dniUsuari;
            }
        }

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        let message = err.statusText || "S'ha produit un error en el registre";
        console.log(message);
    }   
}

let nivellEscollit = "";
let tempsEscollit = "";

function getNivell(nivell){
    switch(nivell){
        case "Principiante":
            nivellEscollit = 1;
        break;
        case "Intermedio":
            nivellEscollit = 2;
        break;
        case "Avanzado":
            nivellEscollit = 3;
        break;
    }
}

selects.forEach((select) => {
    select.addEventListener('change', opcioEscollida);
});


formulario.addEventListener('submit', (e) => {
	e.preventDefault();
    if (descripcio.value !== ""){
        rutinaSeleccionada['descripcio'] = true;
        rutinaValors['descripcio'] = descripcio.value;
    }
  
	//si tots els camps del formulari han estat validats i està fet check en acceptar els termens, s'envia la informació
	if(rutinaValors.descripcio && rutinaValors.duracio && rutinaValors.nivell && rutinaValors.nom_accessori && rutinaValors.nom_modalitat && rutinaValors.preu ){

        //convertim en valor numeric els camps de duracio i preu
		let valorStringDuracio = rutinaValors.duracio;
		let valorInt = parseInt(valorStringDuracio);
		rutinaValors.duracio = valorInt;

		let valorStringPreu = rutinaValors.preu;
		valorInt = parseInt(valorStringPreu);
		rutinaValors.preu = valorInt;

        getNivell(rutinaValors.nivell);

		rutinaValors.nivell = nivellEscollit;

        rutinaValors.nom = "Rutina " + rutinaValors.nom_modalitat;

        console.log(rutinaValors)

		//Cridem diferents funcions per enviar les dades a la taula rutines
		SendDataRegister(rutinaValors);

	} 
});

/** 
 * @function SendDataRegister Enviem de forma asincrona amb async await les dades de registre a la tabla Usuaris
 * @param {object} rep el json amb tots els valors dels diferents camps del formulari, un cop ja validats
 * @returns {void} Retorna una resposta 200 en cas d'exit en l'enviament de dades o altres errors que captura el catch i envia per pantalla
*/

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function SendDataRegister(rutina){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/rutina/addRutina";

	let rutinaJSON = JSON.stringify(rutina);
    
    	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	rutinaJSON,
        },
		res = await axios(URL, options),
        
        json = await res.data;
        console.log(json);
        alert('NOVA RUTINA CREADA');
        window.location.replace("../web-pages/entrenador.html")
		

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}

logout.addEventListener('click', function sortirApp(){
    datos.innerHTML = ("Datos");
    localStorage.clear();
});

