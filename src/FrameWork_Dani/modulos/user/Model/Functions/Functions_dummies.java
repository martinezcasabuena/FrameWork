package FrameWork_Dani.modulos.user.Model.Functions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;


public class Functions_dummies {
	public static String dni(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
    }
	
	public static String DNI (){
		String cad = "";
        long time = new java.util.GregorianCalendar().getTimeInMillis();
        Random random = new Random(time);
        while (cad.length() < 8) {
            char c = (char) random.nextInt(255);
            if ((c >= '1' && c <= '9')) {
                cad += c;
            }
        }
        int numberdni = Integer.parseInt(cad);
        return dni(numberdni);
	}
	
	public static String user (){
		String user = "";
		String[] users = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return user = users[position];
	}
	
	
	public static String name (){
		String name = "";
		String[] names = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return name = names[position];
	}
	
	public static String surname (){
		String surname = "";
		String [] surnames = {"alfonso", "aliaga", "bas", "bataller", "boluda", "conesa", "camarena", "cucart", "doria",
					"ferrero", "garcia", "figuera", "tormo", "montagud", "gramage", "ubeda", "revert", "cordoba", "sempere",
					"martinez", "lopez", "albuixech", "torro", "belda", "mateu", "ribera", "satorres", "rubio", "cifuentes",
					"frances", "gomez", "mico", "ferrandiz", "casanova"};
		
		int position = (int) (Math.random() * 222) % 10;
		return surname = surnames[position];
	}
	
	public static String address (){
		String address = "";
		String [] adresses = {"Calle alfonso", "Avd aliaga", "Avd bas", "Calle bataller", "Avd boluda", "cAvd onesa", "Avd camarena",
					"Calle cucart", "Avd doria","Avd ferrero", "Calle garcia", "Avd figuera", "Calle tormo", "Calle montagud",
					"Calle gramage","Calle ubeda", "Calle revert", "Avd cordoba", "Avd sempere","Calle martinez", "Avd lopez",
					"Avd albuixech","Calle torro", "Calle belda", "Calle mateu", "Avd ribera", "Avd satorres", "Avd rubio", "cifuentes",
					"Calle frances","Calle gomez", "Calle mico", "Calle esad", "Calle casanova"};
		
		int position = (int) (Math.random() * 222) % 10;
		return address = adresses[position];
	}
	
	public static String interests (){
		String[] interests = {"Tecnologia","Ciencias","Deportes","Politica","Hogar","Naturaleza","Fauna"};
		Random random = new Random();
	    int select = random.nextInt(interests.length); 
		return interests[select];
	}
	
	public static String navigator (){
		String[] navigators = {"Google Chrome","Mozilla FireFox","Opera","Safari","Microsoft Edge","Internet Explorer"};
		Random random = new Random();
	    int select = random.nextInt(navigators.length); 
		return navigators[select];
	}
	
	public static int comments (){
		int comments = (int) (Math.random() * (10 - 100) + 100);
		return (int) Math.rint(comments * 100) / 100;
	}
	
	public static String email (){
		String email = "";
		String[] emails = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return email = emails[position]+"@gmail.com";
	}
	public static String sex(){
		 String [] sex = {"H", "M"};
	     Random random = new Random();
	     int select = random.nextInt(sex.length); 
	     
	     return sex[select];
	}
	
	public static String Job(){
		 String [] job = {"Tester", "Programmer","Analyst","Designer","Hardware Expert","Software Expert","Teacher","Engineer"};
	     Random random = new Random();
	     int select = random.nextInt(job.length); 
	
	     return job[select];
	}
	
	public static String mobilephone (){
		String mobilephone = "";
        long time = new java.util.GregorianCalendar().getTimeInMillis();
        Random random = new Random(time);
        while (mobilephone.length() < 9) {
            char c = (char) random.nextInt(255);
            if ((c >= '0' && c <= '9')) {
            	mobilephone += c;
            }
        }
        return mobilephone;
	}
	
	public static String nAccount (){
		String nAccount = "";
        long time = new java.util.GregorianCalendar().getTimeInMillis();
        Random random = new Random(time);
        while (nAccount.length() < 20) {
            char c = (char) random.nextInt(255);
            if ((c >= '0' && c <= '9')) {
            	nAccount += c;
            }
        }
        return nAccount;
	}
	
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
	
	
	
	public static float incentive (){
		float incentive = (float) (Math.random() * (200 - 500) + 500);
		return (float) Math.rint(incentive * 100) / 100;
	}
	
	public static int activity (){
		int activity = (int) (Math.random() * (10 - 100) + 100);
		return (int) Math.rint(activity * 100) / 100;
	}
	
	public static int shopping (){
		float shopping = (int) (Math.random() * (50 - 1000) + 1000);
		return (int) Math.rint(shopping * 100) / 100;
	}
}
