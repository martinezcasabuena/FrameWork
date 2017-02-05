package FrameWork_Dani.clases;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import FrameWork_Dani.utils.Functions;

public class Fecha implements Serializable{

	private String fecha;
	private int day;
	private int month;
	private int year;
	public static String fechaForm=Settings.getInstance().getFechaForm(); 
	//Por defecto el formato sera el que se indice en la clase Settings

	private SimpleDateFormat formato=new SimpleDateFormat(fechaForm);
	
	//Getters & Setters
	public String getFecha(){
		return fecha;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}

	public Fecha(){			

	}
	
	
	public Fecha(String introduceFecha, String fechaForm){			
		String[] SplitArray=null;
		String fechaform=null;
		
		switch (fechaForm) {
		case "dd/mm/yyyy":
			SplitArray = introduceFecha.split("/");
			this.day=Integer.parseInt(SplitArray [0]);
			this.month=Integer.parseInt(SplitArray [1]);
			this.year=Integer.parseInt(SplitArray [2]);
			fechaform=day+"/"+month+"/"+year;
			this.fecha=fechaform;
			break;
		
		case "dd-mm-yyyy":
			SplitArray = introduceFecha.split("-");
			this.day=Integer.parseInt(SplitArray [0]);
			this.month=Integer.parseInt(SplitArray [1]);
			this.year=Integer.parseInt(SplitArray [2]);
			fechaform=day+"-"+month+"-"+year;
			this.fecha=fechaform;
			break;
		
		case "yyyy/mm/dd":
			SplitArray = introduceFecha.split("/");
			this.day=Integer.parseInt(SplitArray [2]);
			this.month=Integer.parseInt(SplitArray [1]);
			this.year=Integer.parseInt(SplitArray [0]);
			fechaform=year+"/"+month+"/"+day;
			this.fecha=fechaform;
			break;
			
		case "yyyy-mm-dd":
			SplitArray = introduceFecha.split("-");
			this.day=Integer.parseInt(SplitArray [2]);
			this.month=Integer.parseInt(SplitArray [1]);
			this.year=Integer.parseInt(SplitArray [0]);
			fechaform=year+"-"+month+"-"+day;
			this.fecha=fechaform;
			break;
		}	
		
	}
	
	public Calendar fromStringToCalendar(String fecha){
		Date fechaDate=new Date();
		Calendar fechaCalendar=new GregorianCalendar();
		
		try{
			fechaDate = formato.parse(fecha);
			fechaCalendar.setTime(fechaDate);
			}catch (ParseException e){
				//JOptionPane.showMessageDialog(null, "No se puede crear la fecha");
			e.printStackTrace();
			}
		return fechaCalendar;
		}
	
	public String fromCalendarToString(){
	      Calendar cal = Calendar.getInstance();
	      return (cal.getTime().toString());
	   }
	
	public int comparaFechas(Fecha fecha2){
		Calendar cal1 = this.fromStringToCalendar(fecha); //Fecha nacimiento
		Calendar cal2 = this.fromStringToCalendar(fecha2.toStringFecha()); //Fecha contratacion
		Calendar cal3 = this.fromStringToCalendar(fechaSistema().toStringFecha()); //Fecha actual del sistema
		
		  if (cal2.after(cal3)) //Fecha contratacion despues de la del sistema
			  return 1;
		  else if (cal1.after(cal2)) //Fecha nacimiento despues de fecha contratacion
			  return 2;
		  else if(cal1.before(cal2)) //Fecha nacimiento antes de la de contratacion
			  return 3;
		  else 
			  return 4;
	}
	
	public int comparaFechasOrder(Fecha fecha2){ //Funcion para comparar las fechas para hacer el Order de los usuarios.
		Calendar cal1 = this.fromStringToCalendar(fecha); //Fecha nacimiento
		Calendar cal2 = this.fromStringToCalendar(fecha2.toStringFecha()); //Fecha contratacion
		
		  if (cal1.after(cal2)) //Fecha nacimiento despues de fecha contratacion
			  return 1;
		  else if(cal1.before(cal2)) //Fecha nacimiento antes de la de contratacion
			  return -1;
		  else 
			  return 0;
	}
	
	public int RestaFechas(){
		int diferencia, any1, anyosistema;
		Calendar cal1=new GregorianCalendar();
		
		cal1=(fromStringToCalendar(fecha));
		
		any1=cal1.get(Calendar.YEAR);
		anyosistema=this.anyoactual();
		
		diferencia=anyosistema-any1;
		
		return diferencia;
	}
		

	 public String toStringFecha(){
			String fecha=null;
			
			switch (fechaForm) {
			case "dd/mm/yyyy":
				fecha=this.day+"/"+this.month+"/"+this.year;
				break;
			
			case "dd-mm-yyyy":
				fecha=this.day+"-"+this.month+"-"+this.year;
				break;
			
			case "yyyy/mm/dd":
				fecha=this.year+"/"+this.month+"/"+this.day;

				break;
				
			case "yyyy-mm-dd":
				fecha=this.year+"-"+this.month+"-"+this.day;
				break;
			}
			//fecha=this.day+"/"+this.month+"/"+this.year;
				
		return fecha;
	}

	 public boolean ValidaFecha() {
			
			int dia;
			int mes;
			int anyo;
			boolean valido = false;
			
			dia=this.day;
			mes=this.month;
			anyo=this.year;
			
			if ((anyo>1930)&&(anyo <=this.anyoactual())) {
				if ((mes>=1)&&(mes<=12)) {
					switch(mes){
						case 1: //Enero
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 2: //Febrero
							if ((((anyo%100 == 0) && (anyo%400 == 0))||((anyo%100 != 0) && (anyo%  4 == 0)))&&(dia>0)&&(dia<=29))
								valido=true;  // A�o Bisiesto
							else if ((dia>0)&&(dia<=28))
								valido=true;
							break;	
						case 3: //Marzo
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 4: //Abril
							if ((dia>0)&&(dia<=30))
								valido=true;
							break;
						case 5: //Mayo
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 6: //Junio
							if ((dia>0)&&(dia<=30))
								valido=true;
							break;
						case 7: //Julio
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 8: //Agosto 
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 9: //Septiembre
							if ((dia>0)&&(dia<=30))
								valido=true;
							break;
						case 10: //Octubre
							if ((dia>0)&&(dia<=31))
								valido=true;
							break;
						case 11: //Noviembre
							if ((dia>0)&&(dia<=30))
								valido= true;
							break;
						case 12: //Diciembre
				
							if ((dia>0)&&(dia<=31))
								valido= true;
							break;
		
						default:
							valido= false;
					}		
				}else
					valido= false;
			}else
				valido= false;
			return valido;
		}

	    public int anyoactual(){
	        Calendar fecha = new GregorianCalendar();
	        int anyo = fecha.get(Calendar.YEAR);
	        return anyo;
	    }

	    public Fecha fechaSistema () { //Obtener fecha sistema con el formato dd/mm/yyyy
			Calendar fecha = new GregorianCalendar();
			String fechaActual="";
			Fecha fechaAct;
	        int anyo = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH)+1;
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
	        fechaActual=dia+"/"+mes+"/"+anyo;
			fechaAct=new Fecha(fechaActual,"dd/mm/yyyy");
	        
			return fechaAct;
		}
	    
	    public static String fechaForm(){
	    	String opt="";
	    	String formatDate[] = {"dd/mm/yyyy","dd-mm-yyyy","yyyy/mm/dd","yyyy-mm-dd"};
	    	
	    	opt= Functions.ComboMenu(formatDate,"Choose a format for date","Date Settings");
	    	switch (opt) {
	    	case "dd/mm/yyyy":
	    		fechaForm = "dd/mm/yyyy";
				break;
			case "dd-mm-yyyy":
				fechaForm = "dd-mm-yyyy";
				break;
			case "yyyy/mm/dd":
				fechaForm = "yyyy/mm/dd";
				break;
			case "yyyy-mm-dd":
				fechaForm = "yyyy-mm-dd";
				break;
			}
    		Settings.getInstance().setFechaForm(fechaForm);
	    	return fechaForm;
	    }
}
















