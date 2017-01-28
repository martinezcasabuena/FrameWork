package FrameWork_Dani.utils;

import javax.swing.JOptionPane;

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
					JOptionPane.showMessageDialog(null,"You haven't introduce an int number","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					num=Integer.parseInt(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"You haven't introduce an int number","Error",JOptionPane.ERROR_MESSAGE);
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
			num=askInt("Insert the number","Int no 0");
			if(num!=0){
				correct=true;
			}else{
				JOptionPane.showMessageDialog(null,"You haven't introduce an int number distinct 0","Error",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null,"You haven't introduce a float number","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					num=Float.parseFloat(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"You haven't introduce a float number","Error",JOptionPane.ERROR_MESSAGE);
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
			num=askFloat("Insert the number","Float no 0");
			if(num!=0){
				correct=true;
			}else{
				JOptionPane.showMessageDialog(null,"You haven't introduce an int number distinct 0","Error",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null,"You haven't introduce a letter","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}else{
					letter=s.charAt(0);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"You haven't introduce a letter","Error",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "You haven't introduce a string","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You haven't introduce a string", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return cad;
	}

	//********** Main Menu **********//
	
	public static int MenuP(String options[]){
		int opt=0;
		opt = JOptionPane.showOptionDialog(null, "Choose an option", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt;
	}

	//******** Secondary Menu *******//

	public static int MenuS(){
		int opt1=0;
		String options[] = { "Repeat", "Back", "Exit" };
		opt1 = JOptionPane.showOptionDialog(null, "Choose an option", "Secondary Menu", 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt1;
	}
	
	//******** Continue Menu *******//
	
	public static int Continue(){
		int opt2=0;
		String[] options2={"Si","No"};
		opt2 = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Continue?", 0, JOptionPane.QUESTION_MESSAGE,null, options2, options2[0]);
		return opt2;
	}
	
	//******** Settings Menu *******//
	public static int SettingsMenu(String options[]){
		int opt3=0;
		opt3 = JOptionPane.showOptionDialog(null, "Choose an option?", "Settings", 0, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
		return opt3;
	}
	
	//******** Combo Menu *******//
	
	public static String ComboMenu(String options[],String message,String title){
		String option="";
		Object opt4 =JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, options, 0);
		option=(String) opt4;
		return option;
	}

	

	

}
