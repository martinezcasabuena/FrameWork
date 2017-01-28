package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.Admin;
import FrameWork_Dani.modulos.user.clases.User;

public class OrderSalary implements Comparator <User>{
	
	public int compare (User u1, User u2) {
		if(((Admin)u1).getSueldo().compareTo(((Admin)u2).getSueldo())>0)
			return 1;
		if(((Admin)u1).getSueldo().compareTo(((Admin)u2).getSueldo())<0)
			return -1;
		return 0;
	}
}