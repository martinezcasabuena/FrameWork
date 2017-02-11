package FrameWork_Dani.modulos.user.utils.Functions_open_save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.clases.User;

public class Functions_open_users {
	
	//--------------NORMAL USER OPEN TXT--------------//

	public static ArrayList<Normal> OnDemandOpenTxtNormal() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			Singleton.userNormal = (ArrayList<Normal>)oi.readObject();
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.userNormal;
    }
	
	public static ArrayList<Normal> AutoOpenTxtNormal() {
    	String PATH = null;
        try {
            File f;
            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.txt";
            f = new File(PATH);
            
            FileInputStream fi=new FileInputStream(f);
			ObjectInputStream oi=new ObjectInputStream(fi);
			Singleton.userNormal = (ArrayList<Normal>)oi.readObject();
			oi.close();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.userNormal;
    }
	
	//--------------NORMAL USER OPEN XML--------------//
	
	 @SuppressWarnings("deprecation")
	public static ArrayList<Normal> OnDemandOpenXmlNormal() {
	    	String PATH=null;
	    	try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, Normal.class);
	 
	            JFileChooser fileChooser = new JFileChooser();
	            int seleccion = fileChooser.showOpenDialog(null);
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	            	File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                Singleton.userNormal = (ArrayList <Normal>)xstream.fromXML(new FileReader(PATH));
	            }
	        } catch (Exception e1) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userNormal;
	    }
	 
		@SuppressWarnings("deprecation")
		public static ArrayList<Normal> AutoOpenXmlNormal() {
	    	String PATH=null;
	    	try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, Normal.class);
	            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.xml";
                Singleton.userNormal = (ArrayList <Normal>)xstream.fromXML(new FileReader(PATH));
	        } catch (Exception e1) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userNormal;
	    }
		
		//--------------NORMAL USER OPEN JSON--------------//
	
	public static ArrayList<Normal> OnDemandOpenJsonNormal() {
    	String PATH = null;
    	Normal normal=new Normal();
    	
        try {
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("normal", Normal.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showOpenDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	               
	               Singleton.userNormal.clear();

	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            	normal = json.fromJson(elemento, Normal.class);
	            	Singleton.userNormal.add(normal);
	            	}
	          } 
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.userNormal;
    }
	
	public static ArrayList<Normal> AutoOpenJsonNormal() {
    	String PATH = null;
    	Normal normal=new Normal();
    	User user = null;
    	
        try {
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("normal", Normal.class);
			  
	          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.json";
   
			  Singleton.userNormal.clear();
			  JsonReader lector = new JsonReader(new FileReader(PATH));
			  JsonParser parseador = new JsonParser();
			  JsonElement raiz = parseador.parse(lector);
					  
			  Gson json = new Gson();
			  JsonArray lista = raiz.getAsJsonArray();
			  for (JsonElement elemento : lista) {
				  normal = json.fromJson(elemento, Normal.class);
				  Singleton.userNormal.add((Normal)user);
        	}
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.userNormal;
    }
	
	//--------------CLIENTE USER OPEN TXT--------------//

		public static ArrayList<Cliente> OnDemandOpenTxtClient() {
	    	String PATH = null;
	        try {
	            File f;
	            JFileChooser fileChooser = new JFileChooser();
	            int seleccion = fileChooser.showOpenDialog(null);
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                f = new File(PATH);
	                
	                FileInputStream fi=new FileInputStream(f);
	    			ObjectInputStream oi=new ObjectInputStream(fi);
	    			Singleton.userCliente = (ArrayList<Cliente>)oi.readObject();
	    			oi.close();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	    	return Singleton.userCliente;
	    }
		
		public static ArrayList<Cliente> AutoOpenTxtClient() {
	    	String PATH = null;
	        try {
	            File f;
	            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.txt";
	            f = new File(PATH);
	            
	            FileInputStream fi=new FileInputStream(f);
				ObjectInputStream oi=new ObjectInputStream(fi);
				Singleton.userCliente = (ArrayList<Cliente>)oi.readObject();
				oi.close();
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	    	return Singleton.userCliente;
	    }
		
		//--------------CLIENTE USER OPEN XML--------------//
		
		 @SuppressWarnings("deprecation")
		public static ArrayList<Cliente> OnDemandOpenXmlClient() {
		    	String PATH=null;
		    	try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, Cliente.class);
		 
		            JFileChooser fileChooser = new JFileChooser();
		            int seleccion = fileChooser.showOpenDialog(null);
		            if (seleccion == JFileChooser.APPROVE_OPTION) {
		            	File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                Singleton.userCliente = (ArrayList <Cliente>)xstream.fromXML(new FileReader(PATH));
		            }
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userCliente;
		    }
		 
			@SuppressWarnings("deprecation")
			public static ArrayList<Cliente> AutoOpenXmlClient() {
		    	String PATH=null;
		    	try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, Cliente.class);
		            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.xml";
	                Singleton.userCliente = (ArrayList <Cliente>)xstream.fromXML(new FileReader(PATH));
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userCliente;
		    }
			
			//--------------CLIENTE USER OPEN JSON--------------//
		
		public static ArrayList<Cliente> OnDemandOpenJsonClient() {
	    	String PATH = null;
	    	Cliente cliente=new Cliente();
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("cliente", Cliente.class);
				  
				  JFileChooser fileChooser = new JFileChooser();
		          int seleccion = fileChooser.showOpenDialog(null);
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
		                File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		               
		               Singleton.userCliente.clear();

		                JsonReader lector = new JsonReader(new FileReader(PATH));
		                JsonParser parseador = new JsonParser();
		                JsonElement raiz = parseador.parse(lector);
		            		  
		            	Gson json = new Gson();
		            	JsonArray lista = raiz.getAsJsonArray();
		            	for (JsonElement elemento : lista) {
		            	cliente = json.fromJson(elemento, Cliente.class);
		            	Singleton.userCliente.add(cliente);
		            	}
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userCliente;
	    }
		
		public static ArrayList<Cliente> AutoOpenJsonClient() {
	    	String PATH = null;
	    	Cliente cliente=new Cliente();
	    	User user = null;
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("cliente", Cliente.class);
				  
		          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.json";
	   
				  Singleton.userNormal.clear();
				  JsonReader lector = new JsonReader(new FileReader(PATH));
				  JsonParser parseador = new JsonParser();
				  JsonElement raiz = parseador.parse(lector);
						  
				  Gson json = new Gson();
				  JsonArray lista = raiz.getAsJsonArray();
				  for (JsonElement elemento : lista) {
					  cliente = json.fromJson(elemento, Cliente.class);
					  Singleton.userCliente.add((Cliente)user);
	        	}
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userCliente;
	    }
		
		//--------------ADMIN USER OPEN TXT--------------//

		public static ArrayList<Admin> OnDemandOpenTxtAdmin() {
	    	String PATH = null;
	        try {
	            File f;
	            JFileChooser fileChooser = new JFileChooser();
	            int seleccion = fileChooser.showOpenDialog(null);
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                f = new File(PATH);
	                
	                FileInputStream fi=new FileInputStream(f);
	    			ObjectInputStream oi=new ObjectInputStream(fi);
	    			Singleton.userAdmin = (ArrayList<Admin>)oi.readObject();
	    			oi.close();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	    	return Singleton.userAdmin;
	    }
		
		public static ArrayList<Admin> AutoOpenTxtAdmin() {
	    	String PATH = null;
	        try {
	            File f;
	            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.txt";
	            f = new File(PATH);
	            
	            FileInputStream fi=new FileInputStream(f);
				ObjectInputStream oi=new ObjectInputStream(fi);
				Singleton.userAdmin = (ArrayList<Admin>)oi.readObject();
				oi.close();
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_txt_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	    	return Singleton.userAdmin;
	    }
		
		//--------------ADMIN USER OPEN XML--------------//
		
		 @SuppressWarnings("deprecation")
		public static ArrayList<Admin> OnDemandOpenXmlAdmin() {
		    	String PATH=null;
		    	try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, Admin.class);
		 
		            JFileChooser fileChooser = new JFileChooser();
		            int seleccion = fileChooser.showOpenDialog(null);
		            if (seleccion == JFileChooser.APPROVE_OPTION) {
		            	File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                Singleton.userAdmin = (ArrayList <Admin>)xstream.fromXML(new FileReader(PATH));
		            }
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userAdmin;
		    }
		 
			@SuppressWarnings("deprecation")
			public static ArrayList<Admin> AutoOpenXmlAdmin() {
		    	String PATH=null;
		    	try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, Admin.class);
		            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.xml";
	                Singleton.userAdmin = (ArrayList <Admin>)xstream.fromXML(new FileReader(PATH));
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_xml_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userAdmin;
		    }
			
			//--------------ADMIN USER OPEN JSON--------------//
		
		public static ArrayList<Admin> OnDemandOpenJsonAdmin() {
	    	String PATH = null;
	    	Admin admin =new Admin();
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("admin", Admin.class);
				  
				  JFileChooser fileChooser = new JFileChooser();
		          int seleccion = fileChooser.showOpenDialog(null);
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
						File JFC = fileChooser.getSelectedFile();
						PATH = JFC.getAbsolutePath();
						Singleton.userAdmin.clear();
						JsonReader lector = new JsonReader(new FileReader(PATH));
						JsonParser parseador = new JsonParser();
						JsonElement raiz = parseador.parse(lector);
						Gson json = new Gson();
						JsonArray lista = raiz.getAsJsonArray();
						
						for (JsonElement elemento : lista) {
						admin = json.fromJson(elemento, Admin.class);
						Singleton.userAdmin.add(admin);
		            }
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userAdmin;
	    }
		
		public static ArrayList<Admin> AutoOpenJsonAdmin() {
	    	String PATH = null;
	    	Admin admin =new Admin();
	    	User user = null;
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("admin", Admin.class);
				  
		          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.json";
	   
				  Singleton.userNormal.clear();
				  JsonReader lector = new JsonReader(new FileReader(PATH));
				  JsonParser parseador = new JsonParser();
				  JsonElement raiz = parseador.parse(lector);
						  
				  Gson json = new Gson();
				  JsonArray lista = raiz.getAsJsonArray();
				  for (JsonElement elemento : lista) {
					  admin = json.fromJson(elemento, Admin.class);
					  Singleton.userAdmin.add((Admin)user);
	        	}
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("error_json_open"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userAdmin;
	    }
}
