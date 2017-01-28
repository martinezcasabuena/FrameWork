package FrameWork_Dani;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.utils.Format;
import FrameWork_Dani.utils.Functions;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.clases.User;
import FrameWork_Dani.modulos.user.utils.Functions_data_user;
import FrameWork_Dani.modulos.user.utils.Functions_find;
import FrameWork_Dani.modulos.user.utils.Functions_user;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_create;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_delete;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_order;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_read;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_update;
import FrameWork_Dani.modulos.user.utils.Functions_open_save.Function_open;
import FrameWork_Dani.modulos.user.utils.Functions_open_save.Function_save;
import FrameWork_Dani.modulos.user.utils.Functions_open_save.Functions_save_users;

public class Main {

	public static Settings settings=null;
	
	public static void main(String[] args) {
		int opt = 0, opt1 = 0,opt2 = 0;
		User user = null;
		User cliente = null;
		User admin = null;
		User normal = null;
		String fechaForm="dd/mm/yyyy";
		settings= new Settings();
		
		Singleton.userNormal=new ArrayList <Normal> ();
		Singleton.userCliente = new ArrayList <Cliente> ();
		Singleton.userAdmin = new ArrayList <Admin> ();
		
		do {
			String options[] = { Settings.lang.getProperty("normal"), Settings.lang.getProperty("client"),Settings.lang.getProperty("admin"),
					 Settings.lang.getProperty("options"),Settings.lang.getProperty("exit") };
			String setting[] = {Settings.lang.getProperty("date_format"),Settings.lang.getProperty("currency"),Settings.lang.getProperty("decimal"),
					Settings.lang.getProperty("language"),Settings.lang.getProperty("dummies"),Settings.lang.getProperty("save_format"),
					Settings.lang.getProperty("back")};
					
			opt = Functions.MenuP(options);
			if (opt == -1) {
				System.exit(0);
			} else {
				switch (opt) {
				case 0:
					Function_open.OpenGenericAuto(opt);
					do {
						opt1 = Functions_user.CrudMenu();
						if (opt1 == -1) {
							System.exit(0);
						} else {
							switch (opt1) {
							case 0:
								Functions_create.createNormal();
								break;
							case 1:
								Functions_read.readNormal();
								break;
							case 2:
								Functions_update.updateNormal();
								break;
							case 3:
								Functions_delete.deleteNormal();
								break;
							case 4:
								Functions_order.OrderNormal();
								break;
							case 5:
								Functions_save_users.AutoSaveJsonNormal();
								//Function_save.SaveGenericOnDemand(opt);
								break;
							case 6:
								Function_open.OpenGenericOnDemand(opt);
								break;
							case 7:
								Function_save.SaveGenericAuto(opt);
								break;
							}
						}

					} while (opt1 != 7);
					break;

				case 1:
					Function_open.OpenGenericAuto(opt);
					do {
						opt1 = Functions_user.CrudMenu();
						if (opt1 == -1) {
							System.exit(0);
						} else {
							switch (opt1) {
							case 0:
								Functions_create.createClient();
								break;
							case 1:
								Functions_read.readClient();
								break;
							case 2:
								Functions_update.updateClient();
								break;
							case 3:
								Functions_delete.deleteClient();
								break;
							case 4:
								Functions_order.OrderClient();
								break;
							case 5:
								Function_save.SaveGenericOnDemand(opt);
								break;
							case 6:
								Function_open.OpenGenericOnDemand(opt);
								break;
							case 7:
								Function_save.SaveGenericOnDemand(opt);
								break;
							}
						}

					} while (opt1 != 7);
					break;

				case 2:
					Function_open.OpenGenericAuto(opt);
					do {
						opt1 = Functions_user.CrudMenu();
						if (opt1 == -1) {
							System.exit(0);
						} else {
							switch (opt1) {
							case 0:
								Functions_create.createAdmin();
								break;
							case 1:
								Functions_read.readAdmin();
								break;
							case 2:
								Functions_update.updateAdmin();
								break;
							case 3:
								Functions_delete.deleteAdmin();
								break;
							case 4:
								Functions_order.OrderAdmin();
								break;
							case 5:
								Function_save.SaveGenericOnDemand(opt);
								break;
							case 6:
								Function_open.OpenGenericOnDemand(opt);
								break;
							case 7:
								Function_save.SaveGenericOnDemand(opt);
								break;
							}
						}

					} while (opt1 != 7);
					break;
					
				case 3:
					do {
						opt2 = Functions.SettingsMenu(setting);
						
						if (opt2 == -1) {
							System.exit(0);
						} else {
							switch (opt2) {
							case 0:
								fechaForm=Fecha.fechaForm(); //Guardamos el formato fecha en una variable
								break;
							case 1:
								Format.CurrencyFormat(); //Guardamos la moneda en una variable dentro de la clase Format
								break;
							case 2:
								Format.DecimalFormat();	 //Guardamos el numero de decimales en una variable dentro de la clase Format
								break;
							case 3:
								String languageOpt=Language.LanguageOptions(); //Guardamos el idioma en una variable dentro de la clase Language
								Settings.lang.setLanguage(languageOpt);
								break;
							case 4:
								JOptionPane.showMessageDialog(null,Settings.lang.getProperty("SwitchDummiesEnter"));
								Main_dummies.main(args);
								break;
							case 5:
								Format.SaveFormat();
								break;
							}
						}
						
					} while (opt2 != 6);
					break;
					
				case 4:
					Function_save.AutoSave();
					System.exit(0);
				}

			}

		} while (opt != 4);

	}
}