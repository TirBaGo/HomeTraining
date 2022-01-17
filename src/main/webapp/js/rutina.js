/**
 * @fileoverview Arxiu que visualitza la rutina usuari
 * @version 1.1
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1 - Es fa la llista de inscripcions d'usuari

 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));
const rutina = JSON.parse(localStorage.getItem('rutina'));
const usuario = JSON.parse(localStorage.getItem('usuari'));



//Variables de solo lectura
const id_rutina = document.getElementById('id_rutina');
const nom_rutina = document.getElementById('nom_rutina');
const dni_entrenador = document.getElementById('dni_entrenador');
const nom_accessori = document.getElementById('nom_accessori');
const nom_modalitat = document.getElementById('nom_modalitat');
const preu = document.getElementById('preu');
const activa = document.getElementById('activa');
const nivell = document.getElementById('nivell');
const duracio = document.getElementById('duracio');
const descripcio = document.getElementById('descripcio');

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";

// let contador = 0;
// let rutinaControl=[];

console.log(rutina)

id_rutina.innerHTML = rutina.id_rutina;
nom_rutina.innerHTML = rutina.nom;
dni_entrenador.innerHTML = rutina.dni_entrenador;
nom_accessori.innerHTML = rutina.nom_accessori;
nom_modalitat.innerHTML = rutina.nom_modalitat;
preu.innerHTML = rutina.preu;
activa.innerHTML = rutina.active;
nivell.innerHTML = rutina.nivell;
duracio.innerHTML = rutina.duracio;
descripcio.innerHTML = rutina.descripcio;

datos.innerHTML=usuario.nom + " " + usuario.cognom1;


logout.addEventListener('click', function sortirApp(){
    datos.innerHTML = ("Datos");
    localStorage.clear();
});

