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

public class Functions_delete {
	
	public static void deleteNormal () {
		int location = -1;
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Normal normal=Functions_find.IDnormal();
			location = Functions_find.find_normal(normal);
			if (location != -1) {
				Singleton.userNormal.remove(location);
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("del_user"), Language.getInstance().getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void deleteClient () {
		int location = -1;
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Cliente cliente=Functions_find.IDclient();
			location = Functions_find.find_client(cliente);
			if (location != -1) {
				Singleton.userCliente.remove(location);
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("del_user"), Language.getInstance().getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	public static void deleteAdmin () {
		int location = -1;
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			location = -1;
			Admin admin=Functions_find.IDadmin();
			location = Functions_find.find_admin(admin);
			if (location != -1) {
				Singleton.userAdmin.remove(location);
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("del_user"), Language.getInstance().getProperty("del_user"), JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
