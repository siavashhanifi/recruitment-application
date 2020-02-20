package kth.iv1201.grupp10.recruitmentApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author siavash hanifi
 * Starting point of the application
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer{

	/**
	 * Starts the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}