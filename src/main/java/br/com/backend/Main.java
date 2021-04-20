package br.com.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import br.com.backend.crud.DynamoDBConfig;

@SpringBootApplication
@Import({DynamoDBConfig.class})
public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("Inicializando...");
		System.setProperty("server.servlet.context-path", "/estoque");
		new SpringApplicationBuilder(Main.class).web(WebApplicationType.SERVLET).run(args);

	}

}
