package FrameWork_Dani.modulos.language;

import java.io.IOException;
import java.util.Properties;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.utils.Functions;

public class Language extends Properties {
	private String language=Settings.language;
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
	/*
	public Language (String language){
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
	*/
	
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
		String decimalOpt[]={"Spanish","English","Valencian"};
		String language="";
		
		opt=Functions.ComboMenu(decimalOpt, "Chose the number of decimals", "Decimals");
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
		return language;
	}
	
	public void getProperties(String language) {
        try {
            this.load( getClass().getResourceAsStream(language) );
        } catch (IOException ex) {
        }
    }



	
	
	

}
