package FrameWork_Dani.modulos.user.Model.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.Model.clases.Cliente;
import FrameWork_Dani.modulos.user.Model.clases.User;


public class OrderDateAlta implements Comparator <User>{

	public int compare (User u1, User u2) {
		return ((Cliente)u1).getFechaAlta().comparaFechasOrder(((Cliente)u2).getFechaAlta());
	}
}
