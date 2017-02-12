package FrameWork_Dani.modulos.user.utils;

import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.utils.Functions;

public class Functions_find {
	
	public static int find_admin(Admin admin) { 
		for (int i = 0; i<=(Singleton.userAdmin.size()-1); i++){
			if((Singleton.userAdmin.get(i)).equals(admin) )
				return i;
		}
		return -1;
	}
	
	public static int find_client(Cliente cliente) { 
		for (int i = 0; i<=(Singleton.userCliente.size()-1); i++){
			if((Singleton.userCliente.get(i)).equals(cliente) )
				return i;
		}
		return -1;
	}
	
	public static int find_normal(Normal normal) { 
		for (int i = 0; i<=(Singleton.userNormal.size()-1); i++){
			if((Singleton.userNormal.get(i)).equals(normal))
				return i;
		}
		return -1;
	}
	
	public static String[] generate_vector_admin () {
		Admin admin = null;
		String s = "";
		int arraylist =Singleton.userAdmin.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			admin = (Admin) Singleton.userAdmin.get(i);
			s=admin.getDni()+" ----- "+admin.getNom();
			user[i] = s;
		}
		
		return user;
	}
	
	public static String[] generate_vector_client () {
		Cliente cliente = null;
		String s = "";
		int arraylist =Singleton.userCliente.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			cliente = (Cliente) Singleton.userCliente.get(i);
			s=cliente.getDni()+" ----- "+cliente.getNom();
			user[i] = s;
		}
		
		return user;
	}
	
	public static String[] generate_vector_normal () {
		Normal normal = null;
		String s = "";
		int arraylist =Singleton.userNormal.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			normal = (Normal) Singleton.userNormal.get(i);
			s=normal.getDni()+" ----- "+normal.getNom();
			user[i] = s;
		}
		
		return user;
	}
	
	public static Admin IDadmin () {
		Admin a1 = null;
		String ID = "";
		String [] admin = generate_vector_admin ();
		String search = Functions.ComboMenu(admin,Language.getInstance().getProperty("select_user"), Language.getInstance().getProperty("read_user"));
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			a1 = new Admin (ID);
		}
		return a1;		
	}
	
	public static Cliente IDclient () {
		Cliente c1 = null;
		String ID = "";
		String [] client = generate_vector_client ();
		String search = Functions.ComboMenu(client,Language.getInstance().getProperty("select_user"), Language.getInstance().getProperty("read_user"));
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			c1 = new Cliente (ID);
		}
		return c1;		
	}
	
	public static Normal IDnormal () {
		Normal u1 = null;
		String ID = "";
		String [] normal = generate_vector_normal ();
		String search = Functions.ComboMenu(normal,Language.getInstance().getProperty("select_user"), Language.getInstance().getProperty("read_user"));
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			u1 = new Normal (ID);
		}
		return u1;		
	}
}