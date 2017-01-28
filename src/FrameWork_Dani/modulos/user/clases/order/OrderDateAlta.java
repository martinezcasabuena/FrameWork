package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.User;

public class OrderDateAlta implements Comparator <User>{

	public int compare (User u1, User u2) {
		return ((Cliente)u1).getFechaAlta().comparaFechasOrder(((Cliente)u2).getFechaAlta());
	}
}
