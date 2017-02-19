package FrameWork_Dani.modulos.user.Model.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.User;

public class OrderSeniority implements Comparator <User>{

	public int compare (User u1, User u2) {
		if(((Admin)u1).getAntiguedad()>((Admin)u1).getAntiguedad())
			return 1;
		if(((Admin)u1).getAntiguedad()<((Admin)u1).getAntiguedad())
			return -1;
		return 0;
	}
}