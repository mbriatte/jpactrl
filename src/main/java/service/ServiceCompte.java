package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.Compte;
import repositories.CompteRepository;

@Component
public class ServiceCompte {

	@Autowired
    private CompteRepository compteRepository;
	
	public List<Compte> findAll()
	{
		List<Compte> list=new ArrayList<Compte>();
		compteRepository.findAll().forEach(compte-> list.add(compte));
		return list;
	}
}
