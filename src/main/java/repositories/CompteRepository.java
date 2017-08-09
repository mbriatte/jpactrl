package repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {
	 
	  

}
