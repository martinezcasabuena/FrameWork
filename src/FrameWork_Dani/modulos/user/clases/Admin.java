package FrameWork_Dani.modulos.user.clases;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.utils.Functions_date_user;
import FrameWork_Dani.modulos.user.utils.Functions_extra_user;
import FrameWork_Dani.utils.Format;

@XStreamAlias("admin")
public class Admin extends User{
	//Atributos
	@XStreamAlias("trabajo")
	private String trabajo;
	@XStreamAlias("fcont")
	private Fecha fcont;
	@XStreamAlias("antig")
	private int antig=0;
	@XStreamAlias("sueldo")
	private String sueldo;
	@XStreamAlias("currency")
	private String currency;
	@XStreamAlias("decimal")
	private int decimal;
	public Admin(){
		super();
	}
	
	public String getTrabajo(){
		return this.trabajo;	
	}
	public void setTrabajo(String trabajo){
		this.trabajo=trabajo;
	}
	
	public void setFechaCont(Fecha fcont){
		this.fcont=fcont;
	}
	
	public Fecha getFechaCont(){
		return this.fcont;
	}
	
	public int getAntiguedad(){
		antig=Functions_date_user.CalcAntiguedad(this.fcont);
		return this.antig;
	}
	
	public String getSueldo(){
		sueldo=Functions_extra_user.CalcSueldo(this.antig,Settings.getCurrency(),Settings.getDecimal());
		return this.sueldo;
	}
	
	public Admin(String dni) {
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
		cad=cad+(Settings.lang.getProperty("recruitmentDate_is")+this.getFechaCont().toStringFecha()+"\n");
		cad=cad+(Settings.lang.getProperty("seniority_is")+this.getAntiguedad()+"\n");
		cad=cad+(Settings.lang.getProperty("occupation_is")+this.getTrabajo()+"\n");
		cad=cad+(Settings.lang.getProperty("salary_is")+this.getSueldo()+Settings.getCurrency()+"\n");
		return cad;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
