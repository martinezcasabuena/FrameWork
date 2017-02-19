package FrameWork_Dani.Functions;
import java.text.DecimalFormat;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;

public class Format {
	
	public static String currency=Settings.getInstance().getCurrency();
	public static int decimal=Settings.getInstance().getDecimal();
	public static String saveFormat=Settings.getInstance().getSaveFormat();
	
	public static void CurrencyFormat(){
		String opt = Settings.getInstance().getCurrency();
    	String currencyOpt[] = {"€","$","£"};
    	
    	opt= Functions.ComboMenuFormats(currencyOpt,Language.getInstance().getProperty("currency_message"),
    			Language.getInstance().getProperty("currency"),opt);
    	switch (opt) {
    	case "€":
    		currency="€";
    		break;
    	case "$":
    		currency="$";
    		break;
    	case "£":
    		currency="£";
    		break;
		}
		Settings.getInstance().setCurrency(currency);
	}
	
	public static void DecimalFormat(){
		String opt="";
		String decimalOpt[]={"1","2","3"};
		
		opt=Functions.ComboMenuFormats(decimalOpt,Language.getInstance().getProperty("decimal_message"),
				Language.getInstance().getProperty("decimal"),opt);
		switch(opt){
		case "1":
			decimal=1;
			break;
		case "2":
			decimal=2;
			break;
		case "3":
			decimal=3;
			break;
		}
		Settings.getInstance().setDecimal(decimal);
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
		String opt = Settings.getInstance().getSaveFormat();
    	String saveFormatOpt[] = {"TXT","XML","JSON"};
    	opt= Functions.ComboMenuFormats(saveFormatOpt,Language.getInstance().getProperty("save_message"),
    			Language.getInstance().getProperty("save_format"),opt);
    	
    	switch (opt) {
		case "TXT":
			saveFormat="TXT";
			break;
		case "XML":
			saveFormat="XML";
			break;
		case "JSON":
			saveFormat="JSON";
			break;
		}
		Settings.getInstance().setSaveFormat(saveFormat);
	}
	
	public static void theme () {
		String [] options = { "METAL", "GTK", "MOTIF", "NINBUS", "WINDOWS95", "WINDOWS" };
		String opt = Settings.getInstance().getTheme();
		opt=Functions.ComboMenuFormats(options, Language.getInstance().getProperty("choose_theme"),
				Language.getInstance().getProperty("theme"),opt);
		switch (opt){
			case "METAL":// Metal - Predeterminado JAVA
				Settings.getInstance().setTheme("METAL");
				Functions_theme.theme();
				break;
	
			case "GTK":// GTK
				Settings.getInstance().setTheme("GTK");
				Functions_theme.theme();
				break;
	
			case "MOTIF":// Motif
				Settings.getInstance().setTheme("MOTIF");
				Functions_theme.theme();
				break;
	
			case "NINBUS":// Nimbus - JAVA
				Settings.getInstance().setTheme("NINBUS");
				Functions_theme.theme();
				break;	
				
			case "WINDOWS95":// WINDOWS 95
				Settings.getInstance().setTheme("WINDOWS95");
				Functions_theme.theme();
				break;
				
			case "WINDOWS":// WINDOWS
				Settings.getInstance().setTheme("WINDOWS");
				Functions_theme.theme();
				break;
		}
	}

}
