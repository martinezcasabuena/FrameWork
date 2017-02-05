package FrameWork_Dani.utils.Open_Save_Settings;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import FrameWork_Dani.clases.Settings;


public class Save_Settings {
	
	public static void SaveJsonSettings() {
        String PATH = null;
	     
        try {
	        PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/utils/Archivos/settings.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	    try {
		    XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		    xstreamjson.setMode(XStream.NO_REFERENCES);
		    xstreamjson.alias("Settings", Settings.class);
		    Gson gson = new Gson();
		    String json = gson.toJson(Settings.instance);
		    FileWriter fileXml = new FileWriter(PATH);
		    fileXml.write(json.toString());
		    fileXml.close();
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error");
	    }
	}
}
