package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// this configures the mvc

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home"); // home page
        registry.addViewController("/").setViewName("home"); // also the home page
        registry.addViewController("/fibonacci").setViewName("fibonacci"); // the page with the input fields 
        registry.addViewController("/fibonacci2").setViewName("fibonacci2"); // the actual calculator
        registry.addViewController("/login").setViewName("login"); // login page
    }

}
