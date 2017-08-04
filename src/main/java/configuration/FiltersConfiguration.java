package configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class FiltersConfiguration implements Filter {

	@Value("${admin.port:8002}")
	private Integer adminPort;
	  
	@Override
	  public void doFilter(ServletRequest req, ServletResponse res,
	      FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		
		// grrrr!! je comprends pas ce qu'il se passe : il ne veut pas prendre en compte mon parametre admin port !
		//if ( request.getLocalPort() == adminPort )  {
		if ( request.getLocalPort() == 8002 ) {
			// c'est le port utilisé n'est pas celui dedié à admin, je rejette.
			chain.doFilter(request, res);			
		}
		else 			 {
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendError(404);
		}
	  }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Bean
    public FilterRegistrationBean ApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FiltersConfiguration());
        // In case you want the filter to apply to specific URL patterns only
        registration.addUrlPatterns("/admin/*");
        return registration;
    }

	
}
