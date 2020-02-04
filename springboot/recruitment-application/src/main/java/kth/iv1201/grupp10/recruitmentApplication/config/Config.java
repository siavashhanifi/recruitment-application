package kth.iv1201.grupp10.recruitmentApplication.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("kth.iv1201.grupp10.recruitmentApplication")
public class Config {
	
		@Bean
		public DataSource dataSource() {
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    dataSource.setUsername("iv1201ssb");
		    dataSource.setPassword("Grupp10ssb");
		    dataSource.setUrl("jdbc:sqlserver://recruitment-application-db.database.windows.net:1433;database=RecruitmentApplicationDB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		    return dataSource;
		}
		

}
