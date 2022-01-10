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

//Recuperamos valor del rutina
const rutina = JSON.parse(localStorage.getItem('rutina'));
const usuario = JSON.parse(localStorage.getItem('usuari'));
const entrenador = JSON.parse(localStorage.getItem('entrenador'));
const login = JSON.parse(localStorage.getItem('login'));

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');

const nom = document.getElementById('nom');
const video = document.getElementById('addVideo');
const categoria = document.getElementById('categoria');
const accessori = document.getElementById('accessori');
const nivell = document.getElementById('nivell');
const duracio = document.getElementById('duracio');
const preu = document.getElementById('preu');
const active = document.getElementById('active');
const descripcio = document.getElementById('descripcio');
const imagen = document.getElementById('addImg');

const selects = document.querySelectorAll('#form select'); //captura tots els selects del formulari i el guarda en un array
const inputs = document.querySelectorAll('#form input'); //captura tots els input del formulari i el guarda en un array
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";
//getUsuaris para catpar si es entrenador
const URLEntrenador = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";
//getModalitats para captar la modalitat
const URLModalitat = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/getModalitats";
//getAccessoris para captar los accessoris
const URLAccessoris = "http://localhost:8080/ProvaProjecteDAW/api/accessori/getAccessoris";
 
let usuariContrasenya = "";

// //objecte que conté tots els camps que conté la rutina buscada
const rutinaSeleccionada = {
    id_rutina: false,
	nom_modalitat: false,
	dni_entrenador: false,
	nom_accessori: false,
	duracio: false,
	nivell: false,
    active: false,
    preu: false,
    descripcio: false,
    nom: false,

}

// //valors dels camps
const rutinaValors = {
    id_rutina: "",
	nom_modalitat: "",
	dni_entrenador: "",
	nom_accessori: "",
	duracio: "",
	nivell: "",
    active: true,
    preu: "",
    descripcio: "",
    nom: "",
}

const rutinaValorsOriginal = {
    id_rutina: "",
	nom_modalitat: "",
	dni_entrenador: "",
	nom_accessori: "",
	duracio: "",
	nivell: "",
    active: true,
    preu: "",
    descripcio: "",
    nom: "",
}

//Programacion de rellenado de los select
    let llistaEntrenadors=[];
    let llistaModalitats=[];
    let llistaAccessoris=[];
    let rutinaControl=[];
    let contador = 0;
    let compteOpcions=0;
    let src ="";
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
    case "active":
        validarSelect(e.target, 'active');
    break;
    }
}

const opcioEscollidaInput = (e) => {
        switch (e.target.id) {
        case "nom":
            validarCamp(e.target, 'nom');
        break;
        case "descripcio":
            validarCamp(e.target, 'descripcio');
        break;
        }
    }
    

//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarSelect = (select, opcio) => {
if(select.options.selectedIndex!==0){  
        rutinaSeleccionada[opcio] = true;
        rutinaValors[opcio] = select.value;
    } else {
        rutinaSeleccionada[opcio] = false;
        rutinaValors[opcio] = "";
    }
escullSelect(rutinaValors); 
}

//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarCamp = (input, camp) => {
    rutinaSeleccionada[camp] = true;
    rutinaValors[camp] = input.value;
}

let nivellEscollit = "";
let nivellEscollitInverso = "";

function getNivell(nivell){

    switch(nivell){
        case 1:
            nivellEscollit = "Principiante";
            break;
        case 2:
            nivellEscollit = "Intermedio";
            break;
        case 3:
            nivellEscollit = "Avanzado";
            break;
    }
}

function getNivellInverso(nivell){
    switch(nivell){
        case "Principiante":
            nivellEscollitInverso = 1;
        break;
        case "Intermedio":
            nivellEscollitInverso = 2;
        break;
        case "Avanzado":
            nivellEscollitInverso = 3;
        break;
    }
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

    //id
    rutinaSeleccionada['id_rutina']=true;
    rutinaValors['id_rutina']=rutina.id_rutina;

    //Nom
    nom.value = rutina.nom;

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
        if(optModalitat.value==rutina.nom_modalitat){
            optModalitat.setAttribute("selected", "selected");
        }
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
        if(optAccessoris.value==rutina.nom_accessori){
            optAccessoris.setAttribute("selected", "selected");
        }
        selectAccessoris.appendChild(optAccessoris);
    }

    //nivell
    getNivell(rutina.nivell);
    for (j=1; j<nivell.length; j++){
        if (nivell[j].value==nivellEscollit){
            nivell[j].setAttribute("selected", "selected");
        }
    }

    //Duració
    for (i=1; i<duracio.length; i++){
        if (duracio[i].value==rutina.duracio){
            duracio[i].setAttribute("selected", "selected");
        }
    }

    //Preu
    for (i=1; i<preu.length; i++){
        if (preu[i].value==rutina.preu){
            preu[i].setAttribute("selected", "selected");
        }
    }

    //Active
    for (i=1; i<active.length; i++){
        if (rutina.active){
            active[1].setAttribute("selected", "selected");
        } else {
            active[2].setAttribute("selected", "selected");
        }
    }

    //Descripcio
    descripcio.value = rutina.descripcio;

    //Modificar nav amb nom de l'entrenador
    const dniUsuari = login.dni;

    for (let i = 0 ; i < jsonEntrenador.length ; i++){
        if (jsonEntrenador[i].dni == dniUsuari){
            const dades = jsonEntrenador[i];
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
            rutinaValors['dni_entrenador']=dniUsuari;
        }
    }

} catch (err) {
    //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
    let message = err.statusText || "S'ha produit un error en el registre";
    console.log(message);
}   
}

//Recorrem els select per veure en quin moment s'aplica un event
selects.forEach((select) => {
    select.addEventListener('change', opcioEscollida);
});

//Recorrem els inputs per veure en quin moment s'aplica un event
descripcio.addEventListener('keyup', opcioEscollidaInput);
descripcio.addEventListener('blur', opcioEscollidaInput);
nom.addEventListener('keyup', opcioEscollidaInput);
nom.addEventListener('blur', opcioEscollidaInput);



formulario.addEventListener('submit', (e) => {
    e.preventDefault();

    getNivellInverso(rutinaValors.nivell);

    rutinaValors.nivell = nivellEscollitInverso;

    //Cridem diferents funcions per enviar les dades a la taula rutines 
    modifiquemValor('id_rutina');
    modifiquemValor('nom');
    modifiquemValor('nom_modalitat');
    modifiquemValor('nom_accessori');
    modifiquemValor('active');
    modifiquemValor('dni_entrenador');
    modifiquemValor('preu');
    modifiquemValor('nivell');
    modifiquemValor('duracio');
    modifiquemValor('descripcio');

    //Cridem diferents funcions per enviar les dades a la taula rutines
    SendDataChange(rutinaValorsOriginal);

});

function modifiquemValor (camp){
    if(rutinaValorsOriginal[camp] !== rutinaValors[camp]){
         if (rutinaValors[camp] !== ""){
             //convertim en valor numeric els camps de duracio i preu
            if (camp=='preu'){
                let valorStringPreu = rutinaValors.preu;
                let valorPreuInt = parseInt(valorStringPreu);
                rutinaValors.preu = valorPreuInt;
                rutinaValorsOriginal[camp]=rutinaValors[camp]
            } else if (camp =='duracio'){
                let valorStringDuracio = rutinaValors.duracio;
                let valorInt = parseInt(valorStringDuracio);
                rutinaValors.duracio = valorInt;
                rutinaValorsOriginal[camp]=rutinaValors[camp];
            } else if(camp =='active'){
                if(rutinaValors[camp]=='False'){
                    rutinaValors[camp]="";
                }
                let boolean = Boolean(rutinaValors[camp])
                rutinaValorsOriginal[camp]=boolean;
               
            } else {
                rutinaValorsOriginal[camp]=rutinaValors[camp]
            }
        }
    }
}

/** 
* @function SendDataRegister Enviem de forma asincrona amb async await les dades de registre a la tabla Usuaris
* @param {object} rep el json amb tots els valors dels diferents camps del formulari, un cop ja validats
* @returns {void} Retorna una resposta 200 en cas d'exit en l'enviament de dades o altres errors que captura el catch i envia per pantalla
*/

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function SendDataChange(rutina){

const URL = "http://localhost:8080/ProvaProjecteDAW/api/rutina/modifyRutina";

try {
    let options = {
          method: "PUT",
          headers: {
            "Content-type": "application/json; charset=utf-8",
            "Access-Control-Allow-Origin": "*"
          },
        data: 
        rutina,
    },
    res = await axios(URL, options),
    json = await res.data;
    console.log(json);
    alert('RUTINA MODIFICADA');
    localStorage.setItem('rutina', JSON.stringify(json));
    window.location.replace("../web-pages/entrenador.html")
    

} catch (err) {
    // location.reload();
    let message = err.statusText || "Ocurrió un error en el registro";
    console.log('Error' + ': ' + err);
  }
}


//Cridem les dades d'usuari
async function consultaDadesRutina(){

    let entrenadorJSON = JSON.stringify(entrenador);
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
             rutinaSeleccionada,
        },
		res = await axios(URLRutinas, options),
        json = await res.data;
	    const idRutina = rutina.id_rutina;
        const dniUsuari = entrenador.dni;
        console.log(rutina)
        // Creem la rutina original on desprès comprovarem si hi ha canvis
        for (let i = 0 ; i < json.length ; i++){
            if ((json[i].id_rutina == idRutina)){
                rutinaValorsOriginal['id_rutina'] = idRutina;
                rutinaValorsOriginal['dni_entrenador'] = dniUsuari;
                console.log('USUARI TROBAT');
                rutinaValorsOriginal['nom'] = rutina.nom;
                rutinaValorsOriginal['nom_modalitat'] = rutina.nom_modalitat;
                rutinaValorsOriginal['nom_accessori'] = rutina.nom_accessori;
                rutinaValorsOriginal['active'] = rutina.active;
                rutinaValorsOriginal['preu'] = rutina.preu;
                rutinaValorsOriginal['nivell'] = rutina.nivell;
                rutinaValorsOriginal['duracio'] = rutina.duracio;
                rutinaValorsOriginal['descripcio'] = rutina.descripcio;
            }
        }
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

consultaDadesRutina();