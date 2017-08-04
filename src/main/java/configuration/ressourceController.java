package configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ressourceController {
	
	@RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
	
}
