package FrameWork_Dani;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.clases.User;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.utils.Functions_user;
import FrameWork_Dani.modulos.user.utils.Functions_user_dummies;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_create;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_delete;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_order;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_read;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_update;
import FrameWork_Dani.utils.Format;
import FrameWork_Dani.utils.Functions;

public class Main_dummies {
	
	public static Settings settings=null;

	public static void main(String[] args) {
		int opt = 0, opt1 = 0,opt2 = 0;
		User user = null;
		User cliente = null;
		User admin = null;
		User normal = null;
		String fechaForm="dd/mm/yyyy";
		String languageOpt="English";
		settings= new Settings();
		
		Singleton.userNormal=new ArrayList <Normal> ();
		Singleton.userCliente = new ArrayList <Cliente> ();
		Singleton.userAdmin = new ArrayList <Admin> ();
		
		do {
			String options[] = { Settings.getInstance().lang.getProperty("normal"), Settings.getInstance().lang.getProperty("client"),Settings.getInstance().lang.getProperty("admin"),
					 Settings.getInstance().lang.getProperty("options"),Settings.getInstance().lang.getProperty("exit") };
			String setting[] = {Settings.getInstance().lang.getProperty("date_format"),Settings.getInstance().lang.getProperty("currency"),Settings.getInstance().lang.getProperty("decimal"),
					Settings.getInstance().lang.getProperty("language"),Settings.getInstance().lang.getProperty("noDummies"),Settings.getInstance().lang.getProperty("back")};
			
			opt = Functions.MenuP(options);
			if (opt == -1) {
				System.exit(0);
			} else {
				switch (opt) {
				case 0:
					do {
						opt1 = Functions_user_dummies.CrudMenu();
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
							}
						}
						
					} while (opt1 != 5);
					break;

				case 1:
					do {
						opt1 = Functions_user_dummies.CrudMenu();
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
							}
						}

					} while (opt1 != 5);
					break;

				case 2:
					do {
						opt1 = Functions_user_dummies.CrudMenu();
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
							}
						}

					} while (opt1 != 5);
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
								languageOpt=Language.LanguageOptions(); //Guardamos el idioma en una variable dentro de la clase Language
								Settings.getInstance().lang.setLanguage(languageOpt);
								break;
							case 4:
								JOptionPane.showMessageDialog(null,Settings.getInstance().lang.getProperty("SwitchDummiesLeave"));								Main.main(args);
								break;

							}
						}

					} while (opt2 != 5);
					break;
					
				case 4:
					System.exit(0);
				}
			}
		} while (opt != 4);
	}
}
