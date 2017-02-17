package FrameWork_Dani;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.utils.Format;
import FrameWork_Dani.utils.Functions;
import FrameWork_Dani.utils.Open_Save_Settings.Save_Settings;
import FrameWork_Dani.clases.language.Language;
import FrameWork_Dani.modulos.user.utils.Functions_user;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_create;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_delete;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_order;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_read;
import FrameWork_Dani.modulos.user.utils.CRUD.Functions_update;
import FrameWork_Dani.modulos.user.utils.Functions_open_save.Function_open;
import FrameWork_Dani.modulos.user.utils.Functions_open_save.Function_save;

public class Main {

	public static Settings settings=null;
	
	public static void main(String[] args) {
		int opt = 0, opt1 = 0,opt2 = 0;
		
		Settings.getInstance();
		
		do {
			String options[] = { Language.getInstance().getProperty("normal"), Language.getInstance().getProperty("client"),Language.getInstance().getProperty("admin"),
					 Language.getInstance().getProperty("settings"),Language.getInstance().getProperty("exit") };
			String setting[] = {Language.getInstance().getProperty("date_format"),Language.getInstance().getProperty("currency"),Language.getInstance().getProperty("decimal"),
					Language.getInstance().getProperty("language"),Language.getInstance().getProperty("dummies"),Language.getInstance().getProperty("save_format"),
					Language.getInstance().getProperty("theme"),Language.getInstance().getProperty("back")};
					
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
								Function_save.SaveGenericOnDemand(opt);
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
								Function_save.SaveGenericAuto(opt);
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
								Function_save.SaveGenericAuto(opt);
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
								Fecha.fechaForm(); //Guardamos el formato fecha en una variable
								break;
							case 1:
								Format.CurrencyFormat(); //Guardamos la moneda en una variable dentro de la clase Format
								break;
							case 2:
								Format.DecimalFormat();	 //Guardamos el numero de decimales en una variable dentro de la clase Format
								break;
							case 3:
								String languageOpt=Language.LanguageOptions(); //Guardamos el idioma en una variable dentro de la clase Language
								Language.getInstance().setLanguage(languageOpt);
								break;
							case 4:
								JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("SwitchDummiesEnter"));
								Main_dummies.main(args);
								break;
							case 5:
								Format.SaveFormat();
								break;
							case 6:
								Format.theme();
								break;
							case 7:
								Save_Settings.SaveJsonSettings();
								break;
							}
						}
						
					} while (opt2 != 7);
					break;
					
				case 4:
					//Function_save.AutoSave();
					System.exit(0);
				}

			}

		} while (opt != 4);

	}
}