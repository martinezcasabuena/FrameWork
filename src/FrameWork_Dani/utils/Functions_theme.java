package FrameWork_Dani.utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.clases.language.Language;

public class Functions_theme {
public static void theme (){
	
		try {
			switch (Settings.getInstance().getTheme()){
			case "METAL":// Metal - Predeterminado JAVA
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				break;

			case "GTK":// GTK
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case "MOTIF":// Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case "NINBUS":// Nimbus - JAVA
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;	
				
			case "WINDOWS95":// WINDOWS 95
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				break;
				
			case "WINDOWS":// WINDOWS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
				
			case "MAC OS":// MAC OS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				break;
				
			case "MAC OS X":// MAC OS X
				UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
				break;
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error");
			//JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("errortheme"), Language_general.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		}
	}

}
