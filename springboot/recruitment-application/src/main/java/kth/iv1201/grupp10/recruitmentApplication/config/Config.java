package kth.iv1201.grupp10.recruitmentApplication.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Siavash
 * Handles the spring boot configuration.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("kth.iv1201.grupp10.recruitmentApplication")
public class Config {


}
