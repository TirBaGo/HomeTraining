/**
 * @fileoverview Arxiu que gestiona les rutines d'un entrenador logat
 * @version 1.1
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1 - Es fa la llista de rutines d'entrenador

 */
    
//Recuperamos valor del usuari
const login = JSON.parse(localStorage.getItem('login'));

let datos = document.getElementById('datos');
const logout = document.getElementById('logout');
// let autorProgramas = document.getElementById('autorProgramas');
const templateCard = document.getElementById('template-card').content;
const fragment = document.createDocumentFragment();
const modificarRutina = document.getElementById('modificarRutina');

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
            // console.log(datos)
            if (json[i].dni == dniUsuari){
                const dades = json[i];
                localStorage.setItem('entrenador', JSON.stringify(dades));
                datos.innerHTML = dades.nom + " " + dades.cognom1;
                // autorProgramas.innerHTML = dades.nom + " " + dades.cognom1;

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
                rutinaControl[i]=dades;
                localStorage.setItem('rutina', JSON.stringify(dades));
                datos.innerHTML = dades.nom + " " + dades.cognom1;
                // pintaCards(dades)

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
    // rutinaControl = producto;
    // console.log(rutinaControl)
    console.log(producto)
    // programesEscollits.innerHTML = 'PROGRAMES ESCOLLITS';
        pintaImatge(producto.nom_modalitat);

        templateCard.querySelector('h5').textContent = producto.nom
        templateCard.querySelector('p').textContent = producto.descripcio;
        templateCard.querySelector('img').setAttribute("alt",producto.descripcio);
        templateCard.querySelector('img').setAttribute("src",src);
        templateCard.querySelector('a').setAttribute("href","../web-pages/ModificarRutina.html");
    
                       
        const clone = templateCard.cloneNode(true);
        fragment.appendChild(clone);
    
        if (contador==0){
            items.appendChild(fragment);
            contador = contador + 1;
        } else { 
            items.appendChild(fragment);
        }
}

function esborraProgrames(){
    while (items.firstChild){
        items.removeChild(items.firstChild);
    }        
}

function pintaImatge(modalitat){
    switch (modalitat){
        case "Triceps":
            src="https://cdn.pixabay.com/photo/2016/11/29/09/10/man-1868632_960_720.jpg";
            break;
        case "Hombros":
            src="https://cdn.pixabay.com/photo/2017/08/07/14/02/man-2604149__480.jpg";
            break;
        case "Gluteos":
            src="https://cdn.pixabay.com/photo/2021/01/03/03/43/man-5883500__340.jpg";
            break;
        case "Abdominales":
            src="https://cdn.pixabay.com/photo/2017/04/20/08/35/sport-2245029__340.jpg";
            break;
        case "Antebrazo":
            src="https://cdn.pixabay.com/photo/2017/08/07/14/02/man-2604149__480.jpg";
            break;
    }
    return src
}

