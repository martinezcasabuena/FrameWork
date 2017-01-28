package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.User;

public class OrderAge implements Comparator <User>{

	public int compare (User u1, User u2) {
		if(u1.getEdad()>u2.getEdad())
			return 1;
		if(u1.getEdad()<u2.getEdad())
			return -1;
		return 0;
	}
}