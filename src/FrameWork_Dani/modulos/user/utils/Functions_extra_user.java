package FrameWork_Dani.modulos.user.utils;

import FrameWork_Dani.utils.Format;

public class Functions_extra_user {
	
	public static int CalcPoints(int numComments){
		int points=0;
		
		if(numComments==0){
			points=0;
		}
		else if((numComments>0) &&(numComments<=15)){
			points=30;
		}
		else if((numComments>15) &&(numComments<=50)){
			points=70;
		}
		else if(numComments>50){
			points=100;
		}
		return points;
	}
	
	public static String CalcKarma(int points){
		String karma="";
		
		switch(points){
		case 0:
			karma="Se requiere un minimo de puntos para obtener karma";
			break;
		case 30:
			karma="Bajo";		
			break;
		case 70:
			karma="Medio";
			break;
		case 100:
			karma="Alto";
			break;
		}
		
		return karma;
	}
	
	public static String CalcSueldo(int antig,String currency){
		float sueldo=0;
		String cad="";
		
		//Obtenemos el sueldo a partir de la antiguedad
		if(antig<=2){
			sueldo=980;
		}
		else if((antig>2)&&antig<=5){
			sueldo=1250;
		}
		else if((antig>5)&&(antig<=8)){
			sueldo=1380;
		}
		else if(antig>8){
			sueldo=1500;
		}
		
		//Obtenemos el sueldo a partir de la moneda
		switch(currency){
		case "€":
			sueldo=sueldo;
			break;
		case "$":
    		sueldo=sueldo*1.0844f;
    		break;
    	case "£":
    		sueldo=sueldo*0.8380f;
    		break;
		}
		
		//Obtenemos el sueldo a partir de los decimales
		cad=Format.Decimal(sueldo);
		return cad;
	}
	
	public static int CalcDescuento(int compras){
		int descuento=0;
		
		if(compras<=4){
			descuento=2;
		}
		else if((compras>4)&&(compras<=10)){
			descuento=8;
		}
		else if((compras>10)&&(compras<=20)){
			descuento=15;
		}
		else if(compras>20){
			descuento=20;
		}
		
		return descuento;
	}
}
