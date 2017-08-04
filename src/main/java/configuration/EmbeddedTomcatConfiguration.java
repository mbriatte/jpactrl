package configuration;


import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.connector.Connector;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmbeddedTomcatConfiguration {
		
	@Value("${server.port}")
	private String serverPort;

	@Value("${server.additionalPorts:null}")
	private String additionalPorts;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		Connector[] additionalConnectors = this.additionalConnector();
		if (additionalConnectors != null && additionalConnectors.length > 0) {
			tomcat.addAdditionalTomcatConnectors(additionalConnectors);
		}
		return tomcat;
	}

	private Connector[] additionalConnector() {
		if (StringUtils.isBlank(this.additionalPorts)) {
			return null;
		}
		List<String> defaultPorts= new ArrayList<>();
		defaultPorts.add(this.serverPort);
		
		String[] ports = this.additionalPorts.split(",");
		List<Connector> result = new ArrayList<>();
		for (String port : ports) {
			if (!defaultPorts.contains(port)) {
				Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
				connector.setScheme("http");
				connector.setPort(Integer.valueOf(port));
				result.add(connector);
			}
		}
		return result.toArray(new Connector[] {});
	}


}
	
