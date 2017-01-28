package FrameWork_Dani.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import FrameWork_Dani.clases.Fecha;

public class Validate {
	private static final String name="^[a-zA-Z\\s]*$";
	private static final String letternumbers="^[A-Za-z0-9-\\s]*$";//Nombre mixto con espacios y digitos
	private static final String plantilla_id="^([A-Z]{1})([0-9]{4})$";//1 letra en mayuscula y 4 digitos
	private static final String cpostal="^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$";
	private static final String phone="^[0-9]{2,3}-? ?[0-9]{6,7}$";
	private static final String dni="([0-9]{8})([A-Z])";
	private static final String email=("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	//private static final String date="(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
	private static final String age="^[0-9]{1,2}$";
	private static final String sex="([H,M]|[h,m])";
	private static final String accountnumber="(([0-9]{2})([0-9]{18}))";
	private static final String privileges="([reading,writing]|[Reading,Writing])";
	private static final String num="^[0-9]{1,5}$";
	private static final String date1 = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$"; //  dd/mm/yyyy
	private static final String date2 = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)\\d{2}$"; //  dd-mm-yyyy
	private static final String date3 = "^(19|20)\\d{2}/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$"; //  yyyy/mm/dd
	private static final String date4 = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"; //  yyyy-mm-dd


	public static boolean validateName(String cad){
		Pattern pattern=Pattern.compile(name);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateDni(String cad){
		Pattern pattern=Pattern.compile(dni);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validatePhone(String cad){
		Pattern pattern=Pattern.compile(phone);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateLetterNum(String cad){
		Pattern pattern=Pattern.compile(letternumbers);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateEmail(String cad){
		Pattern pattern=Pattern.compile(email);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateAge(String cad){
		Pattern pattern=Pattern.compile(age);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateSex(String cad){
		Pattern pattern=Pattern.compile(sex);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateAccountNumber(String cad){
		Pattern pattern=Pattern.compile(accountnumber);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validatePrivileges(String cad){
		Pattern pattern=Pattern.compile(privileges);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateDate(String cad,String fechaForm){
		String DatePattern="";
		switch(fechaForm){
		case "dd/mm/yyyy":
			DatePattern = date1;
			break;
		case "dd-mm-yyyy":
			DatePattern = date2;
			break;
		case "yyyy/mm/dd":
			DatePattern = date3;
			break;
		case "yyyy-mm-dd":
			DatePattern = date4;
			break;
		}
		
		Pattern pattern=Pattern.compile(DatePattern);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateComments(String cad){
		Pattern pattern=Pattern.compile(num);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static boolean validateCompras(String cad){
		Pattern pattern=Pattern.compile(num);
		Matcher matcher=pattern.matcher(cad);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	
}
