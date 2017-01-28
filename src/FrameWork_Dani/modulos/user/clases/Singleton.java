package FrameWork_Dani.modulos.user.clases;

import java.util.ArrayList;
import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.Admin;

public class Singleton {
	
	public static ArrayList<Normal> userNormal;
	public static ArrayList <Cliente> userCliente;
	public static ArrayList <Admin> userAdmin;
	public static ArrayList normal= userNormal;


	public static String dni;
	
}
