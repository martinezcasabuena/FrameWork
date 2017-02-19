package FrameWork_Dani.modulos.user.Model.BLL.BLL_user.CRUD;

import javax.swing.JOptionPane;

import FrameWork_Dani.Functions.Functions;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.Model.DAO.Functions_user;
import FrameWork_Dani.modulos.user.Model.Functions.Functions_find;
import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.Cliente;
import FrameWork_Dani.modulos.user.Model.clases.Normal;
import FrameWork_Dani.modulos.user.Model.clases.Singleton;


public class Functions_read {
	
	public static void readNormal (){
		int menu = 0, location = -1;
		String options[] = { Language.getInstance().getProperty("read_all"),Language.getInstance().getProperty("read_user")};
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Functions.MenuP(options);
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userNormal.size();i++){
						String cad = "";
						cad = cad + (Singleton.userNormal.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					Normal normal=Functions_find.IDnormal();
					location = Functions_find.find_normal(normal);
					if (location != -1) {
						normal = Singleton.userNormal.get(location);
						JOptionPane.showMessageDialog(null, normal.toString());
					}else {
						JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void readClient (){
		int menu = 0, location = -1;
		String options[] = { Language.getInstance().getProperty("read_all"),Language.getInstance().getProperty("read_user")};
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Functions.MenuP(options);
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userCliente.size();i++){
						String cad = "";
						cad = cad + (Singleton.userCliente.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					Cliente cliente=Functions_find.IDclient();
					location = Functions_find.find_client(cliente);
					if (location != -1) {
						cliente = Singleton.userCliente.get(location);
						JOptionPane.showMessageDialog(null, cliente.toString());
					}else {
						JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void readAdmin (){
		int menu = 0, location = -1;
		String options[] = { Language.getInstance().getProperty("read_all"),Language.getInstance().getProperty("read_user")};
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Functions.MenuP(options);
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userAdmin.size();i++){
						String cad = "";
						cad = cad + (Singleton.userAdmin.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					Admin admin=Functions_find.IDadmin();
					location = Functions_find.find_admin(admin);
					if (location != -1) {
						admin = Singleton.userAdmin.get(location);
						JOptionPane.showMessageDialog(null, admin.toString());
					}else {
						JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("no_user"), Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}

}
