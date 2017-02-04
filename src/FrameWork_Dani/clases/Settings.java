package FrameWork_Dani.clases;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.utils.Format;
import FrameWork_Dani.utils.Open_Save_Settings.Open_Settings;
import FrameWork_Dani.utils.Open_Save_Settings.Save_Settings;

@XStreamAlias("Settings")
public class Settings implements Serializable {
	
	@XStreamAlias("currency")
	public static String currency;
	@XStreamAlias("decimal")
	public static int decimal;
	@XStreamAlias("fechaForm")
	public static String fechaForm;
	@XStreamAlias("language")
	public static String language;
	@XStreamAlias("saveFormat")
	public static String saveFormat;
	@XStreamAlias("saveMode")
	public static String saveMode;
	@XStreamAlias("instance")
	public static Settings instance;
	public Language lang =null;
	
	public Settings(){
		currency="€";
		decimal=1;
		fechaForm="dd/mm/yyyy";
		language="English";
		lang =new Language();
		saveFormat="TXT";
	}
	
	public static Settings getInstance () {
		if (instance == null){
			instance = new Settings ();
			//Open_Settings.OpenJsonSettings();
			
			//Language.getInstance();

			Singleton.userNormal=new ArrayList <Normal> ();
			Singleton.userCliente = new ArrayList <Cliente> ();
			Singleton.userAdmin = new ArrayList <Admin> ();
			
			//Functions_open_auto.open();
		}
		return instance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String ValueCurrency) {
		currency = ValueCurrency;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int Valuedecimal) {
		decimal = Valuedecimal;
	}

	public String getFechaForm() {
		return fechaForm;
	}

	public void setFechaForm(String ValuefechaForm) {
		fechaForm = ValuefechaForm;
	}
	
	public void setLanguage(String ValueLanguage){
		language=ValueLanguage;
	}
	
	public String getLanguage(){
		return language;
	}
	
	public String getSaveFormat() {
		return saveFormat;
	}

	public void setSaveFormat(String ValueSaveFormat) {
		saveFormat = ValueSaveFormat;
	}
	
	public String getSaveMode() {
		return saveMode;
	}

	public void setSaveMode(String ValueSaveMode) {
		saveMode = ValueSaveMode;
	}
	

}
