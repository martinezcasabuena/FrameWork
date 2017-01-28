package FrameWork_Dani.modulos.user.utils.CRUD;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.utils.Functions_find;
import FrameWork_Dani.modulos.user.utils.Functions_user;

public class Functions_create {
	
	public static void createNormal(){
		int location = -1;
		Normal normal= (Normal) Functions_user.CreateUser_dni(0);
		location = Functions_find.find_normal((Normal) normal);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("si_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		} else {
			normal=(Normal) Functions_user.CreateUser_Generic(0,Settings.fechaForm);
			Singleton.userNormal.add((Normal) normal);
		}
	}

	public static void createClient(){
		int location = -1;
		Cliente cliente= (Cliente) Functions_user.CreateUser_dni(1);
		location = Functions_find.find_client((Cliente) cliente);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("si_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		} else {
			cliente=(Cliente) Functions_user.CreateUser_Generic(1,Settings.fechaForm);
			Singleton.userCliente.add((Cliente) cliente);
		}
	}
	
	public static void createAdmin(){
		int location = -1;
		Admin admin= (Admin) Functions_user.CreateUser_dni(2);
		location = Functions_find.find_admin((Admin) admin);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null,Settings.lang.getProperty("si_user"), Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		} else {
			admin=(Admin) Functions_user.CreateUser_Generic(2,Settings.fechaForm);
			Singleton.userAdmin.add((Admin) admin);
		}
	}
	
	
}
