package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.Cliente;
import FrameWork_Dani.modulos.user.clases.User;

public class OrderNpurchases implements Comparator <User>{

	public int compare (User u1, User u2) {
		if(((Cliente)u1).getCompras()>(((Cliente)u2).getCompras()))
			return 1;
		if(((Cliente)u1).getCompras()<(((Cliente)u2).getCompras()))
			return -1;
		return 0;
	}
}
