/**
 * @fileoverview Arxiu que fa la validació i enviament de dades d'un formulari de registre d'usuari
 * @version 3.2
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v3.1 - S'incorpora l'enviament de dades a l'API de login d'usuari
 * v2.2 - Es fa la validació del formulari de Login
 * v2.1 - Es fa l'enviament de dades a l'API del registre d'usuari
 * v1.1. - Es fa la validació del formulari de registre
 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));

// const nom = document.getElementById('nom');
// const cognom1 = document.getElementById('cognom1');
// const cognom2 = document.getElementById('cognom2');
// const mail = document.getElementById('mail');
// const telefon = document.getElementById('telefon');
// const adresa = document.getElementById('adresa');
// const cp = document.getElementById('cp');
// const poblacio = document.getElementById('poblacio');
// const provincia = document.getElementById('provincia');
// const password = document.getElementById('password');


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
                const dades = json[i];
                console.log(dades);
                if (dades.isEntrenador){
                    localStorage.setItem('entrenador', JSON.stringify(dades));
                    alert('Benvingut entrenador ' + dades.nom + ' ' + dades.cognom1);
                    window.location.replace("../web-pages/entrenador.html")
                } else {
                    localStorage.setItem('usuari', JSON.stringify(dades));
                    alert('Benvingut ' + dades.nom + ' ' + dades.cognom1);
                }
                }
        }

		

    } catch (err) {
        location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}

consultaDadesUsuaris();