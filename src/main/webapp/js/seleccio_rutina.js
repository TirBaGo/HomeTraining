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
const formulario = document.getElementById('buscarRutina'); //captura la secció on es mostren les rutines
const selects = document.querySelectorAll('#buscarRutina select'); //captura tots els selects del formulari i el guarda en un array

const items =document.getElementById('items');
const templateCard = document.getElementById('template-card').content;
const fragment = document.createDocumentFragment();
const programesEscollits = document.getElementById('ProgramesEscollits');

//Recuperamos valor del usuari
const usuario = JSON.parse(localStorage.getItem('usuari'));
const login = JSON.parse(localStorage.getItem('login'));


let rutinaControlUnicos = [];


//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";
//getUsuaris para catpar si es entrenador
const URLEntrenador = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";
//getModalitats para captar la modalitat
const URLModalitat = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/getModalitats";
//getAccessoris para captar los accessoris
const URLAccessoris = "http://localhost:8080/ProvaProjecteDAW/api/accessori/getAccessoris";

// //objecte que conté tots els camps que conté la rutina buscada
const rutinaSeleccionada = {
	categoria: false,
	entrenador: false,
	accessori: false,
	duracio: false,
	nivell: false,
    active: false,
    preu: false,
}

// //valors dels camps
const rutinaValors = {
	categoria: "",
	entrenador: "",
	accessori: "",
	duracio: "",
	nivell: "",
    active: false,
    preu: "",
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
    esborraProgrames()
    let selectEscollit = e.target.name;
    	switch (selectEscollit) {
		case "categoria":
			validarSelect(e.target, 'categoria');
		break;
		case "entrenador":
			validarSelect(e.target, 'entrenador');
		break;
		case "accessori":
			validarSelect(e.target, 'accessori');
		break;
		case "duracio":
			validarSelect(e.target, 'duracio');
		break;
		case "nivell":
			validarSelect(e.target, 'nivell');
		break;
        case "preu":
			validarSelect(e.target, 'preu');
		break;
        }
	}


const opcioEscollidaLimitada = (select) => {
    let selectEscollit = select.id;
    contador=0;
  	switch (selectEscollit) {
    case "categoria":
		validarSelectLimitat(select);
	break;
	case "entrenador":
		validarSelectLimitat(select);
	break;
	case "accessori":
		validarSelectLimitat(select);
	break;
	case "duracio":
		validarSelectLimitat(select);
	break;
	case "nivell":
		validarSelectLimitat(select);
	break;
    case "preu":
		validarSelectLimitat(select);
	break;
    }
}
//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarSelect = (select, opcio) => {
        if(select.options.selectedIndex!==0){  
            rutinaSeleccionada[opcio] = true;
            rutinaValors[opcio] = select.value;
            opcioEscollidaLimitada(select);
            document.getElementById('missatgeError').style.cssText='display: none;'
        } else {
            // console.log('validaSelect')
            rutinaSeleccionada[opcio] = false;
            rutinaValors[opcio] = "";
            ompleSelectLimitat(select);
        }
    
    escullSelect(rutinaValors); 
}
    
//Validem els camps i afegim una classe o la treiem per mostrar el missatge d'error si hi ha
const validarSelectLimitat = (select) => {
    if(select.options.selectedIndex!==0){  
  
        limitaSelect(select)
    } else {
        esborraOptions();
    }
    escullSelect(rutinaValors); 

}
let revisa=false;

const limitaSelect = (identificador) => {
    for (i=0; i<selects.length; i++){
        if (identificador !== selects[i]){
            revisa=true;
        } 
    }
    if (revisa){
        ompleSelectLimitat(identificador);
    }

}
// Programa de pintar
async function ompleSelect(){
    //Capturar rutinas
    try {
        let options={
            method: "GET",
            headers: {
                "Content-type": "application/json; char =utf-8",
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


        //Entrenador
        for (let i = 0; i<jsonEntrenador.length; i++){

            if (jsonEntrenador[i].isEntrenador == true){
                llistaEntrenadors.push(jsonEntrenador[i].nom);
            } 
        }
        let optEntrenador="";

        for (let i=0; i<llistaEntrenadors.length; i++){
            optEntrenador = document.createElement('option');
            optEntrenador.value = llistaEntrenadors[i];
            optEntrenador.innerHTML = llistaEntrenadors[i];
            selectEntrenador.appendChild(optEntrenador);
        }

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

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre";
        alert(message);
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


        if(rutinaSeleccionada.accessori==false && 
            rutinaSeleccionada.categoria==false &&
            rutinaSeleccionada.duracio==false &&
            rutinaSeleccionada.entrenador==false &&
            rutinaSeleccionada.preu==false &&
            rutinaSeleccionada.nivell==false){
                programesEscollits.innerHTML = 'CAP PROGRAMA SELECCIONAT';
                esborraProgrames();
                esborraOptions();
                location.reload();
            }
        pintaCards(jsonRutina);
        contador=contador+1



    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        let message = err.statusText || "S'ha produit un error en el registre";
        console.log(message + err);
    }   
}

let dniEntrenador = "";
let nomEntrenador = "";
let nivellEscollit = "";
let tempsEscollit = "";

function getEntrenador (){
    for (j=0; j<jsonEntrenador.length; j++){
        if (jsonEntrenador[j].nom == rutinaValors.entrenador){
            dniEntrenador = jsonEntrenador[j].dni;
            nomEntrenador = jsonEntrenador[j].nom;
        } 
    }
}

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

const pintaCards = data => {
    for (i=0; i<data.length; i++){
        getEntrenador();
        getNivell(rutinaValors.nivell);

        if (data[i].nom_modalitat == (rutinaValors.categoria) ||
        data[i].nom_accessori == (rutinaValors.accessori) ||
        data[i].dni_entrenador == dniEntrenador ||
        data[i].nivell == nivellEscollit ||
        data[i].duracio == rutinaValors.duracio ||
        data[i].preu == rutinaValors.preu
        ){
            rutinaControl[i] = data[i]
            if (contador==0){
                pinta(data[i])
            }

        };
    }

}

let rutinaId=""; 
const pinta = producto => {

    programesEscollits.innerHTML = 'PROGRAMES ESCOLLITS';
 
    rutinaId=producto.id_rutina
    pintaImatge(producto.nom_modalitat);

    templateCard.querySelector('h5').textContent = producto.nom
    templateCard.querySelector('p').textContent = producto.descripcio;
    templateCard.querySelector('img').setAttribute("alt",producto.descripcio);
    templateCard.querySelector('img').setAttribute("src",src);
    templateCard.querySelector('button').setAttribute("id", producto.id_rutina)
    templateCard.querySelector('button').setAttribute("onclick", "selecciona("+producto.id_rutina+")")

                   
    const clone = templateCard.cloneNode(true);
    fragment.appendChild(clone);

    // console.log(templateCard.getElementById(producto.id_rutina))
    items.appendChild(fragment)

    console.log(items)


}



function pintaImatge(modalitat){
    switch (modalitat){
        case "Triceps":
            src="https://cdn.pixabay.com/photo/2016/11/29/09/10/man-1868632_960_720.jpg";
            break;
        case "Hombros":
            src="https://cdn.pixabay.com/photo/2017/08/07/14/02/man-2604149__480.jpg";
            break;
        case "Gluteos":
            src="https://cdn.pixabay.com/photo/2021/01/03/03/43/man-5883500__340.jpg";
            break;
        case "Abdominales":
            src="https://cdn.pixabay.com/photo/2017/04/20/08/35/sport-2245029__340.jpg";
            break;
    }
    return src
}

function esborraProgrames(){
    while (items.firstChild){
        items.removeChild(items.firstChild);
    }        
}

function esborraOptions(){
    console.log('entra')
    console.log(selectEntrenador)
    while(selectEntrenador.options.length>1){
        selectEntrenador.remove(1);
    }
    console.log(selectEntrenador)

    while(selectModalitat.options.length>1){
        selectModalitat.remove(1);
    }
    while(selectAccessoris.options.length>1){
        selectAccessoris.remove(1);
    }
}
const arrayNet ={};

async function ompleSelectLimitat(select){
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

        // Entrenador
        if(select.id!=='entrenador'){
            let optEntrenador="";

            llistaEntrenadors=[];

            for (let i = 0; i<jsonEntrenador.length; i++){
                while(selectEntrenador.options.length>1){
                    selectEntrenador.remove(1);
                }
                if ((jsonEntrenador[i].isEntrenador == true) ){
                    for (j=0; j<jsonRutina.length;j++){
                        if(jsonEntrenador[i].dni==jsonRutina[j].dni_entrenador){
                            if(llistaEntrenadors[0]!==jsonEntrenador[i].nom){
                                llistaEntrenadors.push(jsonEntrenador[i].nom);
                            }
                        }
                    }
                } 
            }

            if (llistaEntrenadors.length!==0){
                let unicos = llistaEntrenadors.filter((valor, indice) => {
                    return llistaEntrenadors.indexOf(valor) === indice;
                  }
                );
                for (let i=0; i<unicos.length; i++){
                    optEntrenador = document.createElement('option');
                    optEntrenador.value = unicos[i];
                    optEntrenador.innerHTML = unicos[i];
                    selectEntrenador.appendChild(optEntrenador);
                }  
            }  else {
                while(selectEntrenador.options.length>1){
                    selectEntrenador.remove(1);
                }
                ompleSelect();
                console.log('entrenador no elegido')
            }
        }
        //Modalitat
        if(select.id!=='categoria'){
            llistaModalitats=[];
            for (let i = 0; i<jsonModalitat.length; i++){
                while(selectModalitat.options.length>1){
                    selectModalitat.remove(1);
                }
                for (j=0; j<jsonRutina.length;j++){
                    if(jsonModalitat[i].nom==jsonRutina[j].nom_modalitat){
                        if(llistaModalitats[0]!==jsonModalitat[i].nom){
                            llistaModalitats.push(jsonModalitat[i].nom);
                        }
                    }
                }
            }
            let optModalitat="";

            if (llistaModalitats.length!==0){
                let unicos = llistaModalitats.filter((valor, indice) => {
                    return llistaModalitats.indexOf(valor) === indice;
                  }
                );
                for (let i=0; i<unicos.length; i++){
                    optModalitat = document.createElement('option');
                    optModalitat.value = unicos[i];
                    optModalitat.innerHTML = unicos[i];
                    selectModalitat.appendChild(optModalitat);
                }
            }  else {
                while(selectModalitat.options.length>1){
                    selectModalitat.remove(1);
                }
                ompleSelect()
                console.log('categoria no elegido')
            }
        }
        //Accessoris
        if (select.id !== 'accessori'){
            llistaAccessoris=[];
            for (let i = 0; i<jsonAccessoris.length; i++){
                while(selectAccessoris.options.length>1){
                    selectAccessoris.remove(1);
                }
                for (j=0; j<jsonRutina.length;j++){
                    if(jsonAccessoris[i].nom==jsonRutina[j].nom_accessori){
                        if(llistaAccessoris[0]!==jsonAccessoris[i].nom){
                            llistaAccessoris.push(jsonAccessoris[i].nom);
                        }
                    }
                }
            }
            let optAccessoris="";

            if (llistaAccessoris.length!==0){
                let unicos = llistaAccessoris.filter((valor, indice) => {
                    return llistaAccessoris.indexOf(valor) === indice;
                  }
                );
                for (let i=0; i<unicos.length; i++){
                    optAccessoris = document.createElement('option');
                    optAccessoris.value = unicos[i];
                    optAccessoris.innerHTML = unicos[i];
                    selectAccessoris.appendChild(optAccessoris);
                }
            } else {
                while(selectAccessoris.options.length>1){
                    selectAccessoris.remove(1);
                }
                ompleSelect()
                console.log('accesorio no elegido')
            }
        }

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        let message = err.statusText || "S'ha produit un error en el registre";
        console.log(err);
    }
}




selects.forEach((select) => {
    select.addEventListener('change', opcioEscollida);
});
// let selecciona = templateCard.querySelector('button')
async function selecciona(id){
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
        jsonRutina = await resRutina.data;

        console.log(jsonRutina);
        console.log(id)

        for (let i=0; i<jsonRutina.length; i++){
            if (id==jsonRutina[i].id_rutina){
                capturaIdInscripcio(jsonRutina[i])
            }
        }
    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        let message = err.statusText || "S'ha produit un error en el registre";
        console.log(err);
    }
}

async function capturaIdInscripcio(rutina){
    console.log(rutina);
    // location.reload();
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/inscripcio/getInscripcions";

    try {
        let options={
            method: "GET",
            headers: {
                "Content-type": "application/json; charset=utf-8",
                "Access-Control-Allow-Origin": "*",
            },
                           
        },
        resInscripcio = await axios (URL, options),
        jsonInscripcio = await resInscripcio.data;

        let lastId = jsonInscripcio[jsonInscripcio.length-1]

        ultimoIdInsc = lastId.id_inscripcio + 1;
        console.log(ultimoIdInsc)

        seleccionaRutina(rutina,ultimoIdInsc)


    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        let message = err.statusText || "S'ha produit un error en el registre";
        console.log(err + message);
    }


}

let ultimoIdInsc = 0;

function seleccionaRutina(rutina,id){

    let campsRutina={
        "id_inscripcio": id,
        "dni_usuari": login.dni,
        "nom_rutina": rutina.nom,
        "ispagat": false,
        "data_alta": Date.now(),
        "data_fi": null
    }
    console.log(campsRutina)

    console.log(rutina)       
    localStorage.removeItem('rutina');
    localStorage.setItem('rutina', JSON.stringify(rutina))
    console.log(rutina)
    localStorage.removeItem('inscripcio');
    localStorage.setItem('inscripcio', JSON.stringify(campsRutina))

    window.location.replace("../web-pages/inscripcioRutina.html")



}


