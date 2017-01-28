package FrameWork_Dani.modulos.user.utils;

import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;

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
}