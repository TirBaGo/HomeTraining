/**
 * @fileoverview Arxiu que recull les peticions de contacte d'un usuari
 * @version 1.0
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la recollida de dades del contacte
 */

// variables de només lectura
const formulario = document.getElementById('form'); //captura la secció on es mostren les rutines
const selects = document.querySelectorAll('#form select'); //captura tots els selects del formulari i el guarda en un array

const contacto = document.getElementById('contacto'); //captura la secció on es mostren les rutines
const titulo = document.getElementById('titulo'); //captura la secció on es mostren les rutines
const descripcio = document.getElementById('descripcio'); //captura la secció on es mostren les rutines

//Variable per modificar nom al nav i per tancar sessió
let datos = document.getElementById('datos');
const logout = document.getElementById('logout');


//Recuperamos valor del usuari
const usuario = JSON.parse(localStorage.getItem('login'));

//Constant que s'enviara a les BBDD
const campsValor = {
    dni_usuari: "",
	nom: "",
	descripcio: "",
}
//Variable per identificar el tipus de contacte
let tipus = "";

consultaDadesUsuaris();

//S'envien els valors recollits en el formulari dintre de CampsValor
formulario.addEventListener('submit', (e) => {
	e.preventDefault();
    //Incorporem tots els valors a la variable campsValor
    tipus=contacto.value
    campsValor['nom'] = titulo.value;
    campsValor['descripcio'] = descripcio.value;
    campsValor['dni_usuari'] = usuario.dni;
    //Cridem a la funció per enviar per post tota la informació passant els valors i el tipus
    insertContacte (campsValor, tipus);

  });
  //Segons el valor del tipus es crida a la seva corresponent funció segons sigui suggeriment, dubte, queixa i bug
 function insertContacte(camps, tipus){
    
    switch(tipus){
        case 'Sugerimiento':
            veureIdSuggeriment(camps);
        break;
        case 'Duda':
            veureIdDuda(camps);
        break;
        case 'Queja':
            veureIdQueja(camps);
        break;
        case 'Bug':
            veureIdBug(camps);
        break;
    }
  }
  //Primer cridem a la funció per obtenir l'identificador per al nou POST i desprès cridem a la funció per enviar la informació
  async function sendDataSugerimiento(camps){

    const URL = "http://localhost:8080/ProvaProjecteDAW/api/suggeriment/addSuggeriment";

	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
                JSON.stringify(campsValor),
        },
		res = await axios(URL, options),
        json = await res.data;


        console.log(json);
        alert ('Missatge de tipus ' + tipus + " acceptat")

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

  async function veureIdSuggeriment(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/suggeriment/getSuggeriments";
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

        console.log(json);
        campsValor['id_suggeriment']=json.length;

        sendDataSugerimiento(camps);

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

//Primer cridem a la funció per obtenir l'identificador per al nou POST i desprès cridem a la funció per enviar la informació
  async function sendDataDuda(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/dubte/addDubte";
	console.log(camps);

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
        alert ('Missatge de tipus ' + tipus + " acceptat")

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

  async function veureIdDuda(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/dubte/getDubtes";
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

        console.log(json);
        campsValor['id_dubte']=json.length;

        sendDataDuda(camps);

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }
//Primer cridem a la funció per obtenir l'identificador per al nou POST i desprès cridem a la funció per enviar la informació
  async function sendDataQueja(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/queixes/addQueixes";
	console.log(camps);
    	
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
        alert ('Missatge de tipus ' + tipus + " acceptat")

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

  async function veureIdQueja(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/queixes/getQueixes";
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

        console.log(json);
        campsValor['id_queixes']=json.length;

        sendDataQueja(camps);

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }
//Primer cridem a la funció per obtenir l'identificador per al nou POST i desprès cridem a la funció per enviar la informació
  async function sendDataBug(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/bug/addBug";
	console.log(camps);
	
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
        alert ('Missatge de tipus ' + tipus + " acceptat")

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

  async function veureIdBug(camps){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/bug/getBugs";
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

        console.log(json);
        campsValor['id_bug']=json.length;

        sendDataBug(camps);

		} catch (err) {
            location.reload();
		    let message = err.statusText || "Ocurrió un error en el registro";
            console.log('Error' + ': ' + message + err);
      }
  }

  //Cridem les dades d'usuari
async function consultaDadesUsuaris(){
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";

	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	login,
        },
		res = await axios(URL, options),
        json = await res.data;

        const dniUsuari = usuario.dni;
        for (let i = 0 ; i < json.length ; i++){
            if (json[i].dni == dniUsuari){
                const dades = json[i];
                if (dades.isEntrenador){
                    localStorage.setItem('entrenador', JSON.stringify(dades));
                    window.location.replace("../web-pages/entrenador.html")
                } else {
                    localStorage.setItem('usuari', JSON.stringify(dades));
                    datos.innerHTML = dades.nom + " " + dades.cognom1;
                }
            }
        }
        
    } catch (err) {
        // location.reload();
        alert ('USUARI NO LOGAT')
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}
logout.addEventListener('click', function sortirApp(){
    datos.innerHTML = ("Datos");
    localStorage.clear();
});

