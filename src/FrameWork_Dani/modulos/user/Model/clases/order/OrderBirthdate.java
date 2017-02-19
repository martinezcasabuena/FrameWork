package FrameWork_Dani.modulos.user.Model.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.Model.clases.User;

public class OrderBirthdate implements Comparator <User>{

	public int compare (User u1, User u2) {
		return u1.getFechaNac().comparaFechasOrder(u2.getFechaNac());
	}
}