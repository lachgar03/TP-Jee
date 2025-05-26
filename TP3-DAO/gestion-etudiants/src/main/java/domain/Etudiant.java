package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiants")
public class Etudiant {
	@Id
	private String code;
	private String nom;
	private String ville;
	private int age;
	
	public Etudiant() {};
	public Etudiant(String code,String nom,String ville,int age) {
		this.code=code;
		this.nom=nom;
		this.ville=ville;
		this.age=age;
	}
	public String getCode() {
		return code;
	}
	public String getNom() {
		return nom;
	}
	public String getVille() {
		return ville;
	}
	public int getAge() {
		return age;
	}
	
	public void setCode(String code) {
		this.code=code;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setVille(String ville) {
		this.ville=ville;
	}
	public void setAge(int age ) {
		this.age=age;
	}
}

