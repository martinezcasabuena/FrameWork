package FrameWork_Dani.modulos.user.Model.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.Model.clases.Normal;
import FrameWork_Dani.modulos.user.Model.clases.User;


public class OrderNcomments implements Comparator <User>{

	public int compare (User u1, User u2) {
		if(((Normal)u1).getComments()>((Normal)u2).getComments())
			return 1;
		if(((Normal)u1).getComments()<((Normal)u2).getComments())
			return -1;
		return 0;
	}
}
