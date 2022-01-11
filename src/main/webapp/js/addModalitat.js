/**
 * @fileoverview Arxiu que afegeix noves modalitats a Rutina
 * @version 1.0
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la recollida de dades des de la selecció de rutina
 */

//Variables de solo lectura
const modalitat = document.getElementById('categoria');
const descripcio = document.getElementById('descripcio_categoria');
const formulario = document.getElementById('form');
//getRutinas para captar todo el select
const URLModalitats = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/getModalitats";

//Assignem el nom d'Administrador al nav per identificar que està logat
let datos = document.getElementById('datos');
datos.innerHTML = "Administrador";

// Programa de pintar
async function buscaModalitat(){
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

        resModalitat = await axios (URLModalitats,options),
        jsonModalitat = await resModalitat.data;

        console.log(jsonModalitat)
        console.log(modalitat.value)

        let modalitatTrobada=false;
        
        for (let i = 0; i<jsonModalitat.length; i++){
            console.log(jsonModalitat[i].nom)
            if (jsonModalitat[i].nom == modalitat.value){
                alert('Categoria ja disponible')
            } else {
                modalitatTrobada=true;
            }
        }
        if(modalitatTrobada){
            let campsModalitat = {
                "nom" : modalitat.value,
                "descripcio" : descripcio.value
            }
            insertModalitat(campsModalitat);
        }

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre";
        alert(message);
    }
}

async function insertModalitat(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/addModalitat";

    
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
        alert('NOVA MODALITAT CREADA: ' + camps.nom);
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

    buscaModalitat();
})

