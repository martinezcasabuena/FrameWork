package FrameWork_Dani.modulos.user.utils.Functions_open_save;

import FrameWork_Dani.clases.Settings;

public class Function_open {
	
	public static void OpenGenericOnDemand(int opt){
		
		String saveFormat=Settings.getInstance().getSaveFormat(); //Obtengo el formato de guardado		
		switch (opt) {//Switch para saber en que usuario ha entrado
		case 0: //Entra en el usuario Normal
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.OnDemandOpenTxtNormal();
				break;
				
			case "XML" :
				Functions_open_users.OnDemandOpenXmlNormal();
				break;
				
			case "JSON" :
				Functions_open_users.OnDemandOpenJsonNormal();
				break;
			}
			break;
			
		case 1: //Entra en el usuario Cliente
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.OnDemandOpenTxtClient();
				break;
				
			case "XML" :
				Functions_open_users.OnDemandOpenXmlClient();
				break;
				
			case "JSON" :
				Functions_open_users.OnDemandOpenJsonClient();
				break;
			}
			break;
			
		case 2: //Entra en el usuario Admin
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.OnDemandOpenTxtAdmin();
				break;
				
			case "XML" :
				Functions_open_users.OnDemandOpenXmlAdmin();
				break;
				
			case "JSON" :
				Functions_open_users.OnDemandOpenJsonAdmin();
				break;
			}
			break;
		}
	}

	public static void OpenGenericAuto(int opt){
		String saveFormat=Settings.getInstance().getSaveFormat(); //Obtengo el formato de guardado		
		switch (opt) {//Switch para saber en que usuario ha entrado
		case 0: //Entra en el usuario Normal
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.AutoOpenTxtNormal();
				break;
				
			case "XML" :
				Functions_open_users.AutoOpenXmlNormal();
				break;
				
			case "JSON" :
				Functions_open_users.AutoOpenJsonNormal();
				break;
			}
			break;
			
		case 1: //Entra en el usuario Cliente
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.AutoOpenTxtClient();
				break;
				
			case "XML" :
				Functions_open_users.AutoOpenXmlClient();
				break;
				
			case "JSON" :
				Functions_open_users.AutoOpenJsonClient();
				break;
			}
			break;
			
		case 2: //Entra en el usuario Admin
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_open_users.AutoOpenTxtAdmin();
				break;
				
			case "XML" :
				Functions_open_users.AutoOpenXmlAdmin();
				break;
				
			case "JSON" :
				Functions_open_users.AutoOpenJsonAdmin();
				break;
			}
			break;
	}
}
	
	public static void AutoOpen(){
		Functions_open_users.AutoOpenTxtNormal();
		Functions_open_users.AutoOpenTxtClient();
		Functions_open_users.AutoOpenTxtAdmin();
		Functions_open_users.AutoOpenXmlNormal();
		Functions_open_users.AutoOpenXmlClient();
		Functions_open_users.AutoOpenXmlAdmin();
		Functions_open_users.AutoOpenJsonNormal();
		Functions_open_users.AutoOpenJsonClient();
		Functions_open_users.AutoOpenJsonAdmin();
	}

}
