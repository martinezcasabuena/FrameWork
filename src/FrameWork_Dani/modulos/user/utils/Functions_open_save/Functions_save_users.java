package FrameWork_Dani.modulos.user.utils.Functions_open_save;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;

public class Functions_save_users {
	
	private static final String ENCODING = null;
	
	//--------------NORMAL USER SAVE TXT--------------//
	
	public static void OnDemandSaveTxtNormal(){
		 String PATH = null;
	     try {
	         File f;
	         JFileChooser fileChooser = new JFileChooser();
	         int seleccion = fileChooser.showSaveDialog(null);
	         if (seleccion == JFileChooser.APPROVE_OPTION) {
	             File JFC = fileChooser.getSelectedFile();
	             PATH = JFC.getAbsolutePath();
	             PATH=PATH+".txt";
	             f = new File(PATH);
	             FileOutputStream fo=new FileOutputStream(f);
	             ObjectOutputStream o=new ObjectOutputStream(fo);
	             o.writeObject(Singleton.userNormal);
	             o.close();
	             JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
	         }
	     } catch (Exception e) {
	     	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
	     }
	}
	
	public static void AutoSaveTxtNormal(){
		String PATH = null;
        try {
            File f;
            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.txt";
            f = new File(PATH);
            FileOutputStream fo=new FileOutputStream(f);
			ObjectOutputStream o=new ObjectOutputStream(fo);
			o.writeObject(Singleton.userNormal);
			o.close();
            //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	//--------------NORMAL USER SAVE XML--------------//

	@SuppressWarnings("deprecation")
	public static void OnDemandSaveXmlNormal(){
		 String PATH=null;
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Normal.class);
	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            xstream.toXML(Singleton.userNormal, osw);
	            StringBuffer xml = new StringBuffer();
	            xml.append(header);
	            xml.append(os.toString());
	            JFileChooser fileChooser = new JFileChooser();
	            int seleccion = fileChooser.showSaveDialog(null);
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	            	File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                PATH = PATH+".xml";
	                
	                FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(xml.toString());
	                fileXml.close();
	                osw.close();
	                os.close();
	                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
	            }
		    }catch (Exception e1){
		    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		    } 
	}
	
	@SuppressWarnings("deprecation")
	public static void AutoSaveXmlNormal(){
		 String PATH=null;
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Normal.class);
	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            xstream.toXML(Singleton.userNormal, osw);
	            StringBuffer xml = new StringBuffer();
	            xml.append(header);
	            xml.append(os.toString());
	            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.xml";
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                //JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
			
			}catch (Exception e1){
		    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		    }
	}
	
	//--------------NORMAL USER SAVE JSON--------------//
	
	  public static void OnDemandSaveJsonNormal() {
	        String PATH = null;
		      try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("normal", Normal.class);
		          JFileChooser fileChooser = new JFileChooser();
		          int seleccion = fileChooser.showSaveDialog(null);
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
		                File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                PATH=PATH+ ".json";
		                Gson gson = new Gson();
			            String json = gson.toJson(Singleton.userNormal.toString());
			            FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close(); 
		                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
		          }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	  
	  public static void AutoSaveJsonNormal() {
	        String PATH = null;
		      try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("normal", Normal.class);
		          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/normal/archivos/normal.json";
	              Gson gson = new Gson();
		          String json = gson.toJson(Singleton.userNormal.toString());
		          FileWriter fileXml = new FileWriter(PATH);
	              fileXml.write(json.toString());
	              fileXml.close(); 
	              //JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	  
	//--------------CLIENTE USER SAVE TXT--------------//

		public static void OnDemandSaveTxtClient(){
			 String PATH = null;
		     try {
		         File f;
		         JFileChooser fileChooser = new JFileChooser();
		         int seleccion = fileChooser.showSaveDialog(null);
		         if (seleccion == JFileChooser.APPROVE_OPTION) {
		             File JFC = fileChooser.getSelectedFile();
		             PATH = JFC.getAbsolutePath();
		             PATH=PATH+".txt";
		             f = new File(PATH);
		             FileOutputStream fo=new FileOutputStream(f);
		             ObjectOutputStream o=new ObjectOutputStream(fo);
		             o.writeObject(Singleton.userCliente);
		             o.close();
		             JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
		         }
		     } catch (Exception e) {
		     	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		     }
		}
		
		public static void AutoSaveTxtClient(){
			String PATH = null;
	        try {
	            File f;
	            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.txt";
	            f = new File(PATH);
	            FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton.userCliente);
				o.close();
	            //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
	            
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
	        }
		}
		
		//--------------CLIENTE USER SAVE XML--------------//

		@SuppressWarnings("deprecation")
		public static void OnDemandSaveXmlClient(){
			 String PATH=null;
				try {
					OutputStream os = new ByteArrayOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					XStream xstream = new XStream();
					Annotations.configureAliases(xstream, Cliente.class);
		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            xstream.toXML(Singleton.userCliente, osw);
		            StringBuffer xml = new StringBuffer();
		            xml.append(header);
		            xml.append(os.toString());
		            JFileChooser fileChooser = new JFileChooser();
		            int seleccion = fileChooser.showSaveDialog(null);
		            if (seleccion == JFileChooser.APPROVE_OPTION) {
		            	File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                PATH = PATH+".xml";
		                
		                FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(xml.toString());
		                fileXml.close();
		                osw.close();
		                os.close();
		                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
		            }
			    }catch (Exception e1){
			    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
			    } 
		}
		
		@SuppressWarnings("deprecation")
		public static void AutoSaveXmlClient(){
			 String PATH=null;
				try {
					OutputStream os = new ByteArrayOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					XStream xstream = new XStream();
					Annotations.configureAliases(xstream, Cliente.class);
		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            xstream.toXML(Singleton.userCliente, osw);
		            StringBuffer xml = new StringBuffer();
		            xml.append(header);
		            xml.append(os.toString());
		            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.xml";
	                FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(xml.toString());
	                fileXml.close();
	                osw.close();
	                os.close();
	                //JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
				
				}catch (Exception e1){
			    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
			    }
		}
		
		//--------------CLIENTE USER SAVE JSON--------------//
		
		  public static void OnDemandSaveJsonClient() {
		        String PATH = null;
			      try {
			          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			          xstreamjson.setMode(XStream.NO_REFERENCES);
			          xstreamjson.alias("cliente", Cliente.class);
			          JFileChooser fileChooser = new JFileChooser();
			          int seleccion = fileChooser.showSaveDialog(null);
			          if (seleccion == JFileChooser.APPROVE_OPTION) {
			                File JFC = fileChooser.getSelectedFile();
			                PATH = JFC.getAbsolutePath();
			                PATH=PATH+ ".json";
			                Gson gson = new Gson();
				            String json = gson.toJson(Singleton.userCliente.toString());
				            FileWriter fileXml = new FileWriter(PATH);
			                fileXml.write(json.toString());
			                fileXml.close(); 
			                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
			          }
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		  
		  public static void AutoSaveJsonClient() {
		        String PATH = null;
			      try {
			          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			          xstreamjson.setMode(XStream.NO_REFERENCES);
			          xstreamjson.alias("cliente", Cliente.class);
			          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/cliente/archivos/cliente.json";
		              Gson gson = new Gson();
			          String json = gson.toJson(Singleton.userNormal.toString());
			          FileWriter fileXml = new FileWriter(PATH);
		              fileXml.write(json.toString());
		              fileXml.close(); 
		              //JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		  
		//--------------ADMIN USER SAVE TXT--------------//

			public static void OnDemandSaveTxtAdmin(){
				 String PATH = null;
			     try {
			         File f;
			         JFileChooser fileChooser = new JFileChooser();
			         int seleccion = fileChooser.showSaveDialog(null);
			         if (seleccion == JFileChooser.APPROVE_OPTION) {
			             File JFC = fileChooser.getSelectedFile();
			             PATH = JFC.getAbsolutePath();
			             PATH=PATH+".txt";
			             f = new File(PATH);
			             FileOutputStream fo=new FileOutputStream(f);
			             ObjectOutputStream o=new ObjectOutputStream(fo);
			             o.writeObject(Singleton.userAdmin);
			             o.close();
			             JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
			         }
			     } catch (Exception e) {
			     	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
			     }
			}
			
			public static void AutoSaveTxtAdmin(){
				String PATH = null;
		        try {
		            File f;
		            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.txt";
		            f = new File(PATH);
		            FileOutputStream fo=new FileOutputStream(f);
					ObjectOutputStream o=new ObjectOutputStream(fo);
					o.writeObject(Singleton.userAdmin);
					o.close();
		            //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
		            
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
			
			//--------------ADMIN USER SAVE XML--------------//

			@SuppressWarnings("deprecation")
			public static void OnDemandSaveXmlAdmin(){
				 String PATH=null;
					try {
						OutputStream os = new ByteArrayOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						XStream xstream = new XStream();
						Annotations.configureAliases(xstream, Admin.class);
			            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			            xstream.toXML(Singleton.userAdmin, osw);
			            StringBuffer xml = new StringBuffer();
			            xml.append(header);
			            xml.append(os.toString());
			            JFileChooser fileChooser = new JFileChooser();
			            int seleccion = fileChooser.showSaveDialog(null);
			            if (seleccion == JFileChooser.APPROVE_OPTION) {
			            	File JFC = fileChooser.getSelectedFile();
			                PATH = JFC.getAbsolutePath();
			                PATH = PATH+".xml";
			                
			                FileWriter fileXml = new FileWriter(PATH);
			                fileXml.write(xml.toString());
			                fileXml.close();
			                osw.close();
			                os.close();
			                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
			            }
				    }catch (Exception e1){
				    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
				    } 
			}
			
			@SuppressWarnings("deprecation")
			public static void AutoSaveXmlAdmin(){
				 String PATH=null;
					try {
						OutputStream os = new ByteArrayOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						XStream xstream = new XStream();
						Annotations.configureAliases(xstream, Admin.class);
			            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			            xstream.toXML(Singleton.userAdmin, osw);
			            StringBuffer xml = new StringBuffer();
			            xml.append(header);
			            xml.append(os.toString());
			            PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.xml";
		                FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(xml.toString());
		                fileXml.close();
		                osw.close();
		                os.close();
		                //JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
					
					}catch (Exception e1){
				    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
				    }
			}
			
			//--------------ADMIN USER SAVE JSON--------------//
			
			  public static void OnDemandSaveJsonAdmin() {
			        String PATH = null;
				      try {
				          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				          xstreamjson.setMode(XStream.NO_REFERENCES);
				          xstreamjson.alias("admin", Admin.class);
				          JFileChooser fileChooser = new JFileChooser();
				          int seleccion = fileChooser.showSaveDialog(null);
				          if (seleccion == JFileChooser.APPROVE_OPTION) {
				                File JFC = fileChooser.getSelectedFile();
				                PATH = JFC.getAbsolutePath();
				                PATH=PATH+ ".json";
				                Gson gson = new Gson();
					            String json = gson.toJson(Singleton.userAdmin.toString());
					            FileWriter fileXml = new FileWriter(PATH);
				                fileXml.write(json.toString());
				                fileXml.close(); 
				                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
				          }
			        } catch (Exception e) {
			        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			  
			  public static void AutoSaveJsonAdmin() {
			        String PATH = null;
				      try {
				          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				          xstreamjson.setMode(XStream.NO_REFERENCES);
				          xstreamjson.alias("admin", Admin.class);
				          PATH=new java.io.File(".").getCanonicalPath()+ "/src/FrameWork_Dani/modulos/user/utils/admin/archivos/admin.json";
			              Gson gson = new Gson();
				          String json = gson.toJson(Singleton.userAdmin.toString());
				          FileWriter fileXml = new FileWriter(PATH);
			              fileXml.write(json.toString());
			              fileXml.close(); 
			              //JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
			        } catch (Exception e) {
			        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }

}
