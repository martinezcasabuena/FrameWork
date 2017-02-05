package FrameWork_Dani.modulos.user.clases;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.Main;
import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.clases.Settings;
import FrameWork_Dani.modulos.language.Language;
import FrameWork_Dani.modulos.user.utils.Functions_date_user;
import FrameWork_Dani.modulos.user.utils.Functions_extra_user;

@XStreamAlias("normal")
public class Normal extends User {
	//Atributos
	@XStreamAlias("intereses")
	private String intereses;
	@XStreamAlias("navegador")
	private String navegador;
	@XStreamAlias("comments")
	private int comments;
	@XStreamAlias("karma")
	private String karma;
	@XStreamAlias("points")
	private int points;

	
	public Normal(){
		super();
	}
	
	public String getIntereses(){
		return this.intereses;	
	}
	public void setIntereses(String intereses){
		this.intereses=intereses;
	}
	
	public String getNavegador(){
		return this.navegador;	
	}
	public void setNavegador(String navegador){
		this.navegador=navegador;
	}
	
	public int getComments(){	
		return this.comments;
	}
	
	public void setComments(int comments){
		this.comments=comments;
	}
	
	public int getPoints(){
		points=Functions_extra_user.CalcPoints(this.comments);
		return points;
	}
	
	public String getKarma(){
		karma=Functions_extra_user.CalcKarma(this.getPoints());
		return karma;
	}
	
	public Normal(String dni) {
		super(dni);
	}
	
	public String toString(){
		String cad="";
		cad=cad+(Settings.getInstance().lang.getProperty("name_is")+this.getNom()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("address_is")+this.getAdreca()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("sex_is")+this.getSexe()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("birthDate_is")+this.getFechaNac().toStringFecha()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("age_is")+this.getEdad()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("dni_is")+this.getDni()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("interests_is")+this.getIntereses()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("navegator_is")+this.getNavegador()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("ncomments_is")+this.getComments()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("karma_is") +this.getKarma()+"\n");
		cad=cad+(Settings.getInstance().lang.getProperty("points_is")+this.getPoints()+"\n");
		return cad;
	}
}
