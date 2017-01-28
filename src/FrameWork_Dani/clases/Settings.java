package FrameWork_Dani.clases;

import FrameWork_Dani.modulos.language.Language;

public class Settings {
	
	public static String currency;
	public static int decimal;
	public static String fechaForm;
	public static String language;
	public static Language lang =null;
	public static String saveFormat;
	public static String saveMode;

	
	public Settings(){
		currency="€";
		decimal=1;
		fechaForm="dd/mm/yyyy";
		language="English";
		lang =new Language();
		saveFormat="TXT";
		saveMode="AUTO";
		
	}

	public static String getCurrency() {
		return currency;
	}

	public static void setCurrency(String ValueCurrency) {
		currency = ValueCurrency;
	}

	public static int getDecimal() {
		return decimal;
	}

	public static void setDecimal(int Valuedecimal) {
		decimal = Valuedecimal;
	}

	public static String getFechaForm() {
		return fechaForm;
	}

	public static void setFechaForm(String ValuefechaForm) {
		fechaForm = ValuefechaForm;
	}
	
	public static void setLanguage(String ValueLanguage){
		language=ValueLanguage;
	}
	
	public static String getLanguage(){
		return language;
	}
	
	public static String getSaveFormat() {
		return saveFormat;
	}

	public static void setSaveFormat(String ValueSaveFormat) {
		saveFormat = ValueSaveFormat;
	}
	
	public static String getSaveMode() {
		return saveMode;
	}

	public static void setSaveMode(String ValueSaveMode) {
		saveMode = ValueSaveMode;
	}
	

}
