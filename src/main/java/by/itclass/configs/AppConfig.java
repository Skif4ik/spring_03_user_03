package by.itclass.configs;

import by.itclass.model.entities.Address;
import by.itclass.model.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "by.itclass")
public class AppConfig {
    @Bean
    public ViewResolver viewResolverJsp() {
        var viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public Configuration configuration() {
        var configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);
        return configuration;
    }

    @Bean
    public SessionFactory factory(Configuration configuration) {
        var factory = configuration.buildSessionFactory();
        return factory;
    }
}
