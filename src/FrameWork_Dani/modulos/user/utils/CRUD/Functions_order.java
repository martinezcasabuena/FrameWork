package FrameWork_Dani.modulos.user.utils.CRUD;

import java.util.Collections;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.clases.Singleton;
import FrameWork_Dani.modulos.user.clases.order.OrderAge;
import FrameWork_Dani.modulos.user.clases.order.OrderBirthdate;
import FrameWork_Dani.modulos.user.clases.order.OrderDateAlta;
import FrameWork_Dani.modulos.user.clases.order.OrderName;
import FrameWork_Dani.modulos.user.clases.order.OrderNcomments;
import FrameWork_Dani.modulos.user.clases.order.OrderNpurchases;
import FrameWork_Dani.modulos.user.clases.order.OrderPoints;
import FrameWork_Dani.modulos.user.clases.order.OrderRecruitment;
import FrameWork_Dani.modulos.user.clases.order.OrderSalary;
import FrameWork_Dani.modulos.user.clases.order.OrderSeniority;
import FrameWork_Dani.utils.Functions;

public class Functions_order {
	
	public static void OrderNormal(){
		
		String [] options = { "A) "+Language.getInstance().getProperty("dni"),
							  "B) "+Language.getInstance().getProperty("name"),
							  "C) "+Language.getInstance().getProperty("birth_date"),
							  "D) "+Language.getInstance().getProperty("age"),
							  "E) "+Language.getInstance().getProperty("n_comments"),
							  "F) "+Language.getInstance().getProperty("points")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("no_user"),Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Language.getInstance().getProperty("order_message"),Language.getInstance().getProperty("order"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.userNormal);
					break;
				case 'B':
					Collections.sort(Singleton.userNormal, new OrderName());
					break;
				case 'C':
					Collections.sort(Singleton.userNormal, new OrderBirthdate());
					break;
				case 'D':
					Collections.sort(Singleton.userNormal, new OrderAge());
					break;
				case 'E':
					Collections.sort(Singleton.userNormal, new OrderNcomments());					
					break;
				case 'F':
					Collections.sort(Singleton.userNormal, new OrderPoints());					
					break;	
			}
		}
	}
	
	public static void OrderClient(){
		
		String [] options = { "A) "+Language.getInstance().getProperty("dni"),
							  "B) "+Language.getInstance().getProperty("name"),
							  "C) "+Language.getInstance().getProperty("birth_date"),
							  "D) "+Language.getInstance().getProperty("age"),
							  "E) "+Language.getInstance().getProperty("date_up"),
							  "F) "+Language.getInstance().getProperty("purchases")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("no_user"),Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Language.getInstance().getProperty("order_message"),Language.getInstance().getProperty("order"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.userCliente);
					break;
				case 'B':
					Collections.sort(Singleton.userCliente, new OrderName());
					break;
				case 'C':
					Collections.sort(Singleton.userCliente, new OrderBirthdate());
					break;
				case 'D':
					Collections.sort(Singleton.userCliente, new OrderAge());
					break;
				case 'E':
					Collections.sort(Singleton.userCliente, new OrderDateAlta());
					break;
				case 'F':
					Collections.sort(Singleton.userCliente, new OrderNpurchases());
					break;
			}
		}
	}
	
	
	public static void OrderAdmin(){
		
		String [] options = { "A) "+Language.getInstance().getProperty("dni"),
							  "B) "+Language.getInstance().getProperty("name"),
							  "C) "+Language.getInstance().getProperty("birth_date"),
							  "D) "+Language.getInstance().getProperty("age"),
							  "E) "+Language.getInstance().getProperty("contract_date"),
							  "F) "+Language.getInstance().getProperty("seniority"),
							  "G) "+Language.getInstance().getProperty("salary")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("no_user"),Language.getInstance().getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Language.getInstance().getProperty("order_message"),Language.getInstance().getProperty("order"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.userAdmin);
					break;
				case 'B':
					Collections.sort(Singleton.userAdmin, new OrderName());
					break;
				case 'C':
					Collections.sort(Singleton.userAdmin, new OrderBirthdate());
					break;
				case 'D':
					Collections.sort(Singleton.userAdmin, new OrderAge());
					break;
				case 'E':
					Collections.sort(Singleton.userAdmin, new OrderRecruitment());
					break;
				case 'F':
					Collections.sort(Singleton.userAdmin, new OrderSeniority());
					break;
				case 'G':
					Collections.sort(Singleton.userAdmin, new OrderSalary());
					break;
			}
		}
	}
}
