/**
 * @fileoverview Arxiu que elimina modalitats de Rutina
 * @version 1.0
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la recollida de dades des de la selecció de rutina
 */

//Variables de solo lectura
const nombre = document.getElementById('nombre');
const descripcio = document.getElementById('descripcion');
const eliminar = document.getElementById('eliminarNom');
const formulario = document.getElementById('form');
//getRutinas para captar todo el select
const URLModalitats = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/getModalitats";

//Assignem el nom d'Administrador al nav per identificar que està logat
let datos = document.getElementById('datos');
datos.innerHTML = "Administrador";

//Programacion de rellenado de los select
let llistaModalitatsNom=[];
let llistaModalitatsDescripcio=[];

const template = document.getElementById('template').content;
const fragment = document.createDocumentFragment();




// Programa de pintar
async function omple(){
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
        resModalitats = await axios (URLModalitats, options),
        jsonModalitat = await resModalitats.data;

        console.log(jsonModalitat)

        //Modalitat Nom
        for (let i = 0; i<jsonModalitat.length; i++){
            if (jsonModalitat[i].nom){
                template.querySelector('#nombre').textContent = jsonModalitat[i].nom;
                template.querySelector('#nombre').className = "espacio " + jsonModalitat[i].nom;
                template.querySelector('#descripcion').textContent = jsonModalitat[i].descripcio;
                template.querySelector('button').setAttribute('id', jsonModalitat[i].nom);
                             
                const clone = template.cloneNode(true);
                fragment.appendChild(clone);
                formulario.appendChild(fragment);

                document.getElementById(jsonModalitat[i].nom).addEventListener("click", function() {
                    const modalitat = jsonModalitat[i];
                    esborraModalitat(modalitat);
                  });
            } 
        }
    
        
    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre: OmpleSelect";
        console.log(err);
    }
}

function esborraModalitat (modalitat) {
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/modalitat/deleteModalitat";
       //Capturar rutinas
       try {
        let options={
            method: "DELETE",
            headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
            },
            data: 
                JSON.stringify(modalitat),                               
        },
        res = axios (URL, options),
        json = res.data;

        console.log(json)
        alert('MODALIDAD BORRADA');
        omple()
        

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre: OmpleSelect";
        console.log(err + " " + message);
    }
}


omple();