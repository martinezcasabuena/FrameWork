package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.Normal;
import FrameWork_Dani.modulos.user.clases.User;

public class OrderPoints implements Comparator <User>{

	public int compare (User u1, User u2) {
		if(((Normal)u1).getPoints()>((Normal)u2).getPoints())
			return 1;
		if(((Normal)u1).getPoints()<((Normal)u2).getPoints())
			return -1;
		return 0;
	}
}
