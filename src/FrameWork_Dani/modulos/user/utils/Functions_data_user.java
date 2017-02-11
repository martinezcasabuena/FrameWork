package FrameWork_Dani.modulos.user.utils;

import javax.swing.JOptionPane;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.utils.Functions;
import FrameWork_Dani.utils.Validate;

public class Functions_data_user {
	
	public static int askAge(){
		boolean correct=false;
		String cad;
		int age;
		do{
			age=Functions.askInt(Language.getInstance().getProperty("ask_age"),Language.getInstance().getProperty("age"));
			cad=Integer.toString(age);
			correct=Validate.validateAge(cad);
		}while(correct==false);
		return age;
	}
	
	public static String askName(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_name")),Language.getInstance().getProperty("name"));
			correct=Validate.validateName(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askDni(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_dni")),Language.getInstance().getProperty("dni"));
			correct=Validate.validateDni(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askAddress(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_address")),Language.getInstance().getProperty("address"));
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askSex(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_sex")+" H-h, M-m"),Language.getInstance().getProperty("sex"));
			correct=Validate.validateSex(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askNavigator(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_navigator")),Language.getInstance().getProperty("navigator"));
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askInterests(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_interests")),Language.getInstance().getProperty("interests"));
			correct=Validate.validateLetterNum(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askNumCuenta(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_naccount")),Language.getInstance().getProperty("n_account"));
			correct=Validate.validateAccountNumber(cad);
		}while(correct==false);
		return cad;
	}

	public static String askPrivileges(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_privileges")),Language.getInstance().getProperty("privileges"));
			correct=Validate.validatePrivileges(cad);
		}while(correct==false);
		return cad;
	}
	
	public static String askDateNac(String fechaForm){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString(Language.getInstance().getProperty("ask_dateNac")+"  "+fechaForm,Language.getInstance().getProperty("birth_date"));
			correct=Validate.validateDate(cad,fechaForm);
			if(correct==false){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("date_error_format")+"\n"+
						Language.getInstance().getProperty("use_format")+fechaForm);
			}
		}while(correct==false);
		return cad;
	}
	
	public static String askDateCont(String fechaForm){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString(Language.getInstance().getProperty("ask_dateCont")+"  "+fechaForm,Language.getInstance().getProperty("contract_date"));
			correct=Validate.validateDate(cad,fechaForm);
			if(correct==false){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("date_error_format")+"\n"+
						Language.getInstance().getProperty("use_format")+fechaForm);
			}
		}while(correct==false);
		return cad;
	}
	
	public static String askJob(){
		boolean correct=false;
		String cad="";
		do{
			cad=Functions.askString((Language.getInstance().getProperty("ask_job")),Language.getInstance().getProperty("job"));
			correct=Validate.validateName(cad);
		}while(correct==false);
		return cad;
	}
	
	public static int askNumComments(){
		boolean correct=false;
		String cad="";
		int numComments=0;
		do{
			cad=Functions.askString(Language.getInstance().getProperty("ask_ncomments"),Language.getInstance().getProperty("n_comments"));
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
			cad=Functions.askString(Language.getInstance().getProperty("ask_npurchases"),Language.getInstance().getProperty("n_purchases"));
			correct=Validate.validateCompras(cad);
		}while(correct==false);
		numCompras=Integer.parseInt(cad);
		return numCompras;
	}

}
