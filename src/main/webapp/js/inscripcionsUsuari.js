/**
 * @fileoverview Arxiu que gestiona les inscripcions d'un usuari logat
 * @version 1.1
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1 - Es fa la llista de inscripcions d'usuari

 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));

//Variables de solo lectura
const nombre = document.getElementById('nombre');

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');
const templateCard = document.getElementById('template').content;
const fragment = document.createDocumentFragment();

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";

// recullRutina();

let contador = 0;
let rutinaControl=[];


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

        const dniUsuari = login.dni;

        for (let i = 0 ; i < json.length ; i++){
            if (json[i].dni == dniUsuari){
                const dadesNom = json[i];
                datos.innerHTML = dadesNom.nom + " " + dadesNom.cognom1;
            }
        }
        obtenInscripcions(dniUsuari)
        
    } catch (err) {
        alert ('USUARI NO LOGAT')
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}
logout.addEventListener('click', function sortirApp(){
    datos.innerHTML = ("Datos");
    localStorage.clear();
});

consultaDadesUsuaris();
let inscrip=[];
async function obtenInscripcions(dni){

    const URL = "http://localhost:8080/ProvaProjecteDAW/api/inscripcio/getInscripcions";
    
    try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        },
		res = await axios(URL, options),
        json = await res.data;

        console.log(json)

        for (let i = 0 ; i < json.length ; i++){
            if (json[i].dni_usuari == dni){
                inscrip[i] = json[i];
            }
        }
        recullRutina(inscrip)


        
    } catch (err) {
        alert ('USUARI NO LOGAT')
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}


async function recullRutina(inscripcions){
    //Camputar rutina
    try{
        let options ={
            method: "GET",
            headers: {
                "Content-type": "application/json; charset=utf-8",
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
            }   
        },
        resRutina= await axios (URLRutinas, options),
        jsonRutina = await resRutina.data;
        
        var filter = inscripcions.filter(function (el) {
            return el != null;
          });

        for (let i=0; i<filter.length; i++){
            if(filter[i].nom_rutina){
                addrutina(filter[i].nom_rutina,jsonRutina)
            }
        }

        var filtered = rutinaControl.filter(function (el) {
            return el != null;
          });
        
          pintaCards(filtered)
          contador=contador+1
    
    } catch(err){
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        console.log(err);
    }
}

function addrutina(nomRut,rutinas){
    for (let i=0; i<rutinas.length; i++){
        if (rutinas[i].nom == nomRut){
            rutinaControl[i]=rutinas[i];
        }
    }
}
let totalPreu = 0;
let totalDuracio=0;

const pintaCards = data => {
    for (i=0; i<data.length; i++){
        if (contador==0){
            pinta(data[i])
            console.log(data)
            totalPreu += data[i].preu;
            totalDuracio += data[i].duracio;
        }
    }
    document.getElementById('totalPreu').textContent = 'QUANTITAT INVERTIDA EN RUTINES: ' + totalPreu + "€."
    document.getElementById('totalDuracio').textContent = 'QUANTITAT DE TEMPS REALITZANT RUTINES: ' + totalDuracio + "min."


}

const pinta = producto => {

        templateCard.querySelector('#nombre').textContent = producto.nom
        templateCard.querySelector('#ver').setAttribute("onclick", "visualitza("+producto.id_rutina+")")
        templateCard.querySelector('#eliminar').setAttribute("onclick", "elimina_id("+producto.id_rutina+")")
        

        const clone = templateCard.cloneNode(true);
        fragment.appendChild(clone);

            items.appendChild(fragment);

 
}

async function elimina_id (idInsc) {

    try{
        let options ={
            method: "GET",
            headers: {
                "Content-type": "application/json; charset=utf-8",
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
            }   
        },
        resRutina= await axios (URLRutinas, options),
        jsonRutina = await resRutina.data;
        
        console.log(jsonRutina)

        for (let i=0; i<jsonRutina.length; i++){
            if (jsonRutina[i].id_rutina==idInsc){
                console.log(jsonRutina[i])
                let nomRutina = jsonRutina[i].nom;
                lookInsc(nomRutina);


            }
        }

    
    } catch(err){
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        console.log(err);
    }
}


async function lookInsc(nom){

        // Amb el nom Rutina localitzem la inscripció
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/inscripcio/getInscripcions";
    
    try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        },
		res = await axios(URL, options),
        json = await res.data;

        console.log(json)

        for (let i = 0; i < json.length; i++) {
           if (json[i].nom_rutina==nom){
               console.log(json[i])
               elimina_Inscripcio(json[i])
           }
            
        }
        
    } catch (err) {
        alert ('USUARI NO LOGAT')
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
    }


async function elimina_Inscripcio(inscripcio){

    const URL = "http://localhost:8080/ProvaProjecteDAW/api/inscripcio/deleteInscripcio";
       //Capturar rutinas
       try {
        let options={
            method: "DELETE",
            headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
            },
            data: 
                inscripcio,                               
        },
        res = axios (URL, options),
        json = res.data;

        console.log(json)
        alert('INSCRIPCIO BORRADA');
        location.reload();
        

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre: OmpleSelect";
        console.log(err + " " + message);
    }

    }


async function visualitza(idRutina){
    try{
        let options ={
            method: "GET",
            headers: {
                "Content-type": "application/json; charset=utf-8",
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
            }   
        },
        resRutina= await axios (URLRutinas, options),
        jsonRutina = await resRutina.data;
        
        console.log(jsonRutina)

        for (let i=0; i<jsonRutina.length; i++){
            if (jsonRutina[i].id_rutina==idRutina){
                inscrpPagat(jsonRutina[i].nom)
                localStorage.removeItem('rutina');
                localStorage.setItem('rutina', JSON.stringify(jsonRutina[i]))
                window.location.replace("../web-pages/Rutina.html")

            }
        }

    
    } catch(err){
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        console.log(err);
    }
}

async function inscrpPagat(nomRutina){
    

        // Amb el nom Rutina localitzem la inscripció
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/inscripcio/getInscripcions";
    
    try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        },
		res = await axios(URL, options),
        json = await res.data;

        let contador=0;
        for (let i = 0; i < json.length; i++) {
           if (json[i].nom_rutina==nomRutina){
               if (contador==0){
                if(json[i].ispagat==false){
                    alert("Rutina no gratuita. Necesites subscripció")
                    contador=contador+1
               }
               }
           }
            
        }
        
    } catch (err) {
        alert ('USUARI NO LOGAT')
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
    
}




