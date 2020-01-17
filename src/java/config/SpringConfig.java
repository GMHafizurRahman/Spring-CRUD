package config;

import controller.EmpHandeller;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import repository.EmpRepository;
import service.EmpService;

@EnableWebMvc
@Configuration
@ComponentScan({"controller", "repository", "service"})
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.html").addResourceLocations("/WEB-INF/html/");
        registry.addResourceHandler("/*.css").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/*.js").addResourceLocations("/WEB-INF/js/");

    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
//    }
    @Bean
    public EmpRepository getEmpRepositoryBean() {
        EmpRepository empRepository = new EmpRepository();
        return empRepository;
    }
    
    @Bean
    public EmpService getEmpServiceBean() {
        EmpService empService = new EmpService();
        empService.setEmpRepository(getEmpRepositoryBean());
        return empService;
    }
    
    @Bean
    public EmpHandeller getEmpHandellerBean() {
        EmpHandeller empHandeller = new EmpHandeller();
        empHandeller.setEmpService(getEmpServiceBean());
        return empHandeller;
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/s_emp");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        return jdbcTemplate;
    }

}
