package FrameWork_Dani.modulos.user.utils;

import javax.swing.JOptionPane;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.utils.Functions;
import FrameWork_Dani.utils.Validate;

public class Functions_data_user {
	//static String fechaForm=Fecha.fechaForm;

	
	public static int askAge(){
		boolean correct=false;
		String cad;
		int age;
		do{
			age=Functions.askInt(Settings.lang.getProperty("ask_age"), "edad");
			cad=Integer.toString(age);
			correct=Validate.validateAge(cad);
		}while(correct==false);
		return age;
	}
	
	public static String askName(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_name")), "Name");
			correct=Validate.validateName(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askDni(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_dni")), "DNI");
			correct=Validate.validateDni(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askAddress(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_address")), "Address");
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askSex(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_sex")+" H-h, M-m"), "Sex");
			correct=Validate.validateSex(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askNavegator(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_navegator")), "Navegator");
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askInterests(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_interests")), "Intereses");
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askNumCuenta(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_naccount")), "Account number");
			correct=Validate.validateAccountNumber(cad);
		}while(correct==false);
		return cad;
	}

	public static String askPrivileges(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_privileges")), "Privileges");
			correct=Validate.validatePrivileges(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askDateNac(String fechaForm){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString(Settings.lang.getProperty("ask_dateNac")+"  "+fechaForm,"Date");
			correct=Validate.validateDate(cad,fechaForm);
			if(correct==false){
				JOptionPane.showMessageDialog(null, "No has introducido un formato de fecha valida.\nUtiliza el formato "+fechaForm);
			}
		}while(correct==false);
		return cad;
	}
	
	public static String askDateCont(String fechaForm){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString(Settings.lang.getProperty("ask_dateCont")+"  "+fechaForm,"Date");
			correct=Validate.validateDate(cad,fechaForm);
			if(correct==false){
				JOptionPane.showMessageDialog(null, "No has introducido un formato de fecha valida.\nUtiliza el formato "+fechaForm);
			}
		}while(correct==false);
		return cad;
	}
	
	public static String askJob(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Settings.lang.getProperty("ask_job")), "Occupation");
			correct=Validate.validateName(cad);
		}while(correct==false);
		return cad;
	}
	
	public static int askNumComments(){
		boolean correct=false;
		String cad="";
		int numComments=0;
		do{
			cad=Functions.askString(Settings.lang.getProperty("ask_ncomments"), "Comments");
			correct=Validate.validateComments(cad);
		}while(correct==false);
		numComments=Integer.parseInt(cad);
		return numComments;
	}
	
	public static int askNumCompras(){
		boolean correct=false;
		String cad="";
		int numCompras=0;
		do{
			cad=Functions.askString(Settings.lang.getProperty("ask_npurchases"), "Compras");
			correct=Validate.validateCompras(cad);
		}while(correct==false);
		numCompras=Integer.parseInt(cad);
		return numCompras;
	}

}
