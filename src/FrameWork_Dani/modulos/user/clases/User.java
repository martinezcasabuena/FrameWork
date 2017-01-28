package FrameWork_Dani.modulos.user.clases;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import FrameWork_Dani.clases.Fecha;
import FrameWork_Dani.modulos.user.utils.Functions_date_user;

@XStreamAlias("user")
public abstract class User implements Comparable<User>,Serializable {
	//Atributos
		@XStreamAlias("nom")
		private String nom;
		@XStreamAlias("adreca")
		private String adreca;
		@XStreamAlias("edad")
		private int edad;
		@XStreamAlias("sexe")
		private String sexe;
		@XStreamAlias("dni")
		private String dni;
		@XStreamAlias("fnac")
		private Fecha fnac;
		
		public User(){
			
		}
		
		public String getNom(){
			return nom;	
		}
		
		public void setNom(String nom){
			this.nom=nom;
		}
		
		public String getAdreca(){
			return adreca;	
		}
		
		public void setAdreca(String adreca){
			this.adreca=adreca;
		}

		public String getSexe(){
			return sexe;
		}
		
		public void setSexe(String sexe){
			this.sexe=sexe;
		}
		
		public void setFechaNac(Fecha fnac){
			this.fnac=fnac;
		}
		
		public Fecha getFechaNac(){
			return this.fnac;
		}
		
		public String getDni(){
			return this.dni;	
		}
		
		public void setDni(String dni){
			this.dni=dni;
		}

		
		public int getEdad(){
			edad=Functions_date_user.CalcAge(fnac);
			return edad;
		}
		
		public User(String dni) {
			this.dni = dni;
		}
		
		public int compareTo(User param) {//para ordenar los empleados por nombre
			if(this.getDni().compareTo(param.getDni())>0)
				return 1;
			if(this.getDni().compareTo(param.getDni())<0)
				return -1;
			return 0;
		  }
		
		public boolean equals(Object param){
			return getDni().equals(((User)param).getDni());
		}	
		
		public abstract String toString();

}