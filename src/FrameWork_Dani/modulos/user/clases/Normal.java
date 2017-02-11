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
	@XStreamAlias("navigator")
	private String navigator;
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
		return this.navigator;	
	}
	public void setNavegador(String navigator){
		this.navigator=navigator;
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
		cad=cad+(Language.getInstance().getProperty("name_is")+this.getNom()+"\n");
		cad=cad+(Language.getInstance().getProperty("address_is")+this.getAdreca()+"\n");
		cad=cad+(Language.getInstance().getProperty("sex_is")+this.getSexe()+"\n");
		cad=cad+(Language.getInstance().getProperty("birthDate_is")+this.getFechaNac().toStringFecha()+"\n");
		cad=cad+(Language.getInstance().getProperty("age_is")+this.getEdad()+"\n");
		cad=cad+(Language.getInstance().getProperty("dni_is")+this.getDni()+"\n");
		cad=cad+(Language.getInstance().getProperty("interests_is")+this.getIntereses()+"\n");
		cad=cad+(Language.getInstance().getProperty("navigator_is")+this.getNavegador()+"\n");
		cad=cad+(Language.getInstance().getProperty("ncomments_is")+this.getComments()+"\n");
		cad=cad+(Language.getInstance().getProperty("karma_is") +this.getKarma()+"\n");
		cad=cad+(Language.getInstance().getProperty("points_is")+this.getPoints()+"\n");
		return cad;
	}
}
