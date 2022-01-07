/**
 * @fileoverview Arxiu que gestiona les dades d'entrenador en la seva pagina web
 * @version 3.2
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1 - Es fa la documentació de rutines d'entrenador

 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');

//getRutinas para captar todo el select
const URLRutinas = "http://localhost:8080/ProvaProjecteDAW/api/rutina/getRutines";


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
                localStorage.setItem('entrenador', JSON.stringify(dades));
                datos.innerHTML = dades.nom + " " + dades.cognom1;
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


