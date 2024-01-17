package com.projekt.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Oznacza klasę jako punkt wejścia dla aplikacji Spring Boot
@SpringBootApplication
public class ProjektApplication {

	// Metoda główna, która jest wywoływana przy uruchomieniu aplikacji
	public static void main(String[] args) {

		// Uruchamia aplikację Spring Boot, przekazując klasę główną (ProjektApplication) i argumenty wiersza poleceń
		SpringApplication.run(ProjektApplication.class, args);
	}

}
