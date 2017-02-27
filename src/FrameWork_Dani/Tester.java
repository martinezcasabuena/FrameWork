package FrameWork_Dani;

import javax.swing.JOptionPane;

import FrameWork_Dani.Functions.Functions;
import FrameWork_Dani.clases.language.Language;

public class Tester {
	
	
	public static String menuBox(String[] opcions,String message,String title){
		String op;
		boolean correcto=false;
		do{
			op=(String)JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE,null,opcions,opcions[0]);
			
			if(op==null){
				JOptionPane.showMessageDialog(null, "Selecciona una opcion");
				correcto=false;
			}else{
				correcto=true;
			}
			
		}while (correcto==false);
		return op;
		
	}

	public static void main(String[] args) {
		
    	String currencyOpt[] = {"€","$","£"};
		String result=menuBox(currencyOpt,"sds","jj2");
		JOptionPane.showMessageDialog(null, result);
    	//ComboMenu2(currencyOpt,"sds","jj2");
		



	}
}