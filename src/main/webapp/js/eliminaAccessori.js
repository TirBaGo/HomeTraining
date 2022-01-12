/**
 * @fileoverview Arxiu que elimina accessoria de Rutina
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
const URLAccessoris = "http://localhost:8080/ProvaProjecteDAW/api/accessori/getAccessoris";

//Assignem el nom d'Administrador al nav per identificar que està logat
let datos = document.getElementById('datos');
datos.innerHTML = "Administrador";

//Programacion de rellenado de los select
let llistaAccessorisNom=[];
let llistaAccessorisDescripcio=[];

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
        resAccessori = await axios (URLAccessoris, options),
        jsonAccessori = await resAccessori.data;

        console.log(jsonAccessori)

        //Accessori Nom
        for (let i = 0; i<jsonAccessori.length; i++){
            if (jsonAccessori[i].nom){
                template.querySelector('#nombre').textContent = jsonAccessori[i].nom;
                template.querySelector('#nombre').className = "espacio " + jsonAccessori[i].nom;
                template.querySelector('#descripcion').textContent = jsonAccessori[i].descripcio;
                template.querySelector('button').setAttribute('id', jsonAccessori[i].nom);
                             
                const clone = template.cloneNode(true);
                fragment.appendChild(clone);
                formulario.appendChild(fragment);

                document.getElementById(jsonAccessori[i].nom).addEventListener("click", function() {
                    const accessori = jsonAccessori[i];
                    esborraModalitat(accessori);
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

function esborraModalitat (accessori) {
    console.log(accessori)
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/accessori/deleteAccesori";
       //Capturar rutinas
       try {
        let options={
            method: "DELETE",
            headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
            },
            data: 
                JSON.stringify(accessori),                               
        },
        res = axios (URL, options),
        json = res.data;

        console.log(json)
        alert('ACCESSORIO BORRADO');
        omple()

    } catch (err) {
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        // location.reload();
        let message = err.statusText || "S'ha produit un error en el registre: OmpleSelect";
        console.log(err + " " + message);
    }
}


omple();
