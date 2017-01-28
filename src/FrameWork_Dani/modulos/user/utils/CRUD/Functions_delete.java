package FrameWork_Dani.modulos.user.utils.CRUD;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.utils.Functions_find;
import FrameWork_Dani.modulos.user.utils.Functions_user;

public class Functions_delete {
	
	public static void deleteNormal () {
		int location = -1;
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Normal normal= (Normal) Functions_user.CreateUser_dni(0);
			location = Functions_find.find_normal(normal);
			if (location != -1) {
				Singleton.userNormal.remove(location);
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("del_user"), Settings.lang.getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void deleteClient () {
		int location = -1;
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Cliente cliente= (Cliente) Functions_user.CreateUser_dni(1);
			location = Functions_find.find_client(cliente);
			if (location != -1) {
				Singleton.userCliente.remove(location);
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("del_user"), Settings.lang.getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	public static void deleteAdmin () {
		int location = -1;
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Admin admin= (Admin) Functions_user.CreateUser_dni(2);
			location = Functions_find.find_admin(admin);
			if (location != -1) {
				Singleton.userAdmin.remove(location);
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("del_user"), Settings.lang.getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Settings.lang.getProperty("no_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
