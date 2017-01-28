package FrameWork_Dani.modulos.user.clases.order;

import java.util.Comparator;

import FrameWork_Dani.modulos.user.clases.User;

public class OrderName implements Comparator <User>{

		public int compare (User u1, User u2) {
			if(u1.getNom().compareTo(u2.getNom())>0)
				return 1;
			if(u1.getNom().compareTo(u2.getNom())<0)
				return -1;
			return 0;
		}
	}

