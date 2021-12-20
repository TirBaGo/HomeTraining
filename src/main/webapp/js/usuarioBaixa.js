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
const baixa = JSON.parse(localStorage.getItem('login'));

const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id



formulario.addEventListener('submit', (e) => {
	e.preventDefault();
	// if(camps.nom && camps.cognom1 && camps.cognom2 && camps.email && camps.dni && camps.telefon && camps.adreca && camps.codpost && camps.poblacio && camps.provincia && camps.password && camps.telefon){
        console.log(baixa.dni)
		// SendDataOut(campsValorOriginal);
        consultaDadesUsuaris();

});

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
            	baixa,
        },
		res = await axios(URL, options),
        json = await res.data;
        console.log(json)
        const dniUsuari = baixa.dni;

        for (let i = 0 ; i < json.length ; i++){

            if (json[i].dni == dniUsuari){
                const dades = json[i];
                console.log(dades);
                
                baixaUsuari(dades);
        //         if (dades.isEntrenador){
        //             localStorage.setItem('entrenador', JSON.stringify(dades));
        //             alert('Benvingut entrenador ' + dades.nom + ' ' + dades.cognom1);
        //             window.location.replace(URLBase+"/entrenador.html")
        //         } else {
        //             localStorage.setItem('usuari', JSON.stringify(dades));
        //             alert('Benvingut ' + dades.nom + ' ' + dades.cognom1);
        //         }
                }
        }
        
    } catch (err) {
        location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}

//Enviem de forma asincrona per POST l'objecte camps que conté la informació entrada
async function baixaUsuari(usuari){
	console.log(usuari)
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/deleteUsuari";
	try {
		let options = {
          	method: "DELETE",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	usuari,
        },
		res = await axios(URL, options),
        json = await res.data;
        // console.log(json);
        // console.log(campsValorOriginal);
        alert('USUARI ESBORRAT!');

        localStorage.clear();
            window.location.replace('../index.html')

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro registro";
        console.log(err)
		console.log('Error' + ': ' + err);
      }
}


consultaDadesUsuaris();