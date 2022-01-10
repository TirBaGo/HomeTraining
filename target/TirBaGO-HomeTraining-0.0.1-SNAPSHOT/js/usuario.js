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

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');

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
    
            // console.log(datos)
            if (json[i].dni == dniUsuari){
                const dades = json[i];
                console.log(dades);
                if (dades.isEntrenador){
                    localStorage.setItem('entrenador', JSON.stringify(dades));
                    window.location.replace("../web-pages/entrenador.html")
                } else {
                    localStorage.setItem('usuari', JSON.stringify(dades));
                    datos.innerHTML = dades.nom + " " + dades.cognom1;
                    // alert('Benvingut ' + dades.nom + ' ' + dades.cognom1);
                }
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