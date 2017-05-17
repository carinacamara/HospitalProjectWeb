package hospital.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import hospital.dao.ConsultationDAO;
import hospital.dao.ConsultationDAOImpl;
import hospital.dao.DoctorDAO;
import hospital.dao.DoctorDAOImpl;
import hospital.dao.PatientDAO;
import hospital.dao.PatientDAOImpl;
import hospital.dao.SecretaryDAO;
import hospital.dao.SecretaryDAOImpl;
import hospital.dao.UserDAO;
import hospital.dao.UserDAOImpl;


@Configuration
@ComponentScan("hospital/")
public class MvcConfig extends WebMvcConfigurerAdapter {


	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Hospital");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
    
	
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
	
	@Bean
	public SecretaryDAO getSecretaryDAO() {
		return new SecretaryDAOImpl(getDataSource());
	}
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImpl(getDataSource());
	}
	
	@Bean
	public DoctorDAO getDoctorDAO() {
		return new DoctorDAOImpl(getDataSource());
	}


	@Bean
	public PatientDAO getPatientDAO() {
		return new PatientDAOImpl(getDataSource());
	}

	@Bean
	public ConsultationDAO getConsultationDAO() {
		return new ConsultationDAOImpl(getDataSource());
	}

	
}