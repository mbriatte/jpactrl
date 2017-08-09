package model;

import javax.persistence.*;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
   	@GeneratedValue(strategy = GenerationType.AUTO) private
   	@Column(name="compte_id")
   	Long id;
 
   	@Column(nullable = false) private
   	String libelle;
    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
   	@Override
	public String toString(){
        String string = this.getId() +  ", " + this.getLibelle() ;
        return string;
    }
}
