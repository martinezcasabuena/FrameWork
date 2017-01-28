package FrameWork_Dani.modulos.user.utils.CRUD;

import java.util.Collections;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.Settings;
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
		
		String [] options = { "A) "+Settings.lang.getProperty("dni"),
							  "B) "+Settings.lang.getProperty("name"),
							  "C) "+Settings.lang.getProperty("birth_date"),
							  "D) "+Settings.lang.getProperty("age"),
							  "E) "+Settings.lang.getProperty("n_comments"),
							  "F) "+Settings.lang.getProperty("points")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userNormal.isEmpty()){
			JOptionPane.showMessageDialog(null, Settings.lang.getProperty("no_user"),Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Settings.lang.getProperty("order_message"),Settings.lang.getProperty("order"));
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
		
		String [] options = { "A) "+Settings.lang.getProperty("dni"),
							  "B) "+Settings.lang.getProperty("name"),
							  "C) "+Settings.lang.getProperty("birth_date"),
							  "D) "+Settings.lang.getProperty("age"),
							  "E) "+Settings.lang.getProperty("date_up"),
							  "F) "+Settings.lang.getProperty("purchases")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userCliente.isEmpty()){
			JOptionPane.showMessageDialog(null, Settings.lang.getProperty("no_user"),Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Settings.lang.getProperty("order_message"),Settings.lang.getProperty("order"));
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
		
		String [] options = { "A) "+Settings.lang.getProperty("dni"),
							  "B) "+Settings.lang.getProperty("name"),
							  "C) "+Settings.lang.getProperty("birth_date"),
							  "D) "+Settings.lang.getProperty("age"),
							  "E) "+Settings.lang.getProperty("contract_date"),
							  "F) "+Settings.lang.getProperty("seniority"),
							  "G) "+Settings.lang.getProperty("salary")
							};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userAdmin.isEmpty()){
			JOptionPane.showMessageDialog(null, Settings.lang.getProperty("no_user"),Settings.lang.getProperty("error"), JOptionPane.ERROR_MESSAGE);
		}else{
			menu = Functions.ComboMenu(options, Settings.lang.getProperty("order_message"),Settings.lang.getProperty("order"));
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
