package FrameWork_Dani.modulos.user.Model.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.Model.clases.Admin;
import FrameWork_Dani.modulos.user.Model.clases.User;

public class OrderRecruitment implements Comparator <User>{

	public int compare (User u1, User u2) {
		return ((Admin)u1).getFechaCont().comparaFechasOrder(((Admin)u2).getFechaCont());
	}
}
