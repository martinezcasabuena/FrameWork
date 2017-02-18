package FrameWork_Dani;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.clases.User;
import FrameWork_Dani.utils.Functions;
import FrameWork_Dani.utils.Functions_theme;

public class Tester {
	public static Fecha datebirthday (){		
		String fechaform=Settings.getInstance().getFechaForm();
		String fecha="";
		Calendar date = new GregorianCalendar();
		int anyoactual = date.get(Calendar.YEAR);
		int day = (int) (Math.random() * (1 - 31) + 31);
		int month = (int) (Math.random() * (1 - 12) + 12);
		int year = (int) (Math.random() * (1920 - (anyoactual-18)) + (anyoactual-18));
		switch (fechaform) {
		case "dd/mm/yyyy":
			fecha=day+"/"+month+"/"+year;
			break;
		case "dd-mm-yyyy":
			fecha=day+"-"+month+"-"+year;
			break;
		case "yyyy/mm/dd":
			fecha=year+"/"+month+"/"+day;
			break;
		case "yyyy-mm-dd":
			fecha=year+"-"+month+"-"+day;
			break;
		}
		Fecha Fecha=new Fecha (fecha,fechaform);
		return Fecha;
		
	}
	
	public static Fecha datecontract (Fecha fnac){
		String fnacString=fnac.toString(); //Convertimos la fecha de nacimiento al formato dd/mm/yyyy
		String fechaform=Settings.getInstance().getFechaForm();
		String fecha="";
		Calendar date = new GregorianCalendar();
		String[] SplitArray=null;
		int añoNacimiento=0;
		SplitArray = fnacString.split("/");
		añoNacimiento=Integer.parseInt(SplitArray [2]); //Obtenemos el año de la fecha de nacimiento haciendo un SplitArray de "/" 

		int anyoactual = date.get(Calendar.YEAR);
		int day = (int) (Math.random() * (1 - 31) + 31);
		int month = (int) (Math.random() * (1 - 12) + 12);
		int year = (int) (Math.random() * ((añoNacimiento+18) - anyoactual) + anyoactual);
		switch (fechaform) {
		case "dd/mm/yyyy":
			fecha=day+"/"+month+"/"+year;
			break;
		case "dd-mm-yyyy":
			fecha=day+"-"+month+"-"+year;
			break;
		case "yyyy/mm/dd":
			fecha=year+"/"+month+"/"+day;
			break;
		case "yyyy-mm-dd":
			fecha=year+"-"+month+"-"+day;
			break;
		}
		Fecha Fecha=new Fecha (fecha,fechaform);
		return Fecha;
	}
	public static void main(String[] args) {
		
		Fecha fnac=datebirthday();
		Fecha fcont=datecontract(fnac);
		
		System.out.println(fnac);
		System.out.println(fcont);


	}
	}