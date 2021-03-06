package FrameWork_Dani.clases;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.Functions.Functions_theme;
import FrameWork_Dani.Functions.Open_Save_Settings.Open_Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.Cliente;
import FrameWork_Dani.modulos.user.Model.clases.Normal;
import FrameWork_Dani.modulos.user.Model.clases.Singleton;

@XStreamAlias("Settings")
public class Settings implements Serializable {
	
	@XStreamAlias("currency")
	public String currency;
	@XStreamAlias("decimal")
	public int decimal;
	@XStreamAlias("fechaForm")
	public String fechaForm;
	@XStreamAlias("language")
	public String language;
	@XStreamAlias("saveFormat")
	public String saveFormat;
	@XStreamAlias("theme")
	public String theme;
	@XStreamAlias("instance")
	public static Settings instance;
	
	public Settings(){
		currency="€";
		decimal=1;
		fechaForm="dd/mm/yyyy";
		language="English";
		saveFormat="TXT";
		theme="METAL";
	}
	
	public static Settings getInstance () {
		if (instance == null){
			instance = new Settings ();
			Open_Settings.OpenJsonSettings();
			Functions_theme.theme();
			Language.getInstance();
			
			Singleton.userNormal=new ArrayList <Normal> ();
			Singleton.userCliente = new ArrayList <Cliente> ();
			Singleton.userAdmin = new ArrayList <Admin> ();			
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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String ValueTheme) {
		theme = ValueTheme;
	}
	
	public String toString(){
		String cad="";
		cad=cad+(Language.getInstance().getProperty("date_format")+" : "+this.getFechaForm()+"\n");
		cad=cad+(Language.getInstance().getProperty("currency")+" : "+this.getCurrency()+"\n");
		cad=cad+(Language.getInstance().getProperty("decimal")+" : "+this.getDecimal()+"\n");
		cad=cad+(Language.getInstance().getProperty("language")+" : "+this.getLanguage()+"\n");
		cad=cad+(Language.getInstance().getProperty("save_format")+" : "+this.getSaveFormat()+"\n");
		cad=cad+(Language.getInstance().getProperty("theme")+" : "+this.getTheme()+"\n");
		return cad;
	}
}
