package FrameWork_Dani.clases.language;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.utils.Functions;

public class Language extends Properties {
	private String language=Settings.getInstance().getLanguage();
	private static Language instance;
	
	public Language (){
		 switch(language){
		    case "English":
		        getProperties("EN.properties");
		        break;
		    case "Spanish":
		        getProperties("ES.properties");
		        break;
		    case "Valencian":
		    	getProperties("VA.properties");
		    	break;
		    }
	}
	
	public static Language getInstance () {
		if (instance==null){
			instance = new Language();
		}
		return instance;
	}
	
	public void setLanguage(String language) {
		this.language = language;
		switch(language){
	    case "English":
	        getProperties("EN.properties");
	        Settings.getInstance().setLanguage("English");
	        break;
	    case "Spanish":
	        getProperties("ES.properties");
	        Settings.getInstance().setLanguage("Spanish");
	        break;
	    case "Valencian":
	    	getProperties("VA.properties");
	        Settings.getInstance().setLanguage("Valencian");
	    	break;
		}
	}
		
		public String getLanguage() {
			return language;
		}
	
	public static String LanguageOptions(){
		String opt="";
		String languageOpt[]={Language.getInstance().getProperty("Spanish"),Language.getInstance().getProperty("English"),
							  Language.getInstance().getProperty("Valencian")}; 
		String language=Settings.getInstance().getLanguage();
		
		opt=Functions.ComboMenu(languageOpt, Language.getInstance().getProperty("language_message"),Language.getInstance().getProperty("language"));
		switch(language){
		case "English":
			switch(opt){
			case "Spanish":
				language="Spanish";
				break;
			case "English":
				language="English";
				break;
			case "Valencian":
				language="Valencian";
				break;
			}
			break;
		case "Spanish":
			switch(opt){
			case "Español":
				language="Spanish";
				break;
			case "Ingles":
				language="English";
				break;
			case "Valenciano":
				language="Valencian";
				break;
			}
			break;
		case "Valencian":
			switch(opt){
			case "Espanyol":
				language="Spanish";
				break;
			case "Angles":
				language="English";
				break;
			case "Valencia":
				language="Valencian";
				break;
			}
			break;
		}

		return language;
	}
	
	public void getProperties(String language) {
        try {
            this.load( getClass().getResourceAsStream(language));
        } catch (IOException ex) {
        }
    }	
	
}
