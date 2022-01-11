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
const formulario = document.getElementById('contacto'); //captura la secció on es mostren les rutines
const selects = document.querySelectorAll('#form select'); //captura tots els selects del formulari i el guarda en un array

const titulo = document.getElementById('titulo'); //captura la secció on es mostren les rutines
const descripcio = document.getElementById('descripcio'); //captura la secció on es mostren les rutines



document.getElementById("contacto").addEventListener("change", recullDades);




function recullDades() {
   console.log(formulario.value);
   console.log(titulo.textContent);
   console.log(descripcio.textContent);

  };


