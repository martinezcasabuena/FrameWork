package FrameWork_Dani.Functions;

import javax.swing.JOptionPane;

import FrameWork_Dani.clases.language.Language;

public class Functions {
	
	//********** Ask for int **********//
	
	public static int askInt(String message,String title){
		int num=0;
		boolean correct=true;
		String s="";
		do{
			try{
				s=JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("int_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					num=Integer.parseInt(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("int_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}			
		}while(correct==false);	
		return num;
	}
	
	//********** Ask for int no zero **********//
	
	public static int askInt_nozero(String message,String title){
		int num=0;
		boolean correct=true;
		do{
			num=askInt(Language.getInstance().getProperty("insert_number"),Language.getInstance().getProperty("int_nozero"));
			if(num!=0){
				correct=true;
			}else{
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("int_nozero_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
			}
		}while(correct==false);
		return num;
	}
	
	//********** Ask for Float **********//
	
	public static float askFloat(String message,String title){
		float num=0.0f;
		boolean correct=true;
		String s="";
		do{
			try{
				s=JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("float_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					num=Float.parseFloat(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("float_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}			
		}while(correct==false);	
		return num;	
	}

	//********** Ask for float no zero **********//
	
	public static float askFloat_nozero(String message,String title){
		float num=0.0f;
		boolean correct=true;
		do{
			num=askFloat(Language.getInstance().getProperty("insert_number"),Language.getInstance().getProperty("float_nozero"));
			if(num!=0){
				correct=true;
			}else{
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("float_nozero_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
			}
		}while(correct==false);
		return num;
		}
		
	//********** Ask for Char **********//
		
	public static char askChar(String message,String title){
		char letter=' ';
		boolean correct=true;
		String s="";
		do{
			try{
				s=JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("char_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					letter=s.charAt(0);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("char_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}			
		}while(correct==false);
		return letter;
	}
		
	//********** Ask for String **********//
		
	public static String askString(String message, String title){
		String cad="";
		boolean correct=false;
		do{
			try{
				cad = JOptionPane.showInputDialog(null,message,title,JOptionPane.QUESTION_MESSAGE);
				correct = true;
				if(cad.equals("")){
					JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("string_error"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("string_error"), Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return cad;
	}

	//********** Main Menu **********//
	
	public static int MenuP(String options[]){
		int opt=0;
		opt = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("main_menu"), 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt;
	}

	//******** Secondary Menu *******//

	public static int MenuS(){
		int opt1=0;
		String options[] = { Language.getInstance().getProperty("repeat"),Language.getInstance().getProperty("back"),Language.getInstance().getProperty("exit") };
		opt1 = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("secondary_menu"), 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt1;
	}
	
	//******** Continue Menu *******//
	
	public static int Continue(){
		int opt2=0;
		String[] options2={Language.getInstance().getProperty("Yes"),Language.getInstance().getProperty("No")};
		opt2 = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("continue_message"),Language.getInstance().getProperty("continue"), 0, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
		return opt2;
	}
	
	//******** Settings Menu *******//
	public static int SettingsMenu(String options[]){
		int opt3=0;
		opt3 = JOptionPane.showOptionDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("settings"), 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt3;
	}
	
	//******** Combo Menu *******//
	
	//Combo menu para todos los selectores de formatos como el formato de fecha, moneda, decimales, idioma,etc.
	public static String ComboMenuFormats(String options[],String message,String title,String selectedOption){
		String option="";
		boolean correct=false;		
		do{
			Object opt4 =JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, options,selectedOption);
			if(opt4==null){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}else{
				option=(String) opt4;
				correct=true;
			}
		}while(correct==false);	
		return option;
	}
	
	public static String ComboMenu(String options[],String message,String title){
		String option="";
		boolean correct=false;		
		do{
			Object opt4 =JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, options,0);
			if(opt4==null){
				JOptionPane.showMessageDialog(null,Language.getInstance().getProperty("choose_opt"),Language.getInstance().getProperty("error"),JOptionPane.ERROR_MESSAGE);
				correct=false;
			}else{
				option=(String) opt4;
				correct=true;
			}
		}while(correct==false);	
		return option;
	}
	
}
