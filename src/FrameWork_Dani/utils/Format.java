package FrameWork_Dani.utils;
import java.text.DecimalFormat;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Settings;

public class Format {
	
	public static String currency=Settings.getInstance().getCurrency();
	public static int decimal=Settings.getInstance().getDecimal();
	
	public static void CurrencyFormat(){
		String opt="";
    	String currencyOpt[] = {"€","$","£"};
    	
    	opt= Functions.ComboMenu(currencyOpt,"Choose a currency","Currency");
    	switch (opt) {
    	case "€":
    		currency="€";
    		Settings.getInstance().setCurrency(currency);
    		break;
    	case "$":
    		currency="$";
    		Settings.getInstance().setCurrency(currency);
    		break;
    	case "£":
    		currency="£";
    		Settings.getInstance().setCurrency(currency);
    		break;
		}
	}
	
	public static void DecimalFormat(){
		String opt="";
		String decimalOpt[]={"1","2","3"};
		
		opt=Functions.ComboMenu(decimalOpt, "Chose the number of decimals", "Decimals");
		switch(opt){
		case "1":
			decimal=1;
			Settings.getInstance().setDecimal(decimal);
			break;
		case "2":
			decimal=2;
			Settings.getInstance().setDecimal(decimal);
			break;
		case "3":
			decimal=3;
			Settings.getInstance().setDecimal(decimal);
			break;
		}
	}
	
	public static String Decimal(float sueldo){
		DecimalFormat decimalFormat = new DecimalFormat(".0");
		switch(decimal){
		case 1:
			decimalFormat=new DecimalFormat(".0");
			break;
		case 2:
			decimalFormat=new DecimalFormat(".00");
			break;
		case 3:
			decimalFormat=new DecimalFormat(".000");
			break;
		}
		
		return decimalFormat.format(sueldo);
		
	}
	
	public static void SaveFormat(){
		String opt="";
    	String saveFormatOpt[] = {"TXT","XML","JSON"};
    	opt= Functions.ComboMenu(saveFormatOpt,"Choose a format for saving the data","SaveDataFormat");
    	
    	switch (opt) {
		case "TXT":
			Settings.getInstance().setSaveFormat("TXT");
			break;
		case "XML":
			Settings.getInstance().setSaveFormat("XML");
			break;
		case "JSON":
			Settings.getInstance().setSaveFormat("JSON");
			break;
		}
		
	}

}
