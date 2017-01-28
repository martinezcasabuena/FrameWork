package FrameWork_Dani.modulos.user.clases;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.utils.Functions_extra_user;

@XStreamAlias("cliente")
public class Cliente extends User {
	//Atributos
	@XStreamAlias("ncuenta")
	private String ncuenta;
	@XStreamAlias("falt")
	private Fecha falt;
	@XStreamAlias("compras")
	private int compras;
	@XStreamAlias("descuento")
	private int descuento;

	
	public Cliente(){
		super();
	}

	public String getNcuenta(){
		return this.ncuenta;	
	}
	
	public void setNcuenta(String ncuenta){
		this.ncuenta=ncuenta;
	}
	
	
	public void setFechaAlta(Fecha falt){
		this.falt=falt;
	}
	
	public Fecha getFechaAlta(){
		return this.falt;
	}
	
	public void setCompras(int compras){
		this.compras=compras;
	}
	
	public int getCompras(){
		return this.compras;
	}
	
	public int getDescuento(){
		descuento=Functions_extra_user.CalcDescuento(compras);
		return descuento;
	}
	
	public Cliente(String dni) {
		super(dni);
	}
	
	public String toString(){
		String cad="";
		cad=cad+(Settings.lang.getProperty("name_is")+this.getNom()+"\n");
		cad=cad+(Settings.lang.getProperty("address_is")+this.getAdreca()+"\n");
		cad=cad+(Settings.lang.getProperty("sex_is")+this.getSexe()+"\n");
		cad=cad+(Settings.lang.getProperty("birthDate_is")+this.getFechaNac().toStringFecha()+"\n");
		cad=cad+(Settings.lang.getProperty("age_is")+this.getEdad()+"\n");
		cad=cad+(Settings.lang.getProperty("dni_is")+this.getDni()+"\n");
		cad=cad+(Settings.lang.getProperty("systemDate_is")+this.getFechaAlta().toStringFecha()+"\n");
		cad=cad+(Settings.lang.getProperty("naccount_is")+this.getNcuenta()+"\n");
		cad=cad+(Settings.lang.getProperty("purchases_is")+this.getCompras()+"\n");
		cad=cad+(Settings.lang.getProperty("dto_is")+this.getDescuento()+"% \n");
		return cad;
		
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}