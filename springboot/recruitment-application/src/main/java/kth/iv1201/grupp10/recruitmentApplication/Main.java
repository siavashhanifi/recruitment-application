package kth.iv1201.grupp10.recruitmentApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Siavash Hanifi
 * Handles the startup of the application.
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer{

 /**
 * Starts up the application.
 * @param args
 */
public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

}