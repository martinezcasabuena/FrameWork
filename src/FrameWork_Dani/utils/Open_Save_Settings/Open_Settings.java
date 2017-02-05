package FrameWork_Dani.utils.Open_Save_Settings;

import java.io.FileReader;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import FrameWork_Dani.clases.Settings;

public class Open_Settings {
	
	public static void OpenJsonSettings() {
    	String PATH = null;
    	Settings settings = null;
    	
        try {
        	XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Settings", Settings.class);
			
	        PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/utils/Archivos/settings.json";

	        JsonReader reader = new JsonReader(new FileReader(PATH));
	        JsonParser parser = new JsonParser();
	        JsonElement root = parser.parse(reader);
	        
	        Gson json = new Gson();
	        settings = json.fromJson(root, Settings.class);
	        Settings.getInstance().setCurrency(settings.getCurrency());
	        Settings.getInstance().setDecimal(settings.getDecimal());
	        Settings.getInstance().setFechaForm(settings.getFechaForm());
	        Settings.getInstance().setLanguage(settings.getLanguage());
	        Settings.getInstance().setSaveFormat(settings.getSaveFormat());
	        //Settings.getInstance().setTheme(config.getTheme());
	        
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
