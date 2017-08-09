package configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Compte;
import service.ServiceCompte;

@RestController
@ComponentScan({"service"})
public class ressourceController {
	
	@Autowired
    ServiceCompte serviceCompte;
	
	@RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
	
	@RequestMapping("/comptes")
    public List<Compte> getAllComptes() {
		return serviceCompte.findAll();
		
    }
	
}
