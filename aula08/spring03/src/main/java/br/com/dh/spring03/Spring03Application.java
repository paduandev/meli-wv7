package br.com.dh.spring03;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Log4j2
public class Spring03Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);
//		log.printf(Level.INFO, "Informação");
//		log.printf(Level.WARN, "Warning");
//		log.printf(Level.ERROR, "Erro");
	}

}
