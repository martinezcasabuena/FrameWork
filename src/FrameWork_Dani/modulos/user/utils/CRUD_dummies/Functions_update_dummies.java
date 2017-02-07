package FrameWork_Dani.modulos.user.utils.CRUD_dummies;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.utils.Functions_find;
import FrameWork_Dani.modulos.user.utils.Functions_user;

public class Functions_update_dummies {
	
	
	public static void updateNormal () {
		int location1 = -1;
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			Normal normal= (Normal) Functions_user.CreateUser_dni(0);
			location1 = Functions_find.find_normal(normal);
			if (location1 != -1) {
				normal = Singleton.userNormal.get(location1);
				Functions_user.UpdateUser_Generic(normal, Settings.getInstance().fechaForm);
				Singleton.userNormal.set(location1, normal);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void updateClient () {
		int location1 = -1;
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			Cliente client= (Cliente) Functions_user.CreateUser_dni(1);
			location1 = Functions_find.find_client(client);
			if (location1 != -1) {
				client = Singleton.userCliente.get(location1);
				Functions_user.UpdateUser_Generic(client, Settings.getInstance().fechaForm);
				Singleton.userCliente.set(location1, client);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	public static void updateAdmin () {
		int location1 = -1;
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			Admin admin= (Admin) Functions_user.CreateUser_dni(2);
			location1 = Functions_find.find_admin(admin);
			if (location1 != -1) {
				admin = Singleton.userAdmin.get(location1);
				Functions_user.UpdateUser_Generic(admin, Settings.getInstance().fechaForm);
				Singleton.userAdmin.set(location1, admin);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
