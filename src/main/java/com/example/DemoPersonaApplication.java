package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoPersonaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(DemoPersonaApplication.class, args);

		//PersonaService personaService=context.getBean(PersonaService.class);

		//personaService.testPersonas();
		//accedemos a la red social i el testNetwork jugara
		SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);


		testSocialNetwork(socialNetworkService);


	}

	private static void testSocialNetwork(SocialNetworkService socialNetworkService) {
		Persona ivan = new Persona();
		ivan.setNombre("Ivan");
		ivan.setApellido("Merino");
		ivan.setEdad(23);

		Persona daniel = new Persona();
		daniel.setNombre("Daniel");
		daniel.setApellido("Sanchez");
		daniel.setEdad(25);

		Persona novia = new Persona();
		novia.setNombre("novia");
		novia.setEdad(21);


		socialNetworkService.addPersona(ivan);
		socialNetworkService.addPersona(daniel);
		socialNetworkService.addPersona(novia);

		socialNetworkService.añadirpareja(ivan, novia);

		System.out.println("La pareja de ivan es: ");
		System.out.println(socialNetworkService.getPareja(ivan));
	}
}
