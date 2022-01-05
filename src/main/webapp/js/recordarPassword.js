/**
 * @fileoverview Arxiu que fa la renovació de Contrasenya d'usuari
 * @version 1.1
 * @author Ricardo Bazo
 * @copyright HomeTraining.com
 * 
 * History
 * v1.1. - Es fa la validació del formulari de recordar contrasenya
 */
    
//Recuperamos valor del usuari
const formulario = document.getElementById('form'); //captura el formulari d'html gràcies al seu id


const camps = {
	nom: false,
	cognom1: false,
	cognom2: false,
	email: false,
	dni: false,
	telefon: false,
	adreca: false,
	poblacio: false,
	provincia: false,
	password: false,
	isEntrenador: false,
	active: true,
	username: false,
	data_alta: false
}


formulario.addEventListener('submit', (e) => {
	e.preventDefault();
	// if(camps.nom && camps.cognom1 && camps.cognom2 && camps.email && camps.dni && camps.telefon && camps.adreca && camps.codpost && camps.poblacio && camps.provincia && camps.password && camps.telefon){
        // console.log(baixa.dni)
		// SendDataOut(campsValorOriginal);

        validarPassword2();
        consultaDadesUsuaris();


});

const validarPassword2 = () => {
	const inputPassword1 = document.getElementById('password');
	const inputPassword2 = document.getElementById('passwordRep');

	if(inputPassword1.value == inputPassword2.value){
        campsLogin['password']=inputPassword1.value;
        console.log(campsLogin)
	} else {
        alert('Las contraseñas no coinciden');
        window.location.replace("../web-pages/login.html");

	}
}

let campsLogin={
    "username": "",
    "password": "",
    "dni": ""
}

//Cridem les dades d'usuari
async function consultaDadesUsuaris(){
    	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/usuari/getUsuaris";

    let dni = document.getElementById('dni').value;
    let password =  document.getElementById('password').value;
    let passwordRep =  document.getElementById('passwordRep').value;

    // let campsPasswordRecord ={
    //     ""
    // }
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;
        console.log(json)
        console.log(camps)
        console.log(dni)
        // const dniUsuari = baixa.dni;

        for (let i = 0 ; i < json.length ; i++){

            if (json[i].dni == dni){
                const dades = json[i];
                console.log(dades);
               campsLogin['username']=dades.email;
               campsLogin['dni']=dades.dni;
               SendLocalitzaLogin(dades);
               SendDataLogin(dades)
                }
        }
        
    } catch (err) {
        location.reload();
		let message = err.statusText || "Ocurrió un error en el registro";
        console.log('Error' + ': ' + err);
      }
}

async function SendLocalitzaLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/getLogin";
	
	camps.username=camps.email;
	let username = camps.username;
	let password = camps.password;
	let dni = camps.dni;

	let campsLogin={
		"username": username,
		"password": password,
		"dni": dni
	}
	
	try {
		let options = {
          	method: "GET",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

			  data: campsLogin,
		
        },
		res = await axios(URL, options),
		json = await res.data;
		

		for(let i=0; i<json.length; i++){
			if(json[i].username == username){
				// SendEsborraLogin(json[i]);
                console.log(json[i])
			} 
		}

    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}

async function SendEsborraLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/deleteLogin";
	try {
		let options = {
          	method: "DELETE",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},
        	data: 
            	camps,
        },
		res = await axios(URL, options),
        json = await res.data;

    } catch (err) {
        // location.reload();
		let message = err.statusText || "Ocurrió un error en el registro registro";
        console.log(err)
		console.log('Error' + ': ' + err);
      }
}

async function SendDataLogin(camps){
	
    const URL = "http://localhost:8080/ProvaProjecteDAW/api/login/addLogin";
	


	console.log(campsLogin)
	try {
		let options = {
          	method: "POST",
          	headers: {
            	"Content-type": "application/json; charset=utf-8",
				"Access-Control-Allow-Origin": "*"
		  	},

        	data: campsLogin,
		
        },
		res = await axios(URL, options),
		json = await res.data;
		localStorage.setItem('login', campsLogin);
        alert('Datos modificados')



    } catch (err) {
		//la resposta es diferent de 200 i s'ha produit un error en el login d'usuari i surt un alert informant
        location.reload();
		let message = err.statusText || "S'ha produit un error en el registre login";
		console.log(err)
        alert(err);
		
      }
}