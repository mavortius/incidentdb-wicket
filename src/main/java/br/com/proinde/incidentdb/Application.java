package br.com.proinde.incidentdb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
				.sources(Application.class)
                .run(args);
	}
}
