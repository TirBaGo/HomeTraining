/**
 * @fileoverview Arxiu que afegeix nous accesoris a Rutina
 * @version 1.0
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la recollida de dades des de la selecció de rutina
 */

//Variables de solo lectura
const accessori = document.getElementById('accessori');
const descripcio = document.getElementById('descripcio_accessori');
const formulario = document.getElementById('form');
//getRutinas para captar todo el select
const URLAccessoris = "http://localhost:8080/ProvaProjecteDAW/api/accessori/getAccessoris";

//Assignem el nom d'Administrador al nav per identificar que està logat
let datos = document.getElementById('datos');
datos.innerHTML = "Administrador";

let accessoriTrobat=false;

// Programa de pintar
async function buscaAccessoris(){
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

        resAccessori = await axios (URLAccessoris,options),
        jsonAccessori = await resAccessori.data;

        console.log(jsonAccessori)
        console.log(accessori.value)


        
        for (let i = 0; i<jsonAccessori.length; i++){
            console.log(jsonAccessori[i].nom)
            if (jsonAccessori[i].nom == accessori.value){
                alert('Categoria ja disponible')
            } else {
                accessoriTrobat=true;
            }
        }
        if(accessoriTrobat){
            let campsAccessoris = {
                "nom" : accessori.value,
                "descripcio" : accessori.value
            }
            insertAccessori(campsAccessoris);
        }

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre";
        alert(message);
    }
}

async function insertAccessori(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/accessori/addAccessori";

    
    	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
                JSON.stringify(camps)
        },
		res = await axios(URL, options),
        json = await res.data;
        console.log(json);
        alert('NOU ACCESSORI CREAT: ' + camps.nom);
        window.location.replace("../web-pages/administrador.html")
		

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('porque')
        console.log('Error' + ': ' + err);
      }
}

formulario.addEventListener('submit', (e) => {
	e.preventDefault();

    buscaAccessoris();
})


