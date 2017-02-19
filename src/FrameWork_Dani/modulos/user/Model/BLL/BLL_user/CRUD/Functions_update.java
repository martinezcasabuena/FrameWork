package FrameWork_Dani.modulos.user.Model.BLL.BLL_user.CRUD;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.Model.DAO.Functions_user;
import FrameWork_Dani.modulos.user.Model.Functions.Functions_find;
import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.Cliente;
import FrameWork_Dani.modulos.user.Model.clases.Normal;
import FrameWork_Dani.modulos.user.Model.clases.Singleton;


public class Functions_update {
	
	
	public static void updateNormal () {
		int location1 = -1;
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			Normal normal=Functions_find.IDnormal();
			location1 = Functions_find.find_normal(normal);
			if (location1 != -1) {
				normal = Singleton.userNormal.get(location1);
				Functions_user.UpdateUser_Generic(normal);
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
			Cliente client=Functions_find.IDclient();			
			location1 = Functions_find.find_client(client);
			if (location1 != -1) {
				client = Singleton.userCliente.get(location1);
				Functions_user.UpdateUser_Generic(client);
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
			Admin admin=Functions_find.IDadmin();
			location1 = Functions_find.find_admin(admin);
			if (location1 != -1) {
				admin = Singleton.userAdmin.get(location1);
				Functions_user.UpdateUser_Generic(admin);
				Singleton.userAdmin.set(location1, admin);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
