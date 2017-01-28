package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.User;

public class OrderBirthdate implements Comparator <User>{

	public int compare (User u1, User u2) {
		return u1.getFechaNac().comparaFechasOrder(u2.getFechaNac());
	}
}