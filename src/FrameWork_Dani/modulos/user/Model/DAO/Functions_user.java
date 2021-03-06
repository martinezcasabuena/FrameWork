package FrameWork_Dani.modulos.user.Model.DAO;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.Model.Functions.Functions_data_user;
import FrameWork_Dani.modulos.user.Model.Functions.Functions_date_user;
import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.Cliente;
import FrameWork_Dani.modulos.user.Model.clases.Normal;
import FrameWork_Dani.modulos.user.Model.clases.Singleton;
import FrameWork_Dani.modulos.user.Model.clases.User;

public class Functions_user {

	private static String dni=""; //Guardamos el dni al pedirlo al usuario para no pedirlo 2 veces.

	// ********** CRUD MENU **********//
	
	public static int CrudMenu() {
		int opt = 0;
		String options[] = { Language.getInstance().getProperty("create") ,Language.getInstance().getProperty("read"),Language.getInstance().getProperty("update"),
				Language.getInstance().getProperty("delete"), Language.getInstance().getProperty("order"),Language.getInstance().getProperty("save"),
				Language.getInstance().getProperty("open"),Language.getInstance().getProperty("exit") };
		opt = JOptionPane.showOptionDialog(null, Language.getInstance().getProperty("choose_opt"), Language.getInstance().getProperty("crud_menu"), 0, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
		return opt;
	}
	
	//CRUD Generico
	
	public static User CreateUser_Generic(int i){
		String fechaForm=Settings.getInstance().getFechaForm();
		User user=null;
		if(i==0){
			user=new Normal();
			user.setNom(Functions_data_user.askName());
			user.setAdreca(Functions_data_user.askAddress());
			user.setSexe(Functions_data_user.askSex());
			user.setFechaNac(Functions_date_user.DateNac());
			user.setDni(dni); //Utilizamos el DNI que hemos usado para comprobar si existe el usuario
			((Normal)user).setIntereses(Functions_data_user.askInterests());
			((Normal)user).setNavegador(Functions_data_user.askNavigator());
			((Normal)user).setComments(Functions_data_user.askNumComments());
		}else
		if(i==1){
			user= new Cliente();
			user.setNom(Functions_data_user.askName());
			user.setAdreca(Functions_data_user.askAddress());
			user.setSexe(Functions_data_user.askSex());
			user.setFechaNac(Functions_date_user.DateNac());
			user.setDni(dni); //Utilizamos el DNI que hemos usado para comprobar si existe el usuario
			((Cliente)user).setFechaAlta(Functions_date_user.DateAlta());
			((Cliente)user).setNcuenta(Functions_data_user.askNumCuenta());
			((Cliente)user).setCompras(Functions_data_user.askNumCompras());
		}else
		if(i==2){
			user=new Admin();
			user.setNom(Functions_data_user.askName());
			user.setAdreca(Functions_data_user.askAddress());
			user.setSexe(Functions_data_user.askSex());
			user.setFechaNac(Functions_date_user.DateNac());
			user.setDni(dni); //Utilizamos el DNI que hemos usado para comprobar si existe el usuario
			((Admin)user).setFechaCont(Functions_date_user.DateContract(user.getFechaNac(),fechaForm));
			((Admin)user).setTrabajo(Functions_data_user.askJob());
		}
		return user;
	}
	

	public static User CreateUser_dni (int i ){
		User user=null;
		if(i==0){
			Singleton.dni=Functions_data_user.askDni();
			dni=Singleton.dni.toString(); //Gurdamos el DNI que hemos introducido para comprobar el usuario.
			user=new Normal(Singleton.dni);
		}else
		if(i==1){
			Singleton.dni=Functions_data_user.askDni();
			dni=Singleton.dni.toString(); //Gurdamos el DNI que hemos introducido para comprobar el usuario.
			user=new Cliente(Singleton.dni);
		}else
		if(i==2){
			Singleton.dni=Functions_data_user.askDni();
			dni=Singleton.dni.toString(); //Gurdamos el DNI que hemos introducido para comprobar el usuario.
			user=new Admin(Singleton.dni);
		}
		return user;
	}
	
	public static String ReadUser_Generic(User user){
		String cad="";
		if(user instanceof Normal){
			cad=((Normal)user).toString();
		}else
		if(user instanceof Cliente){
			cad=((Cliente)user).toString();
		}else
		if(user instanceof Admin){
			cad=((Admin)user).toString();
		}
		return cad;
	}
	
	public static User UpdateUser_Generic(User user){
		String fechaForm=Settings.getInstance().getFechaForm();
		int opt = 0;
		if(user instanceof Normal){
			String optionsNormal[] = { Language.getInstance().getProperty("name"), Language.getInstance().getProperty("address"),Language.getInstance().getProperty("birth_date"),
					Language.getInstance().getProperty("sex"),Language.getInstance().getProperty("interests"),Language.getInstance().getProperty("navigator"),
					Language.getInstance().getProperty("n_comments"),Language.getInstance().getProperty("all") };
			opt = JOptionPane.showOptionDialog(null, Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("update_normal"), 0, JOptionPane.QUESTION_MESSAGE, null,
					optionsNormal, optionsNormal[0]);
			
			switch (opt) {
			case 0:
				user.setNom(Functions_data_user.askName());
				break;

			case 1:
				user.setAdreca(Functions_data_user.askAddress());
				break;

			case 2:
				user.setFechaNac(Functions_date_user.DateNac());
				break;

			case 3:
				user.setSexe(Functions_data_user.askSex());
				break;
				
			case 4:
				((Normal)user).setIntereses(Functions_data_user.askInterests());
				break;
				
			case 5:
				((Normal)user).setNavegador(Functions_data_user.askNavigator());
				break;

			case 6:
				((Normal)user).setComments(Functions_data_user.askNumComments());
				break;
				
			case 7:
				user.setNom(Functions_data_user.askName());
				user.setAdreca(Functions_data_user.askAddress());
				user.setFechaNac(Functions_date_user.DateNac());
				user.setSexe(Functions_data_user.askSex());
				user.setDni(Functions_data_user.askDni());
				((Normal)user).setIntereses(Functions_data_user.askInterests());
				((Normal)user).setNavegador(Functions_data_user.askNavigator());
				((Normal)user).setComments(Functions_data_user.askNumComments());
				break;	
				}
			}
			if(user instanceof Cliente){
				String optionsCliente[] = {Language.getInstance().getProperty("name"), Language.getInstance().getProperty("address"),Language.getInstance().getProperty("birth_date"),
						Language.getInstance().getProperty("sex"),Language.getInstance().getProperty("n_account"),Language.getInstance().getProperty("dni"),
						Language.getInstance().getProperty("n_purchases"),Language.getInstance().getProperty("all") };
				opt = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("update_client"), 0, JOptionPane.QUESTION_MESSAGE, null,
						optionsCliente, optionsCliente[0]);

				switch (opt) {
				case 0:
					user.setNom(Functions_data_user.askName());
					break;

				case 1:
					user.setAdreca(Functions_data_user.askAddress());
					break;

				case 2:
					user.setFechaNac(Functions_date_user.UpdateDateNacClient(user,fechaForm));
					break;
					
				case 3:
					user.setSexe(Functions_data_user.askSex());
					break;
					
				case 4:
					((Cliente)user).setNcuenta(Functions_data_user.askNumCuenta());
					break;
					
				case 5:
					((Cliente)user).setDni(Functions_data_user.askDni());
					break;
					
				case 6:
					((Cliente)user).setCompras(Functions_data_user.askNumCompras());
					break;
					
				case 7:
					user.setNom(Functions_data_user.askName());
					user.setAdreca(Functions_data_user.askAddress());
					user.setFechaNac(Functions_date_user.UpdateDateNacClient(user,fechaForm));
					user.setSexe(Functions_data_user.askSex());
					user.setDni(Functions_data_user.askDni());
					((Cliente)user).setNcuenta(Functions_data_user.askNumCuenta());
					((Cliente)user).setCompras(Functions_data_user.askNumCompras());
					break;
					}
				}
				if(user instanceof Admin){
					String optionsAdmin[] = { Language.getInstance().getProperty("name"), Language.getInstance().getProperty("address"),Language.getInstance().getProperty("birth_date"),
							Language.getInstance().getProperty("sex"),Language.getInstance().getProperty("job"),Language.getInstance().getProperty("contract_date"),
							Language.getInstance().getProperty("all") };
					opt = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("update_admin"), 0, JOptionPane.QUESTION_MESSAGE, null,
							optionsAdmin, optionsAdmin[0]);
					
					switch (opt) {
					case 0:
						user.setNom(Functions_data_user.askName());
						break;

					case 1:
						user.setAdreca(Functions_data_user.askAddress());
						break;

					case 2:
						user.setFechaNac(Functions_date_user.UpdateDateNacAdmin(user,fechaForm));
						break;

					case 3:
						user.setSexe(Functions_data_user.askSex());
						break;
						
					case 4:
						((Admin)user).setTrabajo(Functions_data_user.askJob());
						break;
						
					case 5:
						((Admin)user).setFechaCont(Functions_date_user.DateContract(user.getFechaNac(),fechaForm));
						break;
						
					case 6:
						user.setNom(Functions_data_user.askName());
						user.setAdreca(Functions_data_user.askAddress());
						user.setFechaNac(Functions_date_user.UpdateDateNacAdmin(user,fechaForm));
						user.setSexe(Functions_data_user.askSex());
						user.setDni(Functions_data_user.askDni());
						((Admin)user).setTrabajo(Functions_data_user.askJob());
						((Admin)user).setFechaCont(Functions_date_user.DateContract(user.getFechaNac(),fechaForm));
						break;
				}
			}

		return user;
		}

}
