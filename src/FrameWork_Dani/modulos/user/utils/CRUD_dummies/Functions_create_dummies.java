package FrameWork_Dani.modulos.user.utils.CRUD_dummies;

import FrameWork_Dani.modulos.user.utils.Functions_user_dummies;

public class Functions_create_dummies {
	
	public static void createNormal(){
		Functions_user_dummies.CreateUser_Generic(0);
	}

	public static void createClient(){
		Functions_user_dummies.CreateUser_Generic(1);
	}
	
	public static void createAdmin(){
		Functions_user_dummies.CreateUser_Generic(2);
	}
}
