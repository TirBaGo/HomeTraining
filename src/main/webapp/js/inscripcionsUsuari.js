/**
 * @fileoverview Arxiu que gestiona les rutines d'un usuari logat
 * @version 1.1
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1 - Es fa la llista de rutines d'entrenador

 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));

//Variables de solo lectura
const nombre = document.getElementById('nombre');

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');
const templateCard = document.getElementById('template').content;
// const verRutina = document.getElementById('verRutina').content; 
// const eliminarRutina = document.getElementById('eliminarRutina').content; 
const fragment = document.createDocumentFragment();
// const modificarRutina = document.getElementById('modificarRutina');

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";

recullRutina();

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
                localStorage.setItem('entrenador', JSON.stringify(dadesNom));
                datos.innerHTML = dadesNom.nom + " " + dadesNom.cognom1;
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

consultaDadesUsuaris();


async function recullRutina(){
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
        
        const dniUsuari = login.dni;
        
        for (let i = 0 ; i < jsonRutina.length ; i++){
            if (jsonRutina[i].dni_entrenador == dniUsuari){
                let dades = jsonRutina[i];
                console.log(dades);
                rutinaControl[i]=dades;
                localStorage.setItem('rutina', JSON.stringify(dades));

            }
        }

        var filtered = rutinaControl.filter(function (el) {
            return el != null;
          });
        
          pintaCards(filtered)

        // pinta(JSON.stringify(filtered))
    
    } catch(err){
        //la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        console.log(err);
    }
}


const pintaCards = data => {
    for (i=0; i<data.length; i++){
        pinta(data[i])
    }
}

const pinta = producto => {

        templateCard.querySelector('#nombre').textContent = producto.nom
                       
        const clone = templateCard.cloneNode(true);
        fragment.appendChild(clone);

        console.log(templateCard.querySelector('#verRutina').textContent)
        console.log(producto)
    
        if (contador==0){
            items.appendChild(fragment);
            contador = contador + 1;
        } else { 
            items.appendChild(fragment);
        }
}

// document.getElementById('verRutina').addEventListener('click',function(e){
//     e.preventDefault();
//     alert ("Ver Mundo");
//   });
// let ver =document.getElementById('verRutina')
// console.log(ver)





