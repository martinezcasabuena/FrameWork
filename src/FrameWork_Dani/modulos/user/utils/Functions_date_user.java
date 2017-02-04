package FrameWork_Dani.modulos.user.utils;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.User;

public class Functions_date_user {
	
	//static String fechaForm=Fecha.fechaForm;


	public static Fecha DateNac() {
		boolean correct = false;
		boolean result1 = false;
		String fechaNac = "";
		Fecha fnac = null;
		int edad = 0;
		do {
			do {
				fechaNac = Functions_data_user.askDateNac(Settings.getInstance().getFechaForm()); //Pedimos feha nacimiento
				fnac = new Fecha(fechaNac,Settings.getInstance().getFechaForm());
				result1 = fnac.ValidaFecha(); //Validamos la fecha
				if(result1==false){
					JOptionPane.showMessageDialog(null, "No has introducido una fecha valida");
				}
			} while (result1 == false);
			edad = fnac.RestaFechas(); //Calculamos la edad para comprobar que es mayor de edad
			if (edad < 18) {
				JOptionPane.showMessageDialog(null, "Tienes que ser mayor de edad");
				correct = false;
			} else {
				correct = true;
			}
		} while (correct == false);
		return fnac;
	}
	
	public static Fecha DateContract(Fecha fnac,String fechaForm){
		String fechaCont="";
		Fecha fcont=null;
		boolean result1=false;
		boolean result2=false;
		boolean correct=false;
		int compara=0;
		
		do{
			do {//Comprueba formato y valida la fecha
				fechaCont = Functions_data_user.askDateCont(fechaForm); //Pedimos fecha contrataci�n
				fcont = new Fecha(fechaCont,fechaForm);
				result1 = fcont.ValidaFecha(); //Validamos la fecha de contrataci�n
				if(result1==false){
					JOptionPane.showMessageDialog(null, "No has introducido una fecha valida");
				}
			} while (result1 == false);
			//fnac=User.fnac; //Obtenemos la fecha de nacimiento de la clase User **FUNCIONA SI fnac esta STATIC en clase USER**
			
			compara=fnac.comparaFechas(fcont);//Comparamos la fecha de nacimiento con la de contrataci�n
			switch(compara){
			case 1: //Fecha superior a la fecha actual
				correct=false;
				JOptionPane.showMessageDialog(null, "La fecha de contrataci�n no puede superior a la fecha actual");
				break;
			
			case 2: //Fecha despues despu�s de la de nacimiento
				correct=false;
				JOptionPane.showMessageDialog(null, "La fecha de contrataci�n no puede ser inferior a la de nacimiento");
				break;
				
			case 3: //Fecha anterior a la de nacimiento (Valida)
				result2=CompruebaFechaContract(fnac, fcont);
				if(result2==true){
					correct=true;
				}else{
					correct=false;
				}
				break;
				
			case 4: //Fecha igual
				correct=false;
				JOptionPane.showMessageDialog(null, "La fecha de contrataci�n no puede ser igual a la de nacimiento");
				break;
			}
				
		}while(correct==false);
		
		return fcont;
	}
	
	public static Fecha DateAlta(){
		Fecha falt=null;
		falt = new Fecha();
		falt=falt.fechaSistema();
		return falt;
	}

	
	public static boolean CompruebaFechaContract(Fecha fnac, Fecha fcont){
		int antig=0,edad=0,comprobarEdad=0;
		boolean correct=false;
		
		antig=CalcAntiguedad(fcont); //Calculamos los a�os de antiguedad para comprobar la edad
		edad=CalcAge(fnac); //Calculamos la edad
		comprobarEdad = (edad - antig); //Restamos la edad y la antiguedad
		if(comprobarEdad<18 || comprobarEdad>70){ //Comprobar si esta entre 18 y 70 a�os
			JOptionPane.showMessageDialog(null, "La edad para poder trabajar es de 18 hasta 70 a�os");
			correct=false;
		}else{
		correct=true;
		}
		return correct;
	}
	
	public static boolean CompruebaFechaAlta(Fecha fnac, Fecha falt){
		int antig=0,edad=0,comprobarEdad=0;
		boolean correct=false;
		
		antig=CalcAntiguedad(falt); //Calculamos los a�os de antiguedad para comprobar la edad
		edad=CalcAge(fnac); //Calculamos la edad
		comprobarEdad = (edad - antig); //Restamos la edad y la antiguedad
		if(comprobarEdad<18){ //Comprobar si es mayor de 18
			JOptionPane.showMessageDialog(null, "La edad no puede ser menor a 18 a�os");
			correct=false;
		}else{
		correct=true;
		}
		return correct;
	}
	
	public static int CalcAntiguedad(Fecha fcont){
		int antig=0;
		antig=fcont.RestaFechas();
		return antig;
	}

	public static int CalcAge(Fecha fnac) {
		int age = 0;
		age = fnac.RestaFechas();
		return age;
	}
	
	public static Fecha UpdateDateNacClient(User user,String fechaForm){
		Fecha fnac;
		boolean correct=false;
		boolean correct1=false;

		do{
			fnac=Functions_date_user.DateNac(); //Pedimos la fecha de nacimiento
			int compara=((Cliente)user).getFechaAlta().comparaFechas(fnac); //Comparamos si la fecha de nacimiento
																		  	//es mayor a la del alta del sistema
			if(compara==3){
				correct=false;
				JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser posterior a la de alta en el sistema");
			}else{
				correct1=Functions_date_user.CompruebaFechaContract(fnac,((Cliente)user).getFechaAlta());
				if(correct1==true){
					correct=true;
					//user.setFechaNac(fnac);
				}else{
					correct=false;
				}
			}
		}while(correct==false);
		return fnac;
	}
	
	public static Fecha UpdateDateNacAdmin(User user,String fechaForm){
		Fecha fnac;
		boolean correct=false;
		boolean correct1=false;
		
		do{
			fnac=Functions_date_user.DateNac(); //Pedimos la fecha de nacimiento
			int compara=((Admin)user).getFechaCont().comparaFechas(fnac); //Comparamos si la fecha de nacimiento
																		  //es mayor a la de contrataci�n
			if(compara==3){
				correct=false;
				JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser posterior a la de contrataci�n");
			}else{
				correct1=Functions_date_user.CompruebaFechaContract(fnac,((Admin)user).getFechaCont());
				if(correct1==true){
					correct=true;
					//user.setFechaNac(fnac);
				}else{
					correct=false;
				}
			}
		}while(correct==false);
		
		return fnac;
	}


}
