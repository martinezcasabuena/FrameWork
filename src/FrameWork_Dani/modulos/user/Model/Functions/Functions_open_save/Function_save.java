package FrameWork_Dani.modulos.user.Model.Functions.Functions_open_save;

import FrameWork_Dani.clases.Settings;

public class Function_save {
	
	public static void SaveGenericOnDemand(int opt){
		
		String saveFormat=Settings.getInstance().getSaveFormat(); //Obtengo el formato de guardado		
		switch (opt) {//Switch para saber en que usuario ha entrado
		case 0: //Entra en el usuario Normal
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.OnDemandSaveTxtNormal();
				break;
				
			case "XML" :
				Functions_save_users.OnDemandSaveXmlNormal();
				break;
				
			case "JSON" :
				Functions_save_users.OnDemandSaveJsonNormal();
				break;
			}
			break;
			
		case 1: //Entra en el usuario Cliente
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.OnDemandSaveTxtClient();
				break;
				
			case "XML" :
				Functions_save_users.OnDemandSaveXmlClient();
				break;
				
			case "JSON" :
				Functions_save_users.OnDemandSaveJsonClient();
				break;
			}
			break;
			
		case 2: //Entra en el usuario Admin
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.OnDemandSaveTxtAdmin();
				break;
				
			case "XML" :
				Functions_save_users.OnDemandSaveXmlAdmin();
				break;
				
			case "JSON" :
				Functions_save_users.OnDemandSaveJsonAdmin();
				break;
			}
			break;
		}
	}
	
	public static void SaveGenericAuto(int opt){
		
		String saveFormat=Settings.getInstance().getSaveFormat(); //Obtengo el formato de guardado		
		switch (opt) {//Switch para saber en que usuario ha entrado
		case 0: //Entra en el usuario Normal
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.AutoSaveTxtNormal();
				break;
				
			case "XML" :
				Functions_save_users.AutoSaveXmlNormal();
				break;
				
			case "JSON" :
				Functions_save_users.AutoSaveJsonNormal();
				break;
			}
			break;
			
		case 1: //Entra en el usuario Cliente
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.AutoSaveTxtClient();
				break;
				
			case "XML" :
				Functions_save_users.AutoSaveXmlClient();
				break;
				
			case "JSON" :
				Functions_save_users.AutoSaveJsonClient();
				break;
			}
			break;
			
		case 2: //Entra en el usuario Admin
			switch (saveFormat) {//Switch para saber que formato esta seleccionado en Settings
			case "TXT":
				Functions_save_users.AutoSaveTxtAdmin();
				break;
				
			case "XML" :
				Functions_save_users.AutoSaveXmlAdmin();
				break;
				
			case "JSON" :
				Functions_save_users.AutoSaveJsonAdmin();
				break;
			}
			break;
		}
	}
	
	public static void AutoSave(){
		Functions_save_users.AutoSaveTxtNormal();
		Functions_save_users.AutoSaveTxtClient();
		Functions_save_users.AutoSaveTxtAdmin();
		Functions_save_users.AutoSaveXmlNormal();
		Functions_save_users.AutoSaveXmlClient();
		Functions_save_users.AutoSaveXmlAdmin();
		Functions_save_users.AutoSaveJsonNormal();
		Functions_save_users.AutoSaveJsonClient();
		Functions_save_users.AutoSaveJsonAdmin();
	}
}
